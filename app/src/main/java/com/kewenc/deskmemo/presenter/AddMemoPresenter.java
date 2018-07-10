package com.kewenc.deskmemo.presenter;

import android.content.Context;
import com.kewenc.deskmemo.view.AddMemoInterface;

import java.util.List;

public class AddMemoPresenter extends BasePresenter<AddMemoInterface> {

    private final AddMemoInterface addMemoInterface;
    private final Context context;

    public AddMemoPresenter(AddMemoInterface addMemoInterface, Context context){
        this.addMemoInterface = addMemoInterface;
        this.context = context;
    }

    public void AddEdit(List<String> data, List<Integer> dataType){
        data.add("EditView");
        dataType.add(0);
        addMemoInterface.refresh(data.size());
    }

    public void AddImage(List<String> data, List<Integer> dataType){
        data.add("");
        dataType.add(1);
        addMemoInterface.refresh(data.size());
    }

    public void AddVoice(List<String> data, List<Integer> dataType){
        data.add("");
        dataType.add(2);
        addMemoInterface.refresh(data.size());
    }

    public void AddVideo(List<String> data, List<Integer> dataType){
        data.add("");
        dataType.add(3);
        addMemoInterface.refresh(data.size());
    }
}
