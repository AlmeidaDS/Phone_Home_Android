package com.example.root.permissions;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.inflate;

/**
 * Created by root on 9/13/17.
 */

public class CustomListAdpater extends BaseAdapter {
    private Activity myContext ;
    private int [] mImages;
    private String [] mContactNames;
    private LayoutInflaterCompat mInflater = null;

    public CustomListAdpater(Activity context,int[]images,String[] contactNames){
        myContext = context;
        mContactNames = contactNames;
        mImages = images;



   }
    @Override
    public int getCount() {
        return mContactNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View view = inflater.inflate(R.layout.customerlist,parent,false);
        holder.txt = (TextView)view.findViewById(R.id.profileName);
        holder.v = (ImageView) view.findViewById(R.id.profilePic);
        holder.txt.setText(mContactNames[position]);
        holder.v.setImageResource(mImages[position]);

        return view;
    }
    public class Holder{
        ImageView v;
        TextView txt;

    }
}
