package com.kewenc.deskmemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kewenc.deskmemo.R;
import com.kewenc.deskmemo.presenter.BaseFragment;
import com.kewenc.deskmemo.presenter.MemoPresenter;

/**
 * Created by KewenC on 2018/7/2.
 */

public class MemoFragment extends BaseFragment<MemoInterface,MemoPresenter>
        implements MemoInterface {
    private MemoPresenter memoPresenter;

    @Override
    protected MemoPresenter createPresenter() {
        memoPresenter = new MemoPresenter(this,getContext());
        return memoPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_memo,container,false);
        return view;
    }
}
