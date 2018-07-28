/*
 * Copyright (c) 18-7-29 上午2:24 Author@KewenC
 */

package com.kewenc.deskmemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

@Deprecated
public class ScaleWidthImageView extends android.support.v7.widget.AppCompatImageView {
    public ScaleWidthImageView(Context context) {
        super(context);
    }

    public ScaleWidthImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Drawable d = getDrawable();

        if(d!=null){
            // ceil not round - avoid thin vertical gaps along the left/right edges
            int width = MeasureSpec.getSize(widthMeasureSpec);
            //高度根据使得图片的宽度充满屏幕计算而得
            int height = (int) Math.ceil((float) width * (float) d.getIntrinsicHeight() / (float) d.getIntrinsicWidth());
            setMeasuredDimension(width, height);
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }
}
