package com.kewenc.deskmemo.presenter;

import android.content.Context;
import android.view.View;

import com.kewenc.deskmemo.view.MainInterface;

/**
 * Created by KewenC on 2018/7/1.
 */

public class MainPresenter extends BasePresenter<MainInterface>{
    private final MainInterface mainInterface;
    private final Context context;

    public MainPresenter(MainInterface mainInterface, Context context){
        this.mainInterface = mainInterface;
        this.context = context;
    }

    /**
     * 初始化Toolbar
     */
    public void showToolbar(){
        mainInterface.showToolbar();
    }

    /**
     * 处理Fab点击事件
     * @param v Fab控件
     */
    public void showFloatingActionButton(View v){
        mainInterface.showFloatingActionButton(v);
    }

    public void enterMemoFragment() {
        mainInterface.enterMemoFragment();
    }

    public void enterBirthdayFragment() {
        mainInterface.enterBirthdayFragment();
    }
}
