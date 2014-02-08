package com.ataulm.gertherb.base;

import android.os.Bundle;
import android.widget.Toast;

public abstract class Activity extends android.app.Activity {

    private ViewServerManager viewServerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewServerManager = new ViewServerManager(this);
        viewServerManager.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewServerManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewServerManager.onDestroy();
    }

    protected void toast(int messageResId) {
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

}
