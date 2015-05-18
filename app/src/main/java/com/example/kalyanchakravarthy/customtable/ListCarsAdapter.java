package com.example.kalyanchakravarthy.customtable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kalyanchakravarthy on 18/05/15.
 */
public class ListCarsAdapter extends BaseAdapter {


    Context context;

    protected List<cars> listCars;
    LayoutInflater inflater;

    public ListCarsAdapter(Context context, List<cars> listCars) {
        this.listCars = listCars;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public int getCount() {
        return listCars.size();
    }

    public cars getItem(int position) {
        return listCars.get(position);
    }

    public long getItemId(int position) {
        return listCars.get(position).getDrawableId();
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.itemlist,
                    parent, false);

            holder.txtModel = (TextView) convertView
                    .findViewById(R.id.txt_car_model);
            holder.txtColor = (TextView) convertView
                    .findViewById(R.id.txt_car_color);
            holder.txtPrice = (TextView) convertView
                    .findViewById(R.id.txt_car_price);
            holder.imgCar = (ImageView) convertView.findViewById(R.id.img_car);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        cars car = listCars.get(position);
        holder.txtModel.setText(car.getModel());
        holder.txtColor.setText(car.getColor());
        holder.txtPrice.setText(car.getPrice() + " €");
        holder.imgCar.setImageResource(car.getDrawableId());

        return convertView;
    }

    private class ViewHolder {
        TextView txtModel;
        TextView txtColor;
        TextView txtPrice;
        ImageView imgCar;
    }
}
