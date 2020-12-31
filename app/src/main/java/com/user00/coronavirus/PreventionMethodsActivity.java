package com.user00.coronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class PreventionMethodsActivity extends AppCompatActivity {

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevention_methods);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Prevention Methods");

        firestore = FirebaseFirestore.getInstance();

        VideoView videoView = findViewById(R.id.videoView);
        final TextView textView = findViewById(R.id.prevention_methods);

        MediaController mediaController = new MediaController(getApplicationContext());
        videoView.setMediaController(mediaController);

        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/chatapp-db313.appspot.com/o/uploads%2FCoronavirus%20-%20seven%20steps%20to%20prevent%20the%20spread%20of%20the%20virus.mp4?alt=media&token=6f4708cd-6fcf-40e8-92b7-75e23719eb35");
        videoView.setVideoURI(uri);
        videoView.start();

        CollectionReference reference1 = firestore.collection("coronaProtection");
        Task<QuerySnapshot> q1 = reference1.get();
        q1.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : queryDocumentSnapshots) {

                    TextContent t = queryDocumentSnapshot.toObject(TextContent.class);
                    textView.setText(t.getText());

                }
            }
        });

    }
}
