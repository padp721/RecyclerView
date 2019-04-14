package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.ContentValues.TAG;

public class GtrAdapter extends RecyclerView.Adapter<GtrAdapter.GtrViewHolder> {

    private Context mCtx;
    private List<Gtr> gtrList;

    public GtrAdapter(Context mCtx, List<Gtr> gtrList) {
        this.mCtx = mCtx;
        this.gtrList = gtrList;
    }

    @NonNull
    @Override
    public GtrViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.gtr_list, null);
        return new GtrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GtrViewHolder gtrViewHolder, int i) {
        final Gtr gtr = gtrList.get(i);

        gtrViewHolder.textViewYear.setText(gtr.getYear());
        gtrViewHolder.textViewName.setText(gtr.getName());

        gtrViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(gtr.getImage()));

        gtrViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx, gtr.getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mCtx, ViewDetail.class);
                intent.putExtra("image_url", gtr.getImage());
                intent.putExtra("image_name", gtr.getName());
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gtrList.size();
    }

    class GtrViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName, textViewYear;
        LinearLayout parentLayout;

        public GtrViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.name);
            textViewYear = itemView.findViewById(R.id.year);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
