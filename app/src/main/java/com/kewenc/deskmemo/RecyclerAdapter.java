/*
 * Copyright (c) 18-7-18 下午12:32 Author@KewenC
 */

package com.kewenc.deskmemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
        Log.e("TAGF","position = "+position);
        holder.itemView.removeAllViews();
        int type = dataType.get(position);
        if (type == 0){
//            holder.editText.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
           if (holder.editText.getTag() instanceof TextWatcher){
               holder.editText.removeTextChangedListener((TextWatcher) holder.editText.getTag());
            }
            holder.editText.setText(data.get(position));
            TextWatcher watcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) { }

                @Override
                public void afterTextChanged(Editable s) {
//                    Log.e("TAGF","afterTextChanged"+position+"__"+s.toString());
                    data.set(position, s.toString());
//                    if (onItemClickListener != null){
//                        onItemClickListener.refreshData(s.toString(), position);
//                    }
                }
            };
            holder.editText.addTextChangedListener(watcher);
            holder.editText.setTag(watcher);
            holder.itemView.addView(holder.editText,layoutParams);
            if (position == (getItemCount()-1)){
                holder.editText.requestFocus();
            }
        } else if (type == 1){
//            holder.imageView.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            File file = new File(data.get(position));
//            Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
            Uri uri = Uri.parse(data.get(position));
            holder.imageView.setImageURI(uri);
            holder.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
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
//            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            ViewHolder.this.itemView.addView(editText,layoutParams);
//            ViewHolder.this.itemView.addView(imageView,layoutParams);
//            editText.setVisibility(View.GONE);
//            imageView.setVisibility(View.GONE);
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
