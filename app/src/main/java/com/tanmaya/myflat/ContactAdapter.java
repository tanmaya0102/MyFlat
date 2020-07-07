package com.tanmaya.myflat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Details> {

    private Context mContext;
    private List<Details> contactList = new ArrayList<>();
    public ContactAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Details> list) {
        super(context, 0, list);
        mContext = context;
        contactList = list;
    }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItem = convertView;
            if(listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

            Details Person = contactList.get(position);
            TextView name = (TextView) listItem.findViewById(R.id.textView_name);
            name.setText(Person.getName());
            TextView number = (TextView) listItem.findViewById(R.id.textView_number);
            number.setText(Person.getNumber());

            return listItem;
        }

    }

