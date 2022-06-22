package com.lqd.androidpractice.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.lqd.androidpractice.R;
import com.lqd.utils.ThreadHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RecyclerviewTestActivity extends AppCompatActivity {

    private int position;
    TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_test);


        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        new PagerSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        MyLayoutManager layoutManager = new MyLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        layoutManager.setRecycleChildrenOnDetach(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TestAdapter();
        ArrayList arrayList = new ArrayList<String>();
        arrayList.add("111");
        arrayList.add("222");
        arrayList.add("333");
        arrayList.add("444");
        arrayList.add("555");
        arrayList.add("666");
        arrayList.add("777");
        arrayList.add("888");
        arrayList.add("999");
        adapter.setDatas(arrayList);
        recyclerView.setAdapter(adapter);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {

//                    recyclerView.scrollToPosition(position);
                    adapter.change();
                    Log.d("#####", "scroll position ---> " + position);
                    position++;
                    if(position > arrayList.size()) {
                        position = 0;
                    }
                });
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000, 1000);





    }
}