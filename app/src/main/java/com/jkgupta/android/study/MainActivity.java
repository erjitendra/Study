package com.jkgupta.android.study;

import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle drawerToggle;
      Toolbar toolbar;
      RecyclerView recyclerView;
      DrawerLayout drawerLayout;
      RecyclerView.Adapter adapter;
      RecyclerView.LayoutManager layoutManager;
      ArrayList<String> subjectsArray=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        drawerLayout=findViewById(R.id.drawerLayout);
        recyclerView.setHasFixedSize(true);

        String[] subjects=getResources().getStringArray(R.array.Subjects);
        for(String subject:subjects)
        {
    subjectsArray.add(subject);
    Log.v("MainActivity",subject);
        }
        adapter=new RecyclerAdapter(subjectsArray);
        recyclerView.setAdapter(adapter);
        drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
}
