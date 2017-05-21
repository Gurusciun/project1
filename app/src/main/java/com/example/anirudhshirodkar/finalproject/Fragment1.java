package com.example.anirudhshirodkar.finalproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by latheeshvirupakshi on 3/21/17.
 */

public class Fragment1 extends android.support.v4.app.Fragment {

    private RecyclerView mRecyclerview;




    public Fragment1()
    {

    }

    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.tab1, container, false);


        return  v;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerview = (RecyclerView) getActivity().findViewById(R.id.contactlist);

        FragmentAdapter contactsAdapter = new FragmentAdapter(getActivity(),generateData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setAdapter(contactsAdapter);



    }




    private ArrayList<Model> generateData(){

        ArrayList<Model> contactsModals = new ArrayList<>();

        for (int i = 0; i < Mydata.nameArray.length; i++) {
            contactsModals.add(new Model(
                    Mydata.nameArray[i],
                    Mydata.versionArray[i],
                    Mydata.id_[i],
                    Mydata.drawableArray[i]
            ));



        }

        return contactsModals;
    }

}