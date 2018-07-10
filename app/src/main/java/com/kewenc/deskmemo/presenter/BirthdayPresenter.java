package com.kewenc.deskmemo.presenter;

import android.content.Context;

import com.kewenc.deskmemo.view.BirthdayInterface;

/**
 * Created by KewenC on 2018/7/2.
 */

public class BirthdayPresenter extends BasePresenter<BirthdayInterface>{

    private final BirthdayInterface birthdayInterface;
    private final Context context;

    public BirthdayPresenter(BirthdayInterface birthdayInterface, Context context){
        this.birthdayInterface = birthdayInterface;
        this.context = context;
    }
}
