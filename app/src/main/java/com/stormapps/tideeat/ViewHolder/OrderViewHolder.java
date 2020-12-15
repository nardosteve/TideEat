package com.stormapps.tideeat.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stormapps.tideeat.Interface.ItemClickListener;
import com.stormapps.tideeat.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtOrderId;
    public TextView txtOrderStatus;
    public TextView txtOrderPhone;
    public TextView txtOrderAddress;

    private ItemClickListener itemClickListener;



    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        txtOrderId = (TextView)itemView.findViewById(R.id.order_id);
        txtOrderStatus = (TextView)itemView.findViewById(R.id.order_status);
        txtOrderPhone = (TextView)itemView.findViewById(R.id.order_phone);
        txtOrderAddress = (TextView)itemView.findViewById(R.id.order_address);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }

}
