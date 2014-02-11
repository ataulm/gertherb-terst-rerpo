package com.gertherb;

import android.os.Bundle;

import com.ataulm.gertherb.R;
import com.gertherb.base.GertHerbActivity;

public class ReviewActivity extends GertHerbActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        CodeView codeView = ((CodeView) findViewById(R.id.listview_code));
        codeView.setLongestLine(getResources().getString(R.string.dummy_longest_line));
        codeView.setAdapter(new CodeViewAdapter(this, getResources().getStringArray(R.array.dummy_code)));
    }

}
