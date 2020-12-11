package com.stormapps.tideeat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.stormapps.tideeat.Model.Food;

public class FoodDetail extends AppCompatActivity {

    private TextView food_name;
    private TextView food_price;
    private TextView food_description;

    private ImageView food_image;

    CollapsingToolbarLayout collapsingToolbarLayout;

    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String foodId = "";

    FirebaseDatabase database;
    DatabaseReference food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //Connection to the DB
        database = FirebaseDatabase.getInstance();
        food = database.getReference("Foods");

        numberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        btnCart = (FloatingActionButton) findViewById(R.id.btnCart);


        food_name = (TextView) findViewById(R.id.food_name);
        food_price = (TextView) findViewById(R.id.food_price);
        food_description = (TextView) findViewById(R.id.food_description);
        food_image = (ImageView) findViewById(R.id.img_food);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //Get foodId from intent
        if(getIntent() != null)
           foodId = getIntent().getStringExtra("FoodId");
        if(!foodId.isEmpty()){
            getDetailFood(foodId);
        }
    }

    //Creating a method
    private void getDetailFood(String foodId){

        food.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Food food = snapshot.getValue(Food.class);

                //Get image
                Picasso.with(getBaseContext()).load(food.getImage())
                        .into(food_image);

                collapsingToolbarLayout.setTitle(food.getName());
                food_price.setText(food.getPrice());
                food_name.setText(food.getName());
                food_description.setText(food.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}