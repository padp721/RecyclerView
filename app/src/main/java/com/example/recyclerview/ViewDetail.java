package com.example.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDetail extends AppCompatActivity {
    private static final String TAG = "ViewDetail";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gtr);
        Log.d(TAG, "onCreate: started");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            int imageUrl = getIntent().getExtras().getInt("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageDesc = getIntent().getStringExtra("image_desc");


            setImage(imageUrl, imageName, imageDesc);
        }
    }

    private void setImage(int imageUrl, String imageName, String imageDesc){
        TextView name = findViewById(R.id.image_name);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);
        image.setImageResource(imageUrl);

        TextView desc = findViewById(R.id.image_desc);
        desc.setText(imageDesc);
    }
}
