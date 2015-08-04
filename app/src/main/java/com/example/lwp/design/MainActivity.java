package com.example.lwp.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lwp.design.ui.masonry.MasonryAdapter;
import com.example.lwp.design.ui.masonry.Product;
import com.example.lwp.design.ui.masonry.RecycleItemClickListener;
import com.example.lwp.design.ui.masonry.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private List<Product> productList;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //set drawlayout
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);

        //set a toolbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("首页");
//        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);

        //set recycleview
        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        initData();
        RecycleItemClickListener itemClickListener=new RecycleItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Log.e("position","="+position);
//                Toast.makeText(MainActivity.this, productList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,ProductDetailActivity.class);
                startActivity(intent);
            }
        };
        MasonryAdapter adapter=new MasonryAdapter(productList,itemClickListener);
        recyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.home_tb_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private void initData() {
        productList=new ArrayList<Product>();
        Product p1=new Product(R.mipmap.p1,"我是照片1");
        productList.add(p1);
        Product p2=new Product(R.mipmap.p2,"我是照片2");
        productList.add(p2);
        Product p3=new Product(R.mipmap.p3,"我是照片3");
        productList.add(p3);
        Product p4=new Product(R.mipmap.p4,"我是照片4");
        productList.add(p4);
        Product p5=new Product(R.mipmap.p5,"我是照片5");
        productList.add(p5);
        Product p6=new Product(R.mipmap.p6,"我是照片6");
        productList.add(p6);
        Product p7=new Product(R.mipmap.p2,"我是照片7");
        productList.add(p7);
        Product p8=new Product(R.mipmap.p1,"我是照片8");
        productList.add(p8);
        Product p9=new Product(R.mipmap.p4,"我是照片9");
        productList.add(p9);
        Product p10=new Product(R.mipmap.p6,"我是照片10");
        productList.add(p10);
        Product p11=new Product(R.mipmap.p3,"我是照片11");
        productList.add(p11);

    }


}
