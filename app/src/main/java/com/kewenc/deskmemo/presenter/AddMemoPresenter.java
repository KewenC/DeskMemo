package com.kewenc.deskmemo.presenter;

import android.content.Context;
import android.util.Log;

import com.kewenc.deskmemo.util.AnalysisDataUtil;
import com.kewenc.deskmemo.view.AddMemoInterface;

import java.util.List;

import static com.kewenc.deskmemo.util.AnalysisDataUtil.KCIMG_MARK;
import static com.kewenc.deskmemo.util.AnalysisDataUtil.KCTXT_MARK;
import static com.kewenc.deskmemo.util.AnalysisDataUtil.KCVID_MARK;
import static com.kewenc.deskmemo.util.AnalysisDataUtil.KCVOI_MARK;

public class AddMemoPresenter extends BasePresenter<AddMemoInterface> {

    private final AddMemoInterface addMemoInterface;
    private final Context context;

    public AddMemoPresenter(AddMemoInterface addMemoInterface, Context context){
        this.addMemoInterface = addMemoInterface;
        this.context = context;
    }

    public void  AddEdit(List<String> data, List<Integer> dataType, String str){
        data.add(str);
        dataType.add(KCTXT_MARK);
        addMemoInterface.refresh(data.size());
    }

    public void AddImage(List<String> data, List<Integer> dataType, String str){
        data.add(str);
        dataType.add(KCIMG_MARK);
        addMemoInterface.refresh(data.size());
    }

    public void AddVoice(List<String> data, List<Integer> dataType, String str){
        data.add(str);
        dataType.add(KCVOI_MARK);
        addMemoInterface.refresh(data.size());
    }

    public void AddVideo(List<String> data, List<Integer> dataType, String str){
        data.add(str);
        dataType.add(KCVID_MARK);
        addMemoInterface.refresh(data.size());
    }

    public void saveData(List<String> data, List<Integer> dataType) {
        AnalysisDataUtil analysisDataUtil = new AnalysisDataUtil();
        analysisDataUtil.setData(data, dataType);
        Log.e("TAGF",analysisDataUtil.setData(data, dataType));
        //Model 保存数据到数据库中

    }
}
