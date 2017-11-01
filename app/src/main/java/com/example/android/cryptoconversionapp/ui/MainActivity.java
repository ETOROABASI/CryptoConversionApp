package com.example.android.cryptoconversionapp.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cryptoconversionapp.R;
import com.example.android.cryptoconversionapp.adapter.CustomAdapter;
import com.example.android.cryptoconversionapp.api.ApiClient;
import com.example.android.cryptoconversionapp.api.ApiService;
import com.example.android.cryptoconversionapp.model.Currency;
import com.example.android.cryptoconversionapp.model.CurrencyResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private Spinner coinSpinner, currencySpinner;
    private Button submitButton;
    TextView disconnected;
    private ProgressDialog progressDialog;
    private RecyclerView recView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private CustomAdapter mAdapter;
    private ArrayList<Currency> btcCurrencyForSpinner, ethCurrencyForSpinner;
//    String fsyms= "BTC,ETH";
//    String tsyms= "USD,GBP,CAD,CNY,INR,MYR,SGD,CHF,QAR,SEK,RWF,NGN,NAD,BRL,ARS,EGP,ILS,ZAR,MXN,RUB,EUR";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coinSpinner = (Spinner) findViewById(R.id.spinner_coin_main);
        currencySpinner = (Spinner) findViewById(R.id.spinner_currency_main);
        submitButton = (Button) findViewById(R.id.button_submit_main);
        addItemToSpinner();
        onSubmit();

        initViews();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout_main);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJSON();
                Toast.makeText(MainActivity.this, "Rate Refreshed", Toast.LENGTH_SHORT).show();
            }
        });

    }

//at the initial loading of the app
    public void initViews(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        recView = (RecyclerView) findViewById(R.id.recview_main);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.smoothScrollToPosition(0);
        loadJSON();

    }

//calls froim retrofit
    public void loadJSON(){
        disconnected = (TextView) findViewById(R.id.textview_disconnected_main);
        try {
            ApiService apiService = ApiClient.getClient().create(ApiService.class);
            Call<CurrencyResponse> call = apiService.getConversion();
            call.enqueue(new Callback<CurrencyResponse>() {
                @Override
                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                    swipeRefreshLayout.setRefreshing(false);
                    CurrencyResponse currencyResponse = response.body();
                    btcCurrencyForSpinner = currencyResponse.getBtcCurrencyList();
                    ethCurrencyForSpinner = currencyResponse.getEthCurrencyList();
                    mAdapter = new CustomAdapter(getApplicationContext(), currencyResponse.getBtcCurrencyList(),currencyResponse.getEthCurrencyList());
                    recView.setAdapter(mAdapter);
                    recView.smoothScrollToPosition(0);
                    progressDialog.hide();
                }

                @Override
                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                    swipeRefreshLayout.setRefreshing(false);
                    Log.e("MainActivity", t.getMessage());
                    Toast.makeText(MainActivity.this, "No Internet Access..." + t.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                    disconnected.setVisibility(VISIBLE);

                }
            });

        }
        catch(Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

//adds these values to the spinners
    public void addItemToSpinner(){
        List<String> coinList = new ArrayList<String>();
        coinList.add("ETH");
        coinList.add("BTC");

        ArrayAdapter<String> coinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, coinList);
        coinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coinSpinner.setAdapter(coinAdapter);


        List<String> currencyList = new ArrayList<String>();
        currencyList.add("United States");
        currencyList.add("Great Britain");
        currencyList.add("Canada");
        currencyList.add("China");
        currencyList.add("India");
        currencyList.add("Malaysia");
        currencyList.add("Singapore");
        currencyList.add("Switzerland");
        currencyList.add("Qatar");
        currencyList.add("Sweden");
        currencyList.add("Rwanda");
        currencyList.add("Nigeria");
        currencyList.add("Namibia");
        currencyList.add("Brazil");
        currencyList.add("Argentina");
        currencyList.add("Egypt");
        currencyList.add("Israel");
        currencyList.add("South Africa");
        currencyList.add("Russia");
        currencyList.add("Euros");


        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currencyList);
        coinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(currencyAdapter);

    }


    private ArrayList<Currency> toShowList = new ArrayList<>();
    private ArrayList<Currency> toHideList = new ArrayList<>();
    private ArrayList<String> toShowNameList = new ArrayList<String>();
    private ArrayList<String> toHideNameList = new ArrayList<String>();


    //Adds items to the Arrays used to populate the favourite
    public void onSubmit(){
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position;

                if(coinSpinner.getSelectedItem() == "ETH"){
                    position = 0;
                    try {
                        while (position < ethCurrencyForSpinner.size()) {
                            if (currencySpinner.getSelectedItem() == ethCurrencyForSpinner.get(position).getCountryName()) {
                                Currency ethCurrencyToShow = ethCurrencyForSpinner.get(position);
                                Currency btcCurrencyToHide = btcCurrencyForSpinner.get(position);

                                toShowList.add(ethCurrencyToShow);
                                toHideList.add(btcCurrencyToHide);
                                toShowNameList.add("ETH");
                                toHideNameList.add("BTC");

                                Toast.makeText(MainActivity.this, "Added to Favourite", Toast.LENGTH_SHORT).show();

                            }
                            position++;
                        }
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
                if (coinSpinner.getSelectedItem() == "BTC") {
                    position = 0;
                    try {
                        while (position < btcCurrencyForSpinner.size()) {
                            if (currencySpinner.getSelectedItem() == btcCurrencyForSpinner.get(position).getCountryName()) {
                                Currency btcCurrencyToShow = btcCurrencyForSpinner.get(position);
                                Currency ethCurrencyToHide = ethCurrencyForSpinner.get(position);


                                toShowList.add(btcCurrencyToShow);
                                toHideList.add(ethCurrencyToHide);
                                toShowNameList.add("BTC");
                                toHideNameList.add("ETH");

                                Toast.makeText(MainActivity.this, "Added to Favourite", Toast.LENGTH_SHORT).show();
                            }
                            position++;
                        }
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }


    public void goToFavourite(){
        Intent intent = new Intent(this, FavouriteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("TO_SHOW_LIST", toShowList);
        bundle.putParcelableArrayList("TO_HIDE_LIST", toHideList);
        bundle.putStringArrayList("TO_SHOW_NAME_LIST", toShowNameList);
        bundle.putStringArrayList("TO_HIDE_NAME_LIST", toHideNameList );
        intent.putExtra("BUNDLE", bundle);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.menu_favourite_main:
                goToFavourite();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

}
