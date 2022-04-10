package edu.quinnipiac.ser210.weatherapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//main fragment for first activity
public class mainFragment extends Fragment {
    private Spinner s;
    private mainListener listener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mainFragment.
     */
    // TODO: Rename and change types and number of parameters
    //instance of main fragment
    public static mainFragment newInstance(String param1, String param2) {
        mainFragment fragment = new mainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {@link Activity#onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    //creation of spinner
    @Override
    public void onStart() {
        super.onStart();
        //creates cities in spinner
        String[] arraySpinner = new String[]{
                "NYC", "Los Angeles", "Washington D.C", "Miami", "Tokyo", "Hamden", "London", "Dubai", "Rome", "Sydney", "Barcelona", "Mumbai", "Athens", "Paris", "Machu Picchu", "Cairo", "San Francisco", "Austin", "Cape Town", "Istanbul"
        };
        s = (Spinner) getView().findViewById(R.id.locationlist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        getView().findViewById(R.id.search_btn).setOnClickListener(this::onClick);
    }

    //inflating fragments
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    //on click method for search button
    public void onClick(View view) {
        String text = s.getSelectedItem().toString();
        listener.onSelect(text);
    }

    //listener for main fragment
    public void setListener(mainListener mListener) {
        listener = mListener;
    }

    //main listener interface
    interface mainListener {
        void onSelect(String text);
    }
}