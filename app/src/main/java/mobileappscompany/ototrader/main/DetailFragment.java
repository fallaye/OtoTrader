package mobileappscompany.ototrader.main;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mobileappscompany.ototrader.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    TextView textViewMakeDetail, textViewModelDetail, textViewYearDetail;
    ImageView imageViewDetail;

    public DetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        textViewMakeDetail = view.findViewById(R.id.tvMakeDetail);
        textViewModelDetail = view.findViewById(R.id.tvModelDetail);
        textViewYearDetail = view.findViewById(R.id.tvYearDetail);
        imageViewDetail = view.findViewById(R.id.imageViewDetail);

        return view;
    }

    public void detailFragmentData(String make, String model, String year) {
        textViewMakeDetail.setText(make);
        textViewModelDetail.setText(model);
        textViewYearDetail.setText(year);
        imageViewDetail.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ototrader));

    }

}
