package com.user00.coronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class CoronaSymptomsActivity extends AppCompatActivity {

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_symptoms);

        firestore = FirebaseFirestore.getInstance();


        getSupportActionBar().setTitle("Corona Symptoms");
        ImageView imageView = findViewById(R.id.corona_image);
        final TextView textView = findViewById(R.id.corona_symptomsTv);

        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/chatapp-db313.appspot.com/o/uploads%2FSYMPTOMS.png?alt=media&token=0d6974e3-ba0b-4a5f-9682-34f9e3943db1").into(imageView);

        CollectionReference reference1 = firestore.collection("coronaSymptoms");
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
