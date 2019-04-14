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
                        "1989",
                        "The R32 Skyline debuted in 1989. It was available as either a 2-door coupe or 4-door hardtop sedan.",
                        R.drawable.a));

        gtrList.add(
                new Gtr(
                        "Nissan Skyline GTR R34",
                        "1998",
                        "The GT-R reappeared in 1999, with a revised chassis and other updates.",
                        R.drawable.b));

        gtrList.add(
                new Gtr(
                        "Nissan GTR R35",
                        "2007",
                        "The Nissan GT-R is a 2-door 2+2 high performance vehicle produced by Nissan, unveiled in 2007. It is the successor to the Nissan Skyline GT-R, although no longer part of the Skyline range itself, that name now being used for Nissan's luxury-sport market.",
                        R.drawable.c));

        adapter = new GtrAdapter(this, gtrList);
        recyclerView.setAdapter(adapter);

    }
}
