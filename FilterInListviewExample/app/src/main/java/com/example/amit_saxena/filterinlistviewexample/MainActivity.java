package com.example.amit_saxena.filterinlistviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private EditText mEditText;
    private List<String> mItemsList;
    private ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= (ListView) findViewById(R.id.listView);
        mEditText= (EditText) findViewById(R.id.searchEditText);
        mItemsList=new ArrayList<>();
        //Adding Some items in list
        addItemsToList();
        mArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mItemsList);
        mListView.setAdapter(mArrayAdapter);
        //Adding Listener to EditText
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<String> filteredList=new ArrayList<String>();

                for(String item:mItemsList){
                    if(item.contains(s)){
                        filteredList.add(item);
                    }
                }
                mArrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,filteredList);
                mListView.setAdapter(mArrayAdapter);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void addItemsToList() {
        mItemsList.add("Sunflower");
        mItemsList.add("Rose");
        mItemsList.add("Lotus");
        mItemsList.add("Lily");
        mItemsList.add("Jasmine");
        mItemsList.add("Alyssum");
        mItemsList.add("Iris");
        mItemsList.add("Holly");
        mItemsList.add("Poppy");
    }
}
