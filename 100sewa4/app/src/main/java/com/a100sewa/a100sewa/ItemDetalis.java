package com.a100sewa.a100sewa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.a100sewa.a100sewa.Model.Item;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ItemDetalis extends AppCompatActivity {

    TextView item_name,item_price,item_description;
    ImageView item_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btncart;
    ElegantNumberButton numberButton;

    string itemId="";

    FirebaseDatabase database;
    DatabaseReference item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detalis);

        database=FirebaseDatabase.getInstance();
        item=database.getReference("items");

        numberButton=(ElegantNumberButton)findViewById(R.id.number_button);
        btncart=(FloatingActionButton)findViewById(R.id.btnCart);
        item_description=(TextView)findViewById(R.id.item_description);
        item_name=(TextView)findViewById(R.id.item_name);
        item_price=(TextView)findViewById(R.id.item_price);
        item_image=(TextView)findViewById(R.id.item_image);

        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout=(CollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapseAppbar);

        if(getIntent() !=null)
            itemId=getIntent().getStringExtra("itemId");
        if(!itemId.isEmpty())
        {
            getDetailitem(itemId);

        }

    }

    private void getDetailitem(string itemId) {
        item.child(itemId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Item item=dataSnapshot.getValue(Item.class);

                picasso.with(getBaseContext()).load(item.getImage())
                        .into(item_image);
                collapsingToolbarLayout.setTitle(item_name);
                item_price.setText(item.getPrice());
                item_name.setText(item.getName());
                item_description.setText(item.getDescription());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
