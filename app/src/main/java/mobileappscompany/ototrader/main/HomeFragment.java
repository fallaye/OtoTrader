package mobileappscompany.ototrader.main;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.zip.Inflater;

import mobileappscompany.ototrader.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerMake, spinnerModel, spinnerYear;
    private ArrayAdapter<String> makeAdapter;
    private Button btnReset, btnViewListings;
    private static String make, model, year;
    private OnFragmentInteractionListener mListener;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setupView(view);
        return view;
    }

    private void setupView(View view) {
        spinnerMake = view.findViewById(R.id.spinnerMake);
        spinnerModel = view.findViewById(R.id.spinnerModel);
        spinnerYear = view.findViewById(R.id.spinnerYear);
        btnReset = view.findViewById(R.id.btnReset);
        btnViewListings = view.findViewById(R.id.btnViewListings);

        makeAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.makes));
        makeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMake.setAdapter(makeAdapter);

        spinnerMake.setOnItemSelectedListener(this);

        final ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.years));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);

        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerMake.setAdapter(makeAdapter);
                spinnerYear.setAdapter(yearAdapter);
            }
        });

        btnViewListings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listings(make, model, year);
            }
        });
    }

    private void listings(String make, String model, String year){
        if (mListener != null) {
            mListener.onFragmentInteraction(make, model, year);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        make = parent.getItemAtPosition(position).toString();
        ArrayAdapter<String> modelAdapter = null;
        switch (make) {
            case "BMW":
                modelAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.modelBMW));
                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                break;
            case "Ford":
                modelAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.modelFord));
                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                break;
            case "Honda":
                modelAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.modelHonda));
                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                break;
            case "Mini":
                modelAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.modelMini));
                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                break;
            case "Toyota":
                modelAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.modelToyota));
                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                break;
            default:
                break;
        }
        spinnerModel.setAdapter(modelAdapter);
        spinnerModel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model = parent.getItemAtPosition(position).toString();
                // Toast.makeText(parent.getContext(), "Model Selected: " + model, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String make, String model, String year);
    }
}
