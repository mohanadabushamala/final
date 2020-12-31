package com.user00.coronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    Button captureButton_ref;
    ImageView imageView_ref;
    boolean hasCamera = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        captureButton_ref = findViewById(R.id.button_takephoto);
        imageView_ref = findViewById(R.id.ImageView);

        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            Toast error = Toast.makeText(getApplicationContext(), "الهاتف لا يحتوي على كاميرا!", Toast.LENGTH_LONG);
            error.show();
            hasCamera = false;
        }

        captureButton_ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(hasCamera) {
                    Intent captureImageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (captureImageIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(captureImageIntent, 1);
                    }

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extra = data.getExtras();
            Bitmap image = (Bitmap) extra.get("data");

            imageView_ref.setImageBitmap(image);
        }
    }




    }
