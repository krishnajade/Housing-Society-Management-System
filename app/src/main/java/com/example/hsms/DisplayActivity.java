package com.example.hsms;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_activity);

        // Get the Intent object that started this activity and retrieve the extra data
        Bundle extras = getIntent().getExtras();
        String visitorName = extras.getString("visitorName");
        String flatOwnerName = extras.getString("flatOwnerName");
        Bitmap photo = (Bitmap) extras.get("photo");

        // Set the visitor name and flat owner name in the TextViews
        TextView visitorNameTextView = findViewById(R.id.visitor_name_textview);
        visitorNameTextView.setText(visitorName);

        TextView flatOwnerNameTextView = findViewById(R.id.flat_owner_name_textview);
        flatOwnerNameTextView.setText(flatOwnerName);

        // Set the photo in the ImageView
        ImageView photoImageView = findViewById(R.id.photo_imageview);
        photoImageView.setImageBitmap(photo);
    }
}
