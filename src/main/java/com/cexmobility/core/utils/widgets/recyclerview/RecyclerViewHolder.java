package com.cexmobility.core.utils.widgets.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    View getBaseView() {
        return itemView;
    }

}
