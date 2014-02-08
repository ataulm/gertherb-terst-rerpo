package com.ataulm.gertherb;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ataulm.gertherb.base.GertHerbActivity;

public class ReviewActivity extends GertHerbActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        String[] code = getResources().getStringArray(R.array.dummy_code);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_item_code, R.id.textview_line, code);
        ((ListView) findViewById(R.id.listview_code)).setAdapter(adapter);
    }

}
