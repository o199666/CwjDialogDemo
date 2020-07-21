package com.cwj.cwjdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * author : ChenWenJie
 * email  :1181620038@qq.com
 * date   : 2020/7/20
 * desc   : adapter适配器。
 */
public class BottomDialogAdapter extends RecyclerView.Adapter<BottomDialogAdapter.MyHolder> {

    private List<String> mData;
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private int color;
    private int size;

    public BottomDialogAdapter(List<String> mData, Context context,int color,int size, OnItemClickListener mOnItemClickListener) {
        this.mData = mData;
        this.context = context;
        this.mOnItemClickListener = mOnItemClickListener;
        this.color = color;
        this.size = size;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bottom, parent, false);
        return new MyHolder(view);

    }

    public void setOnItemClickListener(BottomDialogAdapter.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.mTextView.setText(mData.get(position));
        holder.mTextView.setTextSize(size);
        holder.mTextView.setTextColor(context.getResources().getColor(color));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                mOnItemClickListener.onItemClick(holder.itemView, pos);
            }
        });

//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                int pos = holder.getLayoutPosition();
//                mOnItemClickListener.onItemLongClick(holder.itemView, pos);
//                return false;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);

//        void onItemLongClick(View view, int position);
    }
}
