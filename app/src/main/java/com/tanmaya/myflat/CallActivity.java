package com.tanmaya.myflat;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CallActivity extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    ArrayList <Details> arrayList;
    ContactAdapter adapter;
    ListView LV;
    String no;
    public CallActivity() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String param1, String param2) {
        CallActivity fragment = new CallActivity();
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_call, container, false);
        // Inflate the layout for this fragment
        LV=view.findViewById(R.id.lv);
        arrayList=new ArrayList<Details>();
        arrayList.add(new Details("Parvesh(Security)","8130175043"));
        arrayList.add(new Details("Pawan(Supervisor)","8745861760"));
        arrayList.add(new Details("Ashok Gupta(Builder)","9312202885"));
        arrayList.add(new Details("Sahil Gupta(Builder)","9999990299"));
       adapter=new ContactAdapter(getContext(),arrayList);
       LV.setAdapter(adapter);
       LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Details d;
               d=arrayList.get(position);
               Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+d.number));
               startActivity(sIntent);
           }
       });
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.CALL_PHONE)){
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, 1);
            }else{
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        }
        return view;
    }


}