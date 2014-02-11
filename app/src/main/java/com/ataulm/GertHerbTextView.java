package com.ataulm;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ataulm.gertherb.R;

public class GertHerbTextView extends TextView {

    private final FontWriter fontWriter;

    public GertHerbTextView(Context context) {
        super(context);
        fontWriter = FontWriter.create(this, null, R.styleable.TextView);
    }

    public GertHerbTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        fontWriter = FontWriter.create(this, attrs, R.styleable.TextView);
        init();
    }

    public GertHerbTextView(Context context, AttributeSet attrs, int defStyle) {
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
