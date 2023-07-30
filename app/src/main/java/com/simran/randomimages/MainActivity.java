package com.simran.randomimages;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button previousButton;
    private Button nextButton;
    private int[] imageArray = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        showImageAtIndex(currentIndex);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex - 1 + imageArray.length) % imageArray.length;
                showImageAtIndex(currentIndex);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % imageArray.length;
                showImageAtIndex(currentIndex);
            }
        });
    }

    private void showImageAtIndex(int index) {
        // Load the image resource into a bitmap
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), imageArray[index]);

        // Specify the desired width and height of the resized image
        int desiredWidth = 500;
        int desiredHeight = 500;

        // Resize the bitmap
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, desiredWidth, desiredHeight, false);

        // Set the resized bitmap to the ImageView
        imageView.setImageBitmap(resizedBitmap);
    }
}