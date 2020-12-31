package com.user00.coronavirus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<CountryItem> {

    private Context context;
    private List<CountryItem> countryItems;
    private List<CountryItem> countryItemsFiltered;

    public CountryAdapter(Context context, List<CountryItem> countryItems) {
        super(context, R.layout.list_country_item, countryItems);

        this.context = context;
        this.countryItems = countryItems;
        this.countryItemsFiltered = countryItems;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable  View convertView, @NonNull ViewGroup parent) {

        @SuppressLint("ViewHolder") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_country_item,null , true);

        TextView countryName = view.findViewById (R.id.countryNameTv );
        ImageView countryImage = view.findViewById(R.id.countryImage);

        countryName.setText (countryItemsFiltered.get(position).getCountry());
        Picasso.get().load(countryItemsFiltered.get(position).getFlag()).into(countryImage);

        return view ;

    }

    @Override
    public int getCount() {
        return countryItemsFiltered.size();
    }

    @Nullable
    @Override
    public CountryItem getItem(final int position) {
        return countryItemsFiltered.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(final CharSequence charSequence) {

                FilterResults filterResults = new FilterResults();
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.count = countryItems.size();
                    filterResults.values = countryItems;
                } else {
                    List<CountryItem> resultModals = new ArrayList<>();
                    String searchStr = charSequence.toString().toLowerCase();

                    for (CountryItem items : countryItems) {
                        if (items.getCountry().toLowerCase().contains(searchStr)) {
                            resultModals.add(items);
                        }
                        filterResults.count = resultModals.size();
                        filterResults.values = resultModals;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(final CharSequence charSequence, final FilterResults filterResults) {

                countryItemsFiltered = (List<CountryItem>) filterResults.values;
                CountryFragment.countryItems = (List<CountryItem>) filterResults.values;
                notifyDataSetChanged();

            }
        };

        return filter;
    }
}
