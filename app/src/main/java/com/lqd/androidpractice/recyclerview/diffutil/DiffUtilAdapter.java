package com.lqd.androidpractice.recyclerview.diffutil;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lqd.androidpractice.R;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: a564
 * @Date 2021/7/22
 */
public class DiffUtilAdapter extends RecyclerView.Adapter<DiffUtilAdapter.MyViewHolder> {


    private List<User> datas;

    public void setDatas(List<User> datas) {
        this.datas = datas;
    }


    public void swap(List<User> list) {
        List newList = list;
        newList.set(3, new User(11, "zhangsan11"));
        MyDiffCallback callback = new MyDiffCallback(datas, newList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);

        datas.clear();
        datas.addAll(newList);
        result.dispatchUpdatesTo(this);
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_user, parent, false);
        Log.d("DiffUtilAdapter", "onCreateViewHolder  ----->text_row_item");
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Log.d("DiffUtilAdapter", "bind   ===="  + position);
        holder.textView.setText(datas.get(position).name);
        holder.idTextView.setText(""+datas.get(position).id);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final TextView idTextView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.text_view);
            idTextView = (TextView) itemView.findViewById(R.id.id_txt);
        }
    }


    class MyDiffCallback extends DiffUtil.Callback {
        List<User> oldList;
        List<User> newList;

        public MyDiffCallback(List<User> oldList, List<User> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            User oldItem = oldList.get(oldItemPosition);
            User newItem = newList.get(oldItemPosition);
            if(oldItem==null || newItem==null)
                return false;

            Log.d("MyDiffCallback", "areItemsTheSame" + oldList.get(oldItemPosition).toString() + "-------" + newList.get(newItemPosition));
            return oldList.get(oldItemPosition).id == newList.get(newItemPosition).id;
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            User oldItem = oldList.get(oldItemPosition);
            User newItem = newList.get(oldItemPosition);
            if(oldItem==null || newItem==null)
                return false;

            Log.d("MyDiffCallback", "areContentsTheSame" + oldList.get(oldItemPosition).toString() + "-------" + newList.get(newItemPosition));
            return oldList.get(oldItemPosition).name == newList.get(newItemPosition).name;
        }
    }
}


