package com.user00.coronavirus;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllWordFragment extends Fragment {

    private TextView cases,todayCases,deaths,todayDeaths,recovered,active,dangerous,affectedCountries;

    public AllWordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         View view =inflater.inflate(R.layout.fragment_all_word, container, false);


        cases = view.findViewById(R.id.casesTv);
        todayCases =  view.findViewById(R.id.todayCasesTv);
        deaths =  view.findViewById(R.id.deathsTv);
        todayDeaths =  view.findViewById(R.id.todayDeathsTv);
        recovered =  view.findViewById(R.id.recoveredTv);
        active =  view.findViewById(R.id.activeTv);
        dangerous =  view.findViewById(R.id.dangerousTv);
        affectedCountries =view.findViewById(R.id.affectedCountriesTv);

        String url = "https://corona.lmao.ninja/v2/all/";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    cases.setText(jsonObject.getString("cases"));
                    recovered.setText(jsonObject.getString("recovered"));
                    dangerous.setText(jsonObject.getString("critical"));
                    active.setText(jsonObject.getString("active"));
                    todayCases.setText(jsonObject.getString("todayCases"));
                    deaths.setText(jsonObject.getString("deaths"));
                    todayDeaths.setText(jsonObject.getString("todayDeaths"));
                    affectedCountries.setText(jsonObject.getString("affectedCountries"));



                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), "Couldn't refresh feed", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        requestQueue.add(request);

        return view;
    }

}
