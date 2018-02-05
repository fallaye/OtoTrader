package mobileappscompany.ototrader.saved_listing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobileappscompany.ototrader.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedListingFragment extends Fragment {


    public SavedListingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_listing, container, false);
    }

}
