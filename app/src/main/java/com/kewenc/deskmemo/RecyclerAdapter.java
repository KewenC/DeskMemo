package com.kewenc.deskmemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.removeAllViews();
        int Type = dataType.get(position);
        if (Type == 0){
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            holder.editText.setText(data.get(0));
            holder.itemView.addView(holder.editText,layoutParams);
        } else if (Type == 1){
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
            holder.itemView.addView(holder.imageView, layoutParams);
        } else {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
            holder.itemView.addView(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private EditText editText;
        private ImageView imageView;
        private RelativeLayout itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            ViewHolder.this.itemView = (RelativeLayout) itemView;
            editText = new EditText(itemView.getContext());
            imageView = new ImageView(itemView.getContext());
//            textView.setVisibility(View.GONE);
//            editText.setVisibility(View.GONE);
//            imageView.setVisibility(View.GONE);
//            textView = new TextView(itemView.getContext());
//            ViewHolder.this.itemView.addView(textView);
//            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null){
                onItemClickListener.onItemClick(v,getAdapterPosition());
            }
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnTtemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

}
