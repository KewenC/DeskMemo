package com.kewenc.deskmemo.view;

import android.view.View;

/**
 * Created by KewenC on 2018/7/1.
 */

public interface MainInterface {

    /**
     * 初始化Toolbar
     */
    public void showToolbar();

    /**
     * 处理Fab点击事件
     * @param v Fab控件
     */
    public void showFloatingActionButton(View v);

    /**
     * 进入MemoFragment
     */
    public void enterMemoFragment();

    public void enterBirthdayFragment();
}
