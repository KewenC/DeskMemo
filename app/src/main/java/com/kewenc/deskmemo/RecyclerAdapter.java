/*
 * Copyright (c) 18-7-18 下午12:32 Author@KewenC
 */

package com.kewenc.deskmemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private final List<String> data;
    private final List<Integer> dataType;
    private OnItemClickListener onItemClickListener;

    public RecyclerAdapter(List<String> data, List<Integer> dataType){
        this.data = data;
        this.dataType = dataType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_memo_add_recycler_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
//        TextView textView = new TextView(holder.itemView.getContext());

        holder.itemView.removeAllViews();
        int type = dataType.get(position);
        Log.e("TAGF","position = "+position);
        if (type == 0){
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            holder.editText.setText(data.get(position));
            holder.editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Log.e("TAGF","onTextChanged_"+position+"__"+String.valueOf(s));
                    data.set(position, String.valueOf(s));
                    if (onItemClickListener != null){
                        onItemClickListener.refreshData(String.valueOf(s), position);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            holder.itemView.addView(holder.editText,layoutParams);
        } else if (type == 1){
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            File file = new File(data.get(position));
            Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
            holder.imageView.setImageBitmap(bitmap);
            holder.itemView.addView(holder.imageView, layoutParams);
        } else if(type == 2){

        } else if (type == 3){

        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private EditText editText;
        private ImageView imageView;
        private RelativeLayout itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            ViewHolder.this.itemView = (RelativeLayout) itemView;
            editText = new EditText(itemView.getContext());
            imageView = new ImageView(itemView.getContext());
        }
//
//        @Override
//        public void onClick(View v) {
//            if (onItemClickListener != null){
//                onItemClickListener.onItemClick(v,getAdapterPosition());
//            }
//        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void refreshData(String str, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

}
