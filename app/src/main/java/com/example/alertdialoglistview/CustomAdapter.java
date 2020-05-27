package com.example.alertdialoglistview;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<SingleRow> mData;
    Context mContext;

    public CustomAdapter(Context mContext) {

            this.mContext = mContext;
            mData = new ArrayList<>();
            Resources resources = mContext.getResources();
            String[] names= resources.getStringArray(R.array.country_name);
            int[] images = {R.drawable.complete,R.drawable.bank,R.drawable.bank,R.drawable.bank,R.drawable.bank};

            for(int i=0; i<names.length; i++){
                mData.add(new SingleRow(names[i],images[i]));
            }
            Log.v("hank","CustomAdapter()");


    }
    //取得項目(Item)的數量。通常數量就是從建構子傳入的陣列或是集合大小。
    @Override
    public int getCount() {
        Log.v("hank"," getCount() =>mData.size(): " +mData.size());
        return mData.size();
    }
    //取得在這個position位置上的項目(Item)。position通常是資料在陣列或是集合上的位置。
    @Override
    public Object getItem(int i) {
        Log.v("hank","getItem =>mData.get(i): " +mData.get(i));
        return mData.get(i);
    }
    //取得這個position位置上項目(Item)的ID，一般用position的值即可。
    @Override
    public long getItemId(int i) {
        Log.v("hank","  getItemId() =>i: " +i);
        return i;
    }
    //通常會設定與回傳convertView作為顯示在這個position位置的項目(Item)的View。
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if(mContext!= null){
            View rowView = LayoutInflater.from(mContext).inflate(R.layout.custom_listview,parent,false);
            ImageView image = rowView.findViewById(R.id.img_custom);
            TextView  name =rowView.findViewById(R.id.txt);
            SingleRow tem_obj = mData.get(i);
            name.setText(tem_obj.name);
            image.setImageResource(tem_obj.image);


            Log.v("hank"," getView i:" + i);
        }

        return null;
    }
}
