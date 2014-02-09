package com.ataulm.gertherb;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.ataulm.TextView;

public class CodeView extends ListView {

    private int width;

    public CodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setLongestLine(String line) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        setListItemWidth(getLineWidth(line, inflater));
    }

    // TODO: fix so it's flexible with regards to working out the width of the view with the longest line
    private int getLineWidth(String line, LayoutInflater inflater) {
        TextView view = (TextView) inflater.inflate(R.layout.list_item_code, null);
        Paint paint = view.getPaint();
        Rect bounds = new Rect();
        paint.getTextBounds(line, 0, line.length(), bounds);
        view.invalidate();
        return bounds.width() + view.getTotalPaddingLeft() + view.getTotalPaddingRight();
    }

    private void setListItemWidth(int length) {
        this.width = length;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width, MeasureSpec.getSize(heightMeasureSpec));
    }
}
