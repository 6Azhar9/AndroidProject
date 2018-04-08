package com.a100sewa.a100sewa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.a100sewa.a100sewa.Interface.itemclicklistener;
import com.a100sewa.a100sewa.Model.Category;
import com.a100sewa.a100sewa.ViewHolder.MenuViewHolder;
import com.a100sewa.a100sewa.common.common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Home0 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseDatabase database;
    DatabaseReference category;

    TextView txtFullName;

    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Category, MenuViewHolder> adapter;
    @Override
    protected void onCreate.layout.activity_home0);


    Toolbar toolbaeate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(r = (Toolbar) findViewById(R.id.toolbar);
        Toolbar toolbar =("Menu");
        setSupportActionBar(toolbar);

        database=FirebaseDatabase.getInstance();
        category=database.getReference("Category");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        txtFullName=(TextView)findViewById(R.id.txtFullName);
        txtFullName.setText(common.currentUser.getName());

        recycler_menu = (RecyclerView)findViewById(R.id.recycler_menu);
        recycler_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_menu.setLayoutManager();

        loadMenu();
    }

    private void loadMenu() {

        adapter = new FirebaseRecyclerAdapter<Category, MenuViewHolder>(Category.class, android.R.layout.menu_item, MenuViewHolder.class, category){
        @Override
        protected void populateViewHolder (MenuViewHolder viewHolder, Category model,int position){
            viewHolder.txtMenuName.setText(model.getName());
            Picasso.with(getBaseContext()).load(model.getImage())
                    .into(viewHolder.imageView);
            Category clickItem = model;
            viewHolder.setItemClickListener(new itemclicklistener){
               @Override
                       public void onClick(View view, int position,boolean isLongClick){
                    Intent = new Intent(Home0.this,list.class);
                    list.putExtra("CategoryId",adapter.getRef(position).getKey());
                    startActivities(list);
                }


            });

          }
        };
        recycler_menu.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home0, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_list) {
            Intent intent=new Intent(Home0.this,FreeListing.class);
            startActivities(intent);
        }
        else if (id == R.id.nav_reviews) {
            FragmaentTransaction fragmaentTransaction=getSupportFragmentManager().beginTransaction();
            fragmaentTransaction.replace(R.id.fmain,new Reviews());
            fragmaentTransaction.commit();

        }
        else if (id == R.id.nav_trans) {
        }
        else if (id == R.id.nav_earn) {
            FragmaentTransaction fragmaentTransaction=getSupportFragmentManager().beginTransaction();
            fragmaentTransaction.replace(R.id.fmain,new Share());
            fragmaentTransaction.commit();
        }
        else if (id == R.id.nav_we) {
        }
        else if (id == R.id.nav_policy) {
        }
        else if (id == R.id.nav_contact) {
            FragmaentTransaction fragmaentTransaction=getSupportFragmentManager().beginTransaction();
            fragmaentTransaction.replace(R.id.fmain,new ContactUs());
            fragmaentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
