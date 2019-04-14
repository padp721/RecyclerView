package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

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
        Gtr gtr = gtrList.get(i);

        gtrViewHolder.textViewYear.setText(gtr.getYear());
        gtrViewHolder.textViewName.setText(gtr.getName());

        gtrViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(gtr.getImage()));
    }

    @Override
    public int getItemCount() {
        return gtrList.size();
    }

    class GtrViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName, textViewYear;

        public GtrViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.name);
            textViewYear = itemView.findViewById(R.id.year);
        }
    }

}
