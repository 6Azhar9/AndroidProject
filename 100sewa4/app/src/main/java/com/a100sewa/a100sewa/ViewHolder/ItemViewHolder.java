package com.a100sewa.a100sewa.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yamun on 02/02/2018.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView item_Name;
    public ImageView item_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ItemViewHolder(View itemView) {
        super(itemView);

        item_Name = (TextView)itemView.findViewById(R.id.item_Name);
        item_image=(ImageView)itemView.findViewById(R.id.item_image);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
