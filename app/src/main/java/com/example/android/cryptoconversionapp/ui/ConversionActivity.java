package com.example.android.cryptoconversionapp.ui;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cryptoconversionapp.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import static android.R.attr.id;
import static android.R.attr.switchMinWidth;
import static android.R.attr.value;
import static com.example.android.cryptoconversionapp.R.string.currency;
import static com.example.android.cryptoconversionapp.R.string.eth;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import static java.util.Date.parse;

public class ConversionActivity extends AppCompatActivity {
    public static final String FIRST_RATE = "FIRST_RATE";
    public static final String SECOND_RATE = "SECOND_RATE";
    public static final String FLAG = "FLAG";
    public static final String COUNTRY_NAME = "COUNTRY_NAME";
    public static final String CURRENCY_NAME = "CURRENCY_NAME";
    public static final String FIRST_COIN_NAME = "FIRST_COIN_NAME";
    public static final String SECOND_COIN_NAME = "SECOND_COIN_NAME";

    DecimalFormat df = new DecimalFormat("#.########");
    TextView btcResultTV, ethResultTV, countryNameTV, currencyTV, currencyConTV, baseCurrencyResultTV, firstSymbolTV, secondSymbolTV;
    ImageView flagIV;
    double firstRateDouble, secondRateDouble;
    String valueToConvert;
    double valueToConvertDouble, firstRateDoubleText, secondRateDoubleText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        btcResultTV = (TextView) findViewById(R.id.textview_first_value_conversion);
        ethResultTV = (TextView) findViewById(R.id.textview_second_value_conversion);
        countryNameTV = (TextView) findViewById(R.id.textview_country_conversion);
        currencyTV = (TextView) findViewById(R.id.textview_curency_conversion);
        currencyConTV = (TextView) findViewById(R.id.textview_currency_symbol_conversion);
        baseCurrencyResultTV = (TextView) findViewById(R.id.textview_currency_value_conversion);
        flagIV = (ImageView) findViewById(R.id.imageview_flag_conversion);
        firstSymbolTV = (TextView) findViewById(R.id.textview_first_symbol_conversion);
        secondSymbolTV = (TextView) findViewById(R.id.textview_second_symbol_conversion);
        valueToConvert = "";
        valueToConvertDouble= 0.0;

        Bundle extras = getIntent().getBundleExtra("BUNDLE");
        int flag = extras.getInt(FLAG);
        String countryName = getIntent().getExtras().getString(COUNTRY_NAME);
        String currencyName = getIntent().getExtras().getString(CURRENCY_NAME);
        String firstRate = getIntent().getExtras().getString(FIRST_RATE);
        String secondRate = getIntent().getExtras().getString(SECOND_RATE);
        String firstCoinName = getIntent().getExtras().getString(FIRST_COIN_NAME);
        String secondCoinName = getIntent().getExtras().getString(SECOND_COIN_NAME);

        firstRateDouble = parseDouble(firstRate);
        secondRateDouble = parseDouble(secondRate);
        firstRateDoubleText = 0;
        secondRateDoubleText = 0;

        firstRateDouble = 1/firstRateDouble;
        secondRateDouble = 1/secondRateDouble;

        firstRateDouble = Double.valueOf(df.format(firstRateDouble));
        secondRateDouble = Double.valueOf(df.format(secondRateDouble));


        btcResultTV.setText(String.valueOf(firstRateDouble));
        ethResultTV.setText(String.valueOf(secondRateDouble));
        countryNameTV.setText(countryName);
        currencyConTV.setText(currencyName);
        currencyTV.setText(currencyName);
        baseCurrencyResultTV.setText("1");
        flagIV.setImageDrawable(ContextCompat.getDrawable(this, flag));
        firstSymbolTV.setText(firstCoinName);
        secondSymbolTV.setText(secondCoinName);

//        Toast.makeText(this, getApplicationContext().toString(), Toast.LENGTH_SHORT).show();
    }


//On each button click. Checks the length of the value in the textView, so that values won't be stored outside the textview display area
    //max length is 14
    public void onButtonClick(View view) {
        switch (view.getId()){
            case R.id.btn_del_conversion:
                try {
                    if (valueToConvert.length() > 14) {
                        valueToConvert = valueToConvert.substring(0, valueToConvert.length() - (valueToConvert.length() - 14));
                    }
                    valueToConvert = valueToConvert.substring(0, valueToConvert.length() - 1);
                } catch (Exception e) {
                    Toast.makeText(this, "No Value To Be Deleted" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_clr_conversion:
                baseCurrencyResultTV.setText("0.0");
                valueToConvert = "";
                firstRateDoubleText = 0.0;
                secondRateDoubleText = 0.0;
                btcResultTV.setText(String.valueOf(firstRateDoubleText));
                ethResultTV.setText(String.valueOf(secondRateDoubleText));

                return;
            case R.id.btn_equals_conversion:
                try {

                    valueToConvertDouble = Double.parseDouble(valueToConvert);
                    firstRateDoubleText = valueToConvertDouble * firstRateDouble;
                    secondRateDoubleText = valueToConvertDouble * secondRateDouble;
                    firstRateDoubleText = Double.valueOf(df.format(firstRateDoubleText));
                    secondRateDoubleText = Double.valueOf(df.format(secondRateDoubleText));

                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(true);
                    builder.setTitle("ERROR");
                    builder.setMessage(e.getMessage());
                    builder.show();

                }
                break;
            default:
                break;

        }


        if (valueToConvert.length() <= 11) {
            switch (view.getId()) {
                case R.id.btn_3_zeros_conversion:
                    valueToConvert += "000";
                    break;
            }
        }


        if (valueToConvert.length() <= 12) {
            switch (view.getId()) {
                case R.id.btn_2_zeros_conversion:
                    valueToConvert += "00";
                    break;

            }
        }

        if (valueToConvert.length() < 14) {
                switch (view.getId()) {
                    case R.id.btn_0_conversion:
                        valueToConvert += "0";
                        break;
                    case R.id.btn_1_conversion:
                        valueToConvert += "1";
                        break;
                    case R.id.btn_2_conversion:
                        valueToConvert += "2";
                        break;
                    case R.id.btn_3_conversion:
                        valueToConvert += "3";
                        break;
                    case R.id.btn_4_conversion:
                        valueToConvert += "4";
                        break;
                    case R.id.btn_5_conversion:
                        valueToConvert += "5";
                        break;
                    case R.id.btn_6_conversion:
                        valueToConvert += "6";
                        break;
                    case R.id.btn_7_conversion:
                        valueToConvert += "7";
                        break;
                    case R.id.btn_8_conversion:
                        valueToConvert += "8";
                        break;
                    case R.id.btn_9_conversion:
                        valueToConvert += "9";
                        break;
                    case R.id.btn_decimal_conversion:
                        valueToConvert += ".";
                        break;
                    default:
                        break;
                }
            }


        baseCurrencyResultTV.setText(String.valueOf(valueToConvert));
        btcResultTV.setText(String.valueOf(firstRateDoubleText));
        ethResultTV.setText(String.valueOf(secondRateDoubleText));
    }
}
