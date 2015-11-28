package com.example.lwp.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lwp.design.adapter.FragmentRecyclerAdapter;

/**
 * Created by clevo on 2015/9/12.
 */
public class BehaviorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * zhihu_behavior_activity  知乎效果
         *jianshu_behavior_activity 简书效果
         */
        setContentView(R.layout.jianshu_behavior_activity);
        recyclerView= (RecyclerView) findViewById(R.id.rv_behavior);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FragmentRecyclerAdapter adapter=new FragmentRecyclerAdapter();
        recyclerView.setAdapter(adapter);

    }
}
