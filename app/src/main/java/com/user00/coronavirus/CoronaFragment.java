package com.user00.coronavirus;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.user00.coronavirus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoronaFragment extends Fragment {


    FirebaseFirestore firestore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_corona, container, false);

        final TextView textView = view.findViewById(R.id.what_coronaTv);
        Button coronaP = view.findViewById(R.id.coronaP_btn);
        Button coronaS = view.findViewById(R.id.coronaS_btn);
        Button coronaC = view.findViewById(R.id.cmara);


        firestore = FirebaseFirestore.getInstance();

        CollectionReference reference1 = firestore.collection("coronaV");
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


        coronaS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CoronaSymptomsActivity.class);
                startActivity(intent);
            }
        });

        coronaP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),PreventionMethodsActivity.class);
                startActivity(intent);
            }
        });

        coronaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),NewActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
