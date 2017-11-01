package com.example.android.cryptoconversionapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cryptoconversionapp.R;
import com.example.android.cryptoconversionapp.adapter.FavouriteAdapter;
import com.example.android.cryptoconversionapp.model.Currency;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FavouriteAdapter mAdapter;
    ArrayList<Currency> toShowList, toHideList;
    ArrayList<String> toShowNameList, toHideNameList;
    TextView noFavsTV;


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

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

//on swipe
    private ItemTouchHelper.Callback createHelperCallback(){
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT){

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                try{
                    //int removeIndex = viewHolder.getAdapterPosition();
                }
                catch(Exception e){
                    Toast.makeText(FavouriteActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

                deleteItem(viewHolder.getAdapterPosition());

            }
        };
        return simpleCallback;
    }

//deletes item from favourite list
    private void deleteItem(int position){
        toShowNameList.remove(position);
        toShowList.remove(position);
        toHideList.remove(position);
        toHideNameList.remove(position);
        mAdapter.notifyItemRemoved(position);

    }


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
