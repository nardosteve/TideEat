package com.stormapps.tideeat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.stormapps.tideeat.Common.Common;
import com.stormapps.tideeat.Interface.ItemClickListener;
import com.stormapps.tideeat.Model.Food;
import com.stormapps.tideeat.Model.Order;
import com.stormapps.tideeat.Model.Request;
import com.stormapps.tideeat.ViewHolder.FoodViewHolder;
import com.stormapps.tideeat.ViewHolder.OrderViewHolder;

public class OrderStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Request, OrderViewHolder> adapter;
    FirebaseDatabase database;
    DatabaseReference request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        //Firebase connection
        database = FirebaseDatabase.getInstance();
        request = database.getReference("Requests");

        recyclerView = (RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadOrders(Common.currentUser.getPhone());

    }

    //Creating method loadOrders
    public void loadOrders(String Phone){

        FirebaseRecyclerOptions<Request> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<Request>().setQuery(request.orderByChild("phone").equalTo(Phone), Request.class).build();
        adapter = new FirebaseRecyclerAdapter<Request, OrderViewHolder>(firebaseRecyclerOptions) {

            @Override
            protected void onBindViewHolder(@NonNull OrderViewHolder holder, int position, @NonNull Request model) {
                holder.txtOrderId.setText(adapter.getRef(position).getKey());
                holder.txtOrderStatus.setText(convertCodeToStatus(model.getStatus()));
                holder.txtOrderAddress.setText(model.getAddress());
                holder.txtOrderPhone.setText(model.getPhone());
            }

            @NonNull
            @Override
            public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

        };
        recyclerView.setAdapter(adapter);

    }

    private String convertCodeToStatus(String status){

        if(status.equals("0"))
            return "Place";
        else if(status.equals("1"))
            return "On it's way!";
        else
            return "Shipped";

    }
}