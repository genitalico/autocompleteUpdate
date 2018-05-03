package com.ochentabits.autocompleteupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private AppCompatActivity self;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        self = this;

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);


        String [] items = new String[]{"One","Two","Three", "Four"};

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,items);

        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //Simulate search from database or other repository
                //and here create an array with the records obtained
                String [] items2 = new String[]{"Apple","App","AppStore"};

                //now recreate the ArrayAdapter with the new Array String and set this to variable of the AutoCompleteTextView
                adapter = new ArrayAdapter<>(self,android.R.layout.simple_expandable_list_item_1,items2);
                autoCompleteTextView.setAdapter(adapter);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        autoCompleteTextView.setThreshold(3);
    }
}
