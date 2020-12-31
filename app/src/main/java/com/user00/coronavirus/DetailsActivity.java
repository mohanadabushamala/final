package com.user00.coronavirus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private  int positionCountry;
    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setTitle("Country Details");

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);


        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);

        tvCountry.setText(CountryFragment.countryItems.get(positionCountry).getCountry());
        tvCases.setText(CountryFragment.countryItems.get(positionCountry).getCases());
        tvRecovered.setText(CountryFragment.countryItems.get(positionCountry).getRecovered());
        tvCritical.setText(CountryFragment.countryItems.get(positionCountry).getDangerous());
        tvActive.setText(CountryFragment.countryItems.get(positionCountry).getActive());
        tvTodayCases.setText(CountryFragment.countryItems.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(CountryFragment.countryItems.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(CountryFragment.countryItems.get(positionCountry).getTodayDeaths());


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
