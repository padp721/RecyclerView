package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GtrAdapter adapter;
    GridGtrAdapter adapterGrid;

    List<Gtr> gtrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gtrList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        showList();
    }

    private void items(){
        gtrList.clear();
        gtrList.add(
                new Gtr(
                        "PGC10/KPGC10 Skyline GT-R",
                        "1969–1972",
                        "The first Skyline GT-R, known by the internal Nissan designation PGC10, was released on 4 February 1969, and was exclusive to Japanese Nissan dealership network called Nissan Prince Store when the Prince company was integrated into Nissan operations in 1966.",
                        R.drawable.d));

        gtrList.add(
                new Gtr(
                        "KPGC110 Skyline GT-R",
                        "1973",
                        "The KPGC10's successor, the KPGC110, was released in 1973 after its introduction at the 1972 Tokyo Motor Show. Powered by a 1989 cc I6 S20 engine, the second generation GT-R delivered power to the rear wheels through a 5-speed manual gearbox.",
                        R.drawable.e));

        gtrList.add(
                new Gtr(
                        "Nissan Skyline GTR R32",
                        "1989–1994",
                        "The R32 Skyline debuted in 1989. It was available as either a 2-door coupe or 4-door hardtop sedan.",
                        R.drawable.a));

        gtrList.add(
                new Gtr(
                        "Nissan Skyline GTR R33",
                        "1995–1998",
                        "The E-BCNR33 (R33) was developed in 1995 as a successor to the R32 model. The engine in the R33 was nearly identical to the R32. It used the same turbochargers and the same specification for the manual gearbox, although the syncros were stronger.",
                        R.drawable.f));

        gtrList.add(
                new Gtr(
                        "Nissan Skyline GTR R34",
                        "1999–2002",
                        "The GT-R reappeared in 1999, with a revised chassis and other updates.",
                        R.drawable.b));

        gtrList.add(
                new Gtr(
                        "Nissan GTR R35",
                        "2007-present",
                        "The Nissan GT-R is a 2-door 2+2 high performance vehicle produced by Nissan, unveiled in 2007. It is the successor to the Nissan Skyline GT-R, although no longer part of the Skyline range itself, that name now being used for Nissan's luxury-sport market.",
                        R.drawable.c));

        gtrList.add(
                new Gtr(
                        "NISSAN CONCEPT 2020 Vision Gran Turismo.",
                        "N/A",
                        "N/A",
                        R.drawable.g));
    }

    private void showList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        items();
        adapter = new GtrAdapter(this, gtrList);
        recyclerView.setAdapter(adapter);
    }

    private void showGrid(){
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        items();
        adapterGrid = new GridGtrAdapter(this, gtrList);
        recyclerView.setAdapter(adapterGrid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                showList();
                break;
            case R.id.action_grid:
                showGrid();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
