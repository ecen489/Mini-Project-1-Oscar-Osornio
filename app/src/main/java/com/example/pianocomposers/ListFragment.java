package com.example.pianocomposers;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;


public class ListFragment extends Fragment {
    private static final String[] eras = {"Baroque", "Classical", "Romantic", "Contemporary"};

    public ListFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        final Intent info = new Intent(getActivity(), Main2Activity.class);

        ListView list = view.findViewById(R.id.mylist);

        ArrayAdapter<String> myadapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()),
                android.R.layout.simple_list_item_1, eras);

        list.setAdapter(myadapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String wh_era = parent.getItemAtPosition(position).toString();
                info.putExtra("What Era", wh_era);

                startActivity(info);
            }
        });

        return view;
    }
}
