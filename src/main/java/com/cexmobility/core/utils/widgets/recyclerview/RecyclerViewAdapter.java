package com.cexmobility.core.utils.widgets.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter<T, R extends RecyclerViewHolder> extends RecyclerView.Adapter<R> {

    private List<T> itemList;
    private OnItemClickListener<T> onItemClickListener;
    private int resourceRow;

    public RecyclerViewAdapter(@LayoutRes int resourceRow, List<T> itemList) {
        this.resourceRow = resourceRow;
        this.itemList = itemList;
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public R onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(resourceRow,
                parent, false);
        return (R) new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull R holder, int position) {
        holder.getBaseView().setOnClickListener(view -> {
            onItemClickListener.onItemClick(itemList.get(holder.getAdapterPosition()));
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface OnItemClickListener<T> {
        void onItemClick(T item);
    }

}
