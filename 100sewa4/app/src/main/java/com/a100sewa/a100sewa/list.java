package com.a100sewa.a100sewa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.a100sewa.a100sewa.Model.Item;
import com.a100sewa.a100sewa.ViewHolder.ItemViewHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class list extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference list;

    String categoryId=""
    FirebaseRecyclerAdapter<list,itemViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        database = FirebaseDatabase.getInstance();
        list = database.getReference("item");
        recyclerView = (RecyclerView)findViewById(R.id.recycler_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent()!=null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if (!categoryId.isEmpty()&& categoryId!=null)
        {
            loadListlist(categoryId);
        }
    }

    private void loadListlist(String categoryId){
        adapter = new
    }
    adapter=new FirebaseRecyclerAdapter<list,itemViewHolder>(list.class,
        R.layout.list_item,
                ItemViewHolder.class,
               list.orderByChild("MenuId".equalTo(categoryId))
}

        @Override
                protected void populatedViewHolder(itemViewHolder viewHolder,model,int position){
             viewHolder.list_name.setText(model.getName());
             picasso.with(getBaseContext()).load(model.getImage)
                     .into(viewHolder.item_image);

            final list local=model;
            viewHolder.setItemClickListener(new AdapterView.ItemClickListener(){
                @Override
                public void onClick(View view,int position,boolean isLongClick){
                    Intent ItemDetails =new Intent(list.this,ItemDetalis.class)
                    ItemDetails.putExtra("ItemId",adapter.getRef(position).getkey());
                    startActivities(ItemDetails);

        }
        recyclerView.setAdapter(adapter);
    }
}
