package com.kewenc.deskmemo.presenter;

import android.content.Context;

import com.kewenc.deskmemo.view.MemoInterface;

/**
 * Created by KewenC on 2018/7/1.
 */

public class MemoPresenter extends BasePresenter<MemoInterface>{

    private final MemoInterface memoInterface;
    private final Context context;

    public MemoPresenter(MemoInterface memoInterface, Context context){
        this.memoInterface = memoInterface;
        this.context = context;
    }
}
