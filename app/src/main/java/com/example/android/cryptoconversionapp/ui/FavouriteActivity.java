package com.example.android.cryptoconversionapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cryptoconversionapp.R;
import com.example.android.cryptoconversionapp.adapter.FavouriteAdapter;
import com.example.android.cryptoconversionapp.model.Currency;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class FavouriteActivity extends AppCompatActivity {

//    private String toShowName;
//    private Currency currencyToShow;
//    private String toHideName;
//    private Currency currencyToHide;
    RecyclerView recyclerView;
    FavouriteAdapter mAdapter;
    ArrayList<Currency> toShowList, toHideList;
    ArrayList<String> toShowNameList, toHideNameList;
    TextView noFavsTV;

//    public FavouriteActivity(String toShowName, Currency currencyToShow, String toHideName, Currency currencyToHide){
////        this.toShowName = toShowName;
////        this.currencyToShow = currencyToShow;
////        this.toHideName = toHideName;
////        this.currencyToHide = currencyToHide;
//
//        toShowNameList.add(toShowName);
//        toShowList.add(currencyToShow);
//        toHideNameList.add(toHideName);
//        toHideList.add(currencyToHide);
//
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        noFavsTV = (TextView) findViewById(R.id.textview_no_favourite);
        Bundle bundle = getIntent().getBundleExtra("BUNDLE");
        toShowList = bundle.getParcelableArrayList("TO_SHOW_LIST");
        toHideList = bundle.getParcelableArrayList("TO_HIDE_LIST");
        toShowNameList = bundle.getStringArrayList("TO_SHOW_NAME_LIST");
        toHideNameList = bundle.getStringArrayList("TO_HIDE_NAME_LIST");
        recyclerView = (RecyclerView) findViewById(R.id.recview_favourite);

        if(toShowList.size() == 0){
            recyclerView.setVisibility(RecyclerView.INVISIBLE);
            noFavsTV.setVisibility(TextView.VISIBLE);
            noFavsTV.setText("Okay...");
            return;
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FavouriteAdapter(getApplicationContext(), toShowNameList, toShowList, toHideNameList, toHideList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.smoothScrollToPosition(0);

//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
//        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    //TODO TRY THE SWIPEREFRESH LAYOUT TO UPDATE THE VALUES IN THE FAVOURITE ACTIVITY
    //TODO RESTRICT IT FROM ADDING THE SAME DATA TWICE TO THE RECYCLER VIEW


//    public void addToFavourite(String toShowName, Currency currencyToShow, String toHideName, Currency currencyToHide){
//        toShowNameList.add(toShowName);
//        toShowList.add(currencyToShow);
//        toHideNameList.add(toHideName);
//        toHideList.add(currencyToHide);
//        mAdapter.notifyItemInserted(toShowList.indexOf(toShowList));

    //}
//
//    private void gotoHome(){
//        startActivity(new Intent(this, MainActivity.class));
//    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_favourite, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.menu_home_favourite:
//                gotoHome();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
