package com.example.lwp.design.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

/**
 * QQ  淘宝透明栏渐变效果
 * Created by clevo on 2015/9/15.
 */
public class QqBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    public QqBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Toolbar child, View dependency) {
        if (dependency instanceof AppBarLayout) {
            float ratio = (float) getCurrentScrollValue(child, dependency) / getTotalScrollRange(child, dependency);
            float alpha = 1f - Math.min(1f, Math.max(0f, ratio));
            int drawableAlpha = (int) (alpha * 255);
            child.getBackground().setAlpha(drawableAlpha);
            parent.getStatusBarBackground().setAlpha(drawableAlpha);
        }
        return false;
    }

    private int getCurrentScrollValue(Toolbar child, View dependency) {
        return dependency.getBottom() - child.getTop();
    }

    private float getTotalScrollRange(Toolbar child, View dependency) {
        return ((AppBarLayout) dependency).getTotalScrollRange() - child.getTop();
    }
}
