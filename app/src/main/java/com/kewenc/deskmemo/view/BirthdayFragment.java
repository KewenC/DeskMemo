package com.kewenc.deskmemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kewenc.deskmemo.R;
import com.kewenc.deskmemo.presenter.BaseFragment;
import com.kewenc.deskmemo.presenter.BirthdayPresenter;

/**
 * Created by KewenC on 2018/7/2.
 */

public class BirthdayFragment extends BaseFragment<BirthdayInterface,BirthdayPresenter>
        implements BirthdayInterface {
    private BirthdayPresenter birthdayPresenter;

    @Override
    protected BirthdayPresenter createPresenter() {
        birthdayPresenter = new BirthdayPresenter(this,getContext());
        return birthdayPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_birthday,container,false);
        return view;
    }


}
