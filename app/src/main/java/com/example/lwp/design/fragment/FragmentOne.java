package com.example.lwp.design.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lwp.design.R;
import com.example.lwp.design.adapter.FragmentRecyclerAdapter;

/**
 * Created by clevo on 2015/7/30.
 */
public class FragmentOne extends Fragment {


    public static FragmentOne newInstance(){
        return new FragmentOne();
    }


    public FragmentOne() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.detail_fragment_one,container,false );
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recycler_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FragmentRecyclerAdapter adapter=new FragmentRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }


}
