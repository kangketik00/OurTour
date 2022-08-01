package com.makmurjaya.ourtour.view.destination;
// Tanggal Pengerjaan: 25-07-2022
// Ilham Zaki - 10119006 - IF1
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.makmurjaya.ourtour.MainActivity;
import com.makmurjaya.ourtour.R;
import com.makmurjaya.ourtour.models.ModelTour;

import java.util.ArrayList;

public class DestinationFragment extends Fragment {
    FloatingActionButton btn_goto_activity_add_tour;
    AdapterTour adapterTour;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelTour> listTour;
    RecyclerView tour_collection;

    public DestinationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_destination, container, false);



        tour_collection = view.findViewById(R.id.tour_collection);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        tour_collection.setLayoutManager(layoutManager);
        tour_collection.setItemAnimator(new DefaultItemAnimator());
        showTourCollection();
        return view;
    }

    private void showTourCollection(){
        database.child("Tour").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listTour = new ArrayList<>();
                for(DataSnapshot item : snapshot.getChildren()){
                    ModelTour tour = item.getValue(ModelTour.class);
                    tour.setKey(item.getKey());
                    listTour.add(tour);
                }
                adapterTour = new AdapterTour(listTour, getActivity());
                tour_collection.setAdapter(adapterTour);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}