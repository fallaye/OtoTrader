package mobileappscompany.ototrader.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mobileappscompany.ototrader.R;
import mobileappscompany.ototrader.adpater.CarAdapter;
import mobileappscompany.ototrader.model.Car;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListingFragment extends Fragment {

    ArrayList<Car> carList;
    RecyclerView recyclerView;

    public ListingFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        carList = new ArrayList<Car>();

        carList = getCars();

        CarAdapter adapter = new CarAdapter(getActivity(), carList);

        recyclerView.setAdapter(adapter);
        return view;
    }

    public void displayListing(String make, String model, String year){
        Car car;




       /* switch (make) {
            case "BMW":
                switch (model) {
                    case "128i":
                        switch (year) {
                            case "2018":
                                for (int i = 0; i < 5; i++) {
                                    car = new Car("BMW", "128i", "2018", i);
                                    carList.add(car);
                                }
                                break;
                            case "2017":
                                for (int i = 0; i < 5; i++) {
                                    car = new Car("BMW", "128i", "2018", i);
                                    carList.add(car);
                                }
                                break;
                            case "2016":
                                for (int i = 0; i < 5; i++) {
                                    car = new Car("BMW", "128i", "2018", i);
                                    carList.add(car);
                                }
                                break;
                        }
                }
        }*/
    }

    private ArrayList<Car> getCars(){
        Car car;

        for (int i = 0; i < 5; i++) {
            car = new Car("BMW", "128i", "2018", R.drawable.ototrader);
            carList.add(car);
        }

        for (int i = 0; i < 5; i++) {
            car = new Car("BMW", "135i", "2018", R.drawable.ototrader);
            carList.add(car);
        }

        for (int i = 0; i < 5; i++) {
            car = new Car("BMW", "328i", "2018", R.drawable.ototrader);
            carList.add(car);
        }
        return carList;
    }

}
