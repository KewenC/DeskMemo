package com.kewenc.deskmemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kewenc.deskmemo.R;
import com.kewenc.deskmemo.RecyclerAdapter;
import com.kewenc.deskmemo.presenter.AddMemoPresenter;
import com.kewenc.deskmemo.presenter.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class AddMemoActivity extends BaseActivity<AddMemoInterface, AddMemoPresenter>
        implements AddMemoInterface ,View.OnClickListener{
    private AddMemoPresenter addMemopresenter;
    private Toolbar toolBar;
    private RecyclerView recView;
    private RecyclerAdapter recyclerAdapter;
    private AppCompatButton btnEdit, btnImage, btnVoice, btnVideo;
    private List<String> data = new ArrayList<>();
    private List<Integer> dataType = new ArrayList<>();

    @Override
    protected AddMemoPresenter createPresenter() {
        addMemopresenter = new AddMemoPresenter(this, this);
        return addMemopresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_add);
        initViews();
        addMemopresenter.AddEdit(data, dataType);
    }

    private void initViews() {
        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);

        btnEdit = findViewById(R.id.btnEdit);
        btnImage = findViewById(R.id.btnImage);
        btnVoice = findViewById(R.id.btnVoice);
        btnVideo = findViewById(R.id.btnVideo);
        btnEdit.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        btnVoice.setOnClickListener(this);
        btnVideo.setOnClickListener(this);

        recView = findViewById(R.id.recView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(linearLayoutManager);
        recView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter(data, dataType);
        recView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnEdit:
                addMemopresenter.AddEdit(data, dataType);
                break;
                case R.id.btnImage:
                addMemopresenter.AddImage(data, dataType);
                break;
            case R.id.btnVoice:
                addMemopresenter.AddVoice(data, dataType);
                break;
            case R.id.btnVideo:
                addMemopresenter.AddVideo(data, dataType);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_memo_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_more:
                Toast.makeText(this,"菜单",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void refresh(int size) {
        if (size > 0){
            recyclerAdapter.notifyDataSetChanged();
            recView.scrollToPosition(size - 1);
        }
    }
}
