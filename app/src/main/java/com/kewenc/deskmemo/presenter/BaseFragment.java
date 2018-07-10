package com.kewenc.deskmemo.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by KewenC on 2018/7/2.
 */

public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment{
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract T createPresenter();
}
