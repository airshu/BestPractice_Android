package com.lqd.androidpractice.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqd.androidpractice.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author: a564
 * @Date 2021/7/14
 */
class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private final static String TAG = "TestAdapter";
    private List<String> datas;


    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    public void change() {

        String item = datas.remove(0);
        notifyItemRemoved(0);

        int last = datas.size()-1;
        datas.add(last, item);
        notifyItemInserted(last);
    }

    @NotNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);
        Log.d(TAG, "onCreateViewHolder  ----->text_row_item");
        return new TestViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TestViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;


        public TestViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.text_view);

        }

        public TextView getTextView() {
            return textView;
        }

    }
}
