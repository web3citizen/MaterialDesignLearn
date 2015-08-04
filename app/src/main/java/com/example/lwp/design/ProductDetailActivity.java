package com.example.lwp.design;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lwp.design.fragment.FragmentOne;
import com.example.lwp.design.fragment.FragmentThree;
import com.example.lwp.design.fragment.FragmentTwo;

/**
 * Created by clevo on 2015/7/30.
 */
public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout frontView, bottomView;
    private FloatingActionButton fab;
    private AnimatorSet showAnim,hiddenAnim;
    private long fWidth,fHeight, bHeight;
    private TextView tvCloseBottom;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Toolbar tb= (Toolbar) findViewById(R.id.tb_detail );
        tb.setNavigationIcon(R.mipmap.ic_arrow_back_white);


        fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        tvCloseBottom= (TextView) findViewById(R.id.tv_close_bottom);
        tvCloseBottom.setOnClickListener(this);

        ViewPager viewPager= (ViewPager) findViewById(R.id.view_pager_detail );
        MyPagerAdapter adapter=new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout= (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabsFromPagerAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        initView();

    }

    private void initView() {
        frontView = (LinearLayout) findViewById(R.id.front);
        ViewTreeObserver vto= frontView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                fWidth = frontView.getMeasuredWidth();
                fHeight = frontView.getMeasuredHeight();

            }
        });
        bottomView = (LinearLayout) findViewById(R.id.bottom );
        ViewTreeObserver sVto= bottomView.getViewTreeObserver();
        sVto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bHeight = bottomView.getMeasuredHeight();
                initShowAnim();
                initHiddenAnim();
            }
        });

    }

    private void initShowAnim(){
        ObjectAnimator fViewScaleXAnim=ObjectAnimator.ofFloat(frontView,"scaleX",1.0f,0.8f);
        fViewScaleXAnim.setDuration(350);
        ObjectAnimator fViewScaleYAnim=ObjectAnimator.ofFloat(frontView,"scaleY",1.0f,0.8f);
        fViewScaleYAnim.setDuration(350);
        ObjectAnimator fViewAlphaAnim=ObjectAnimator.ofFloat(frontView,"alpha",1.0f,0.5f);
        fViewAlphaAnim.setDuration(350);
        ObjectAnimator fViewRotationXAnim = ObjectAnimator.ofFloat(frontView, "rotationX", 0f, 10f);
        fViewRotationXAnim.setDuration(200);
        ObjectAnimator fViewResumeAnim = ObjectAnimator.ofFloat(frontView, "rotationX", 10f, 0f);
        fViewResumeAnim.setDuration(150);
        fViewResumeAnim.setStartDelay(200);
        ObjectAnimator fViewTransYAnim=ObjectAnimator.ofFloat(frontView,"translationY",0,-0.1f* fHeight);
        fViewTransYAnim.setDuration(350);
        ObjectAnimator sViewTransYAnim=ObjectAnimator.ofFloat(bottomView,"translationY", bHeight,0);
        sViewTransYAnim.setDuration(350);
        sViewTransYAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                bottomView.setVisibility(View.VISIBLE);
            }
        });
        showAnim=new AnimatorSet();
        showAnim.playTogether(fViewScaleXAnim,fViewRotationXAnim,fViewResumeAnim,fViewTransYAnim,fViewAlphaAnim,fViewScaleYAnim,sViewTransYAnim);
    }

    private void initHiddenAnim(){
        ObjectAnimator fViewScaleXAnim=ObjectAnimator.ofFloat(frontView,"scaleX",0.8f,1.0f);
        fViewScaleXAnim.setDuration(350);
        ObjectAnimator fViewScaleYAnim=ObjectAnimator.ofFloat(frontView,"scaleY",0.8f,1.0f);
        fViewScaleYAnim.setDuration(350);
        ObjectAnimator fViewAlphaAnim=ObjectAnimator.ofFloat(frontView,"alpha",0.5f,1.0f);
        fViewAlphaAnim.setDuration(350);
        ObjectAnimator fViewRotationAnim = ObjectAnimator.ofFloat(frontView, "rotationX",0f, 10f);
        fViewRotationAnim.setDuration(150);
        ObjectAnimator fViewResumeAnim = ObjectAnimator.ofFloat(frontView, "rotationX",10f, 0f);
        fViewResumeAnim.setDuration(200);
        fViewResumeAnim.setStartDelay(150);
        ObjectAnimator fViewTransYAnim=ObjectAnimator.ofFloat(frontView,"translationY",-fHeight *0.1f,0);
        fViewTransYAnim.setDuration(350);
        ObjectAnimator sViewTransYAnim=ObjectAnimator.ofFloat(bottomView,"translationY",0, bHeight);
        sViewTransYAnim.setDuration(350);
        sViewTransYAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                bottomView.setVisibility(View.INVISIBLE);
            }
        });
        hiddenAnim=new AnimatorSet();
        hiddenAnim.playTogether(fViewScaleXAnim, fViewAlphaAnim,fViewRotationAnim,fViewResumeAnim, fViewScaleYAnim,fViewTransYAnim, sViewTransYAnim);
        hiddenAnim.setDuration(350);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==fab.getId()){
            showAnim.start();
        }else if(v.getId()==tvCloseBottom.getId()){
            hiddenAnim.start();
        }

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter{


        private MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:return FragmentOne.newInstance();
                case 1:return FragmentTwo.newInstance();
                case 2:return FragmentThree.newInstance();
                default:return FragmentOne.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:return "评论";
                case 1:return "照片参数";
                case 2:return "其他照片推荐";
                default:return "评论";
            }
        }
    }
}
