package mobileappscompany.ototrader.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.zip.Inflater;

import mobileappscompany.ototrader.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner spinnerMake, spinnerModel, spinnerYear;

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
        ArrayAdapter<String> makeAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.makes));
        makeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMake.setAdapter(makeAdapter);

        spinnerMake.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /*String make = parent.getItemAtPosition(position).toString();
        String[] models = modelSelection(make);

        //Log.d("HomeFragment", models.toString());
        ArrayAdapter<String> modelAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.makes));
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMake.setAdapter(modelAdapter);

        Toast.makeText(parent.getContext(), "Selected: " + make, Toast.LENGTH_LONG).show();
   */ }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private String[] modelSelection(String make) {

        String[] models = null;
        switch (make) {
            case "BMW":
               models = new String[]{"128i", "135i", "M3"};
                break;
            case "Ford":
                models = new String[]{"Focus", "Taurus", "Fusion"};
                break;
            case "GMC":
                modelSelection("GMC");
                models = new String[]{"Acadia", "Savana", "Sierra"};
                break;
            case "Honda":
                models = new String[]{"Civic", "Accord", "Fit"};
                break;
            case "Toyota":
                models = new String[]{"Corolla", "Scion", "Runner"};
                break;
            default:
                break;
        }

        return models;
    }
}
