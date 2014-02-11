package com.ataulm;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ataulm.gertherb.R;

public class GertHerbTextView extends TextView {

    private final FontWriter fontWriter;

    public GertHerbTextView(Context context) {
        super(context);
        fontWriter = FontWriter.create(this, null, R.styleable.GertHerbTextView);
    }

    public GertHerbTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        fontWriter = FontWriter.create(this, attrs, R.styleable.GertHerbTextView);
        init();
    }

    public GertHerbTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        fontWriter = FontWriter.create(this, attrs, R.styleable.GertHerbTextView);
        init();
    }

    private void init() {
        setCustomFont(R.styleable.GertHerbTextView_font);
    }

    private void setCustomFont(int customFontId) {
        fontWriter.setCustomFont(customFontId);
    }

    public void setCustomFont(String customFontName) {
        fontWriter.setCustomFont(customFontName);
    }

}
