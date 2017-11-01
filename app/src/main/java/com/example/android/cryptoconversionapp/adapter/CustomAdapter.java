package com.example.android.cryptoconversionapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
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

import static com.example.android.cryptoconversionapp.R.string.btc;

/**
 * Created by ETORO on 28/10/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Currency> btcList;
    private ArrayList<Currency> ethList;



    public CustomAdapter(Context context, ArrayList<Currency> btcList, ArrayList<Currency> ethList){
        this.context = context;
        this.btcList = btcList;
        this.ethList = ethList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_view, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Currency btc = btcList.get(position);
        Currency eth = ethList.get(position);

        holder.btcText.setText("1 BTC = " + btc.getCurrencyRate()+ " " + btc.getCurrencyName());
        holder.ethText.setText("1 ETH = " + eth.getCurrencyRate() + " " +eth.getCurrencyName());
        holder.countryNameText.setText(btc.getCountryName());
        holder.countryFlag.setImageResource(eth.getCountryFlag());


    }

    @Override
    public int getItemCount() {
        return btcList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView btcText, ethText, countryNameText;
        CardView cardView;
        ImageView countryFlag;

        public ViewHolder(View itemView) {
            super(itemView);
            btcText = (TextView) itemView.findViewById(R.id.textview_btc_main_list);
            ethText = (TextView) itemView.findViewById(R.id.textview_eth_main_list);
            countryNameText = (TextView) itemView.findViewById(R.id.textview_country_main_list);
            countryFlag = (ImageView) itemView.findViewById(R.id.imageview_flag_main_list);
            cardView = (CardView) itemView.findViewById(R.id.cardview_list);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Currency btcValues = btcList.get(position);
                        Currency ethValues = ethList.get(position);

                        Intent intent = new Intent(context, ConversionActivity.class);
                        Bundle extra = new Bundle();
                        extra.putInt("FLAG", btcValues.getCountryFlag());
                        intent.putExtra("FIRST_RATE", btcValues.getCurrencyRate());
                        intent.putExtra("CURRENCY_NAME", btcValues.getCurrencyName());
                        intent.putExtra("COUNTRY_NAME", ethValues.getCountryName());
                        intent.putExtra("SECOND_RATE", ethValues.getCurrencyRate());
                        intent.putExtra("FIRST_COIN_NAME", "BTC");
                        intent.putExtra("SECOND_COIN_NAME", "ETH");
                        intent.putExtra("BUNDLE", extra);

                       //Toast.makeText(context, context.toString(), Toast.LENGTH_LONG).show();

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                       // Toast.makeText(context, btcValues.getCountryFlag() +"  ,  "+ethValues.getCurrencyRate(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

}
