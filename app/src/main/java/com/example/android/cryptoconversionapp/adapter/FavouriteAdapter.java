package com.example.android.cryptoconversionapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cryptoconversionapp.R;
import com.example.android.cryptoconversionapp.model.Currency;
import com.example.android.cryptoconversionapp.ui.ConversionActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ETORO on 30/10/2017.
 */

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder>{

    private Context context;

//    private String toShowName;
//    private String toHideName;
//    private Currency toShowCurrency;
//    private Currency toHideCurrency;

    ArrayList<Currency> toShowList;
    ArrayList<Currency> toHideList;
    ArrayList<String> toShowNameList;
    ArrayList<String> toHideNameList;

     public FavouriteAdapter(Context context, ArrayList<String> toShowName, ArrayList<Currency> toShowCurrency,
                             ArrayList<String> toHideName, ArrayList<Currency> toHideCurrency){
         this.context = context;
         this.toShowNameList = toShowName;
         this.toShowList = toShowCurrency;
         this.toHideNameList = toHideName;
         this.toHideList = toHideCurrency;




//        toShowList.add(toShowCurrency);
//        toShowNameList.add(toShowName);
//        toHideList.add(toHideCurrency);
//         toHideNameList.add(toHideName);
    }


    @Override
    public FavouriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_list_view, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavouriteAdapter.ViewHolder holder, int position) {
        Currency toShow = toShowList.get(position);
        Currency toHide = toHideList.get(position);
        String toShowName = toShowNameList.get(position);
        String toHideName = toHideNameList.get(position);

        holder.toShowTV.setText("1 "+ toShowName + " = " + toShow.getCurrencyRate() + " " + toShow.getCurrencyName() );
        holder.toHideTV.setText("1 "+ toHideName + " = " + toHide.getCurrencyRate() + " " + toHide.getCurrencyName());
        holder.countryNameTV.setText(toShow.getCountryName());
        holder.flagIV.setImageResource(toShow.getCountryFlag());

    }

    @Override
    public int getItemCount() {
        return toShowList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView countryNameTV, toShowTV, toHideTV;
        ImageView flagIV;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            countryNameTV = (TextView) itemView.findViewById(R.id.textview_country_fav_list);
            toShowTV = (TextView) itemView.findViewById(R.id.textview_toShow_fav_list);
            toHideTV = (TextView) itemView.findViewById(R.id.textview_toHide_fav_list);
            flagIV = (ImageView) itemView.findViewById(R.id.imageview_flag_fav_list);
            cardView = (CardView) itemView.findViewById(R.id.cardview_fav_list);

            //Clicking in an item to take you to ConversionActivity
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Currency firstValue = toShowList.get(position);
                        Currency secondValue = toHideList.get(position);
                        String firstName = toShowNameList.get(position);
                        String secondName = toHideNameList.get(position);

                        Intent intent = new Intent(context, ConversionActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("FLAG", firstValue.getCountryFlag());
                        intent.putExtra("FIRST_RATE", firstValue.getCurrencyRate());
                        intent.putExtra("SECOND_RATE", secondValue.getCurrencyRate());
                        intent.putExtra("FIRST_COIN_NAME", firstName);
                        intent.putExtra("SECOND_COIN_NAME", secondName);
                        intent.putExtra("COUNTRY_NAME", firstValue.getCountryName());
                        intent.putExtra("CURRENCY_NAME", secondValue.getCurrencyName());
                        intent.putExtra("BUNDLE", bundle);

                        //Toast.makeText(context, firstValue.getCurrencyName(), Toast.LENGTH_LONG).show();

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });





        }
    }

}
