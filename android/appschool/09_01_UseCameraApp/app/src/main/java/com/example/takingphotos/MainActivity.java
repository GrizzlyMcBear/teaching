package com.example.takingphotos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView photoImageView;
    Button takePhotoBtn;
    Bitmap photoBitmap;

    private void initWidgets() {
        takePhotoBtn = findViewById(R.id.takePhotoButton);
        photoImageView = findViewById(R.id.photoImageView);
    }

    private void initWidgetsHandlers() {
        takePhotoBtn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        initWidgetsHandlers();
    }

    @Override
    public void onClick(View view) {
        if (view == takePhotoBtn) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {// Returning from the camera app
            photoBitmap = (Bitmap) data.getExtras().get("data");
            photoImageView.setImageBitmap(photoBitmap);
        }
    }
}