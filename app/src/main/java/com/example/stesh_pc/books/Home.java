package com.example.stesh_pc.books;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
{

    //toolbar
    private Toolbar toolbar;

    //fab
    FloatingActionButton fab;

    //Recycler view...
    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"PRoduct")
                .allowMainThreadQueries()
                .build();

        List<Book> books = db.bookDao().getAllBooks();



        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ABAdapter = Adapter...
        adapter = new ABAdapter(books);
        recyclerView.setAdapter(adapter);

        //Floating action button
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this , Addbook.class));

            }
        });
    }


   /* *@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);


        MenuItem menuItem = menu.findItem(R.menu.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String userInput = newText.toLowerCase();
        List<String> newList = new ArrayList<>();

        for (String name : databaseList())
        {

            if (name.toLowerCase().contains(userInput))
            {
                newList.add(name);
            }
        }

        adapter.
        return false;
    }
    */
}