package com.example.hsms;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Define the pic id
    private static final int pic_id = 123;
    // Define the button and imageview type variable
    Button camera_open_id;
    ImageView click_image_id;
    EditText visitor_name_edittext;
    EditText flat_owner_name_edittext;
    Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // By ID we can get each component which id is assigned in XML file get Buttons and imageview.
        camera_open_id = findViewById(R.id.camera_button);
        click_image_id = findViewById(R.id.click_image);
        visitor_name_edittext = findViewById(R.id.visitor_name_edittext);
        flat_owner_name_edittext = findViewById(R.id.flat_owner_name_edittext);
        submit_button = findViewById(R.id.submit_button);

        // Camera_open button is for open the camera and add the setOnClickListener in this button
        camera_open_id.setOnClickListener(v -> {
            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Start the activity with camera_intent, and request pic id
            startActivityForResult(camera_intent, pic_id);
        });

        // Set the OnClickListener for the Submit button
        submit_button.setOnClickListener(v -> {
            // Create a new Intent object to start the next activity
            Intent intent = new Intent(this, DisplayActivity.class);

            // Get the visitor name and flat owner name from the EditText fields
            String visitorName = visitor_name_edittext.getText().toString();
            String flatOwnerName = flat_owner_name_edittext.getText().toString();

            // Put the visitor name and flat owner name in the Intent object as extra data
            intent.putExtra("visitorName", visitorName);
            intent.putExtra("flatOwnerName", flatOwnerName);

            // Get the captured photo as a Bitmap
            Bitmap photo = ((android.graphics.drawable.BitmapDrawable) click_image_id.getDrawable()).getBitmap();

            // Put the photo in the Intent object as extra data
            intent.putExtra("photo", photo);

            // Start the next activity
            startActivity(intent);
        });
    }

    // This method will help to retrieve the image
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
        }
    }
}
