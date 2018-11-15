package com.example.stesh_pc.books;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Addbook extends AppCompatActivity {
    EditText title;
    EditText description;
    EditText author;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book);


        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        author = findViewById(R.id.author);
        button = findViewById(R.id.button);


        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"PRoduct")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click saves contents to database...

                Book book = new Book (title.getText().toString(), description.getText().toString(), author.getText().toString());
            db.bookDao().insertAll(book);
            startActivity(new Intent(Addbook.this, Home.class));



            }
        });

    }
}
