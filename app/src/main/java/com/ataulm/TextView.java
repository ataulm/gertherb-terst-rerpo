package com.ataulm;

import android.content.Context;
import android.util.AttributeSet;

import com.ataulm.gertherb.R;
import com.ataulm.gertherb.base.FontWriter;

public class TextView extends android.widget.TextView {

    private final FontWriter fontWriter;

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        fontWriter = FontWriter.create(this, attrs, R.styleable.TextView);
        init();
    }

    public TextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        fontWriter = FontWriter.create(this, attrs, R.styleable.TextView);
        init();
    }

    private void init() {
        setCustomFont(R.styleable.TextView_font);
    }

    private void setCustomFont(int customFontId) {
        fontWriter.setCustomFont(customFontId);
    }

    public void setCustomFont(String customFontName) {
        fontWriter.setCustomFont(customFontName);
    }

}
