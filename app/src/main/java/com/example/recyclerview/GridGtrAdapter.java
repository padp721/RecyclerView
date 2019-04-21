package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GridGtrAdapter extends RecyclerView.Adapter<GridGtrAdapter.GridViewHolder> {

    private Context mCtx;
    private List<Gtr> gtrList;

    public GridGtrAdapter(Context mCtx, List<Gtr> gtrList) {
        this.mCtx = mCtx;
        this.gtrList = gtrList;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.gtr_grid, null);
        return new GridViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        final Gtr gtr = gtrList.get(i);

        gridViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(gtr.getImage()));

        gridViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx, gtr.getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mCtx, ViewDetail.class);
                intent.putExtra("image_url", gtr.getImage());
                intent.putExtra("image_name", gtr.getName());
                intent.putExtra("image_desc", gtr.getDesc());
                mCtx.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return gtrList.size();
    }
    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        LinearLayout parentLayout;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewGrid);
            parentLayout = itemView.findViewById(R.id.parent_layout_grid);
        }
    }
}
