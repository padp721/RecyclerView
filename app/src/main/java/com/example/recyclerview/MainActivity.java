package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GtrAdapter adapter;

    List<Gtr> gtrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gtrList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        gtrList.add(
                new Gtr(
                        "Nissan Skyline GTR R32",
                        "2019",
                        R.drawable.a));

        gtrList.add(
                new Gtr(
                        "Nissan Skyline GTR R32",
                        "2019",
                        R.drawable.b));

        gtrList.add(
                new Gtr(
                        "Nissan Skyline GTR R32",
                        "2019",
                        R.drawable.c));

        adapter = new GtrAdapter(this, gtrList);
        recyclerView.setAdapter(adapter);

    }
}
