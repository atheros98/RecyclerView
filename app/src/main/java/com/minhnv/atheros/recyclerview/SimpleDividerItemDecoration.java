package com.minhnv.atheros.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;

public class SimpleDividerItemDecoration extends ItemDecoration {
    private Drawable mDivider;
    int orientation;
    int spanCount;

    public SimpleDividerItemDecoration(Context context, int orientation, int spanCount) {
        mDivider = context.getResources().getDrawable(R.drawable.custom_divider);
        this.orientation = orientation;
        this.spanCount = spanCount;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (orientation == DividerItemDecoration.VERTICAL) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            int numRow = childCount / spanCount + (childCount % spanCount == 0 ? 0 : 1);
            for (int i = 0; i < numRow - 1; i++) {
                View child = parent.getChildAt(i * spanCount);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        } else {
            int top = parent.getPaddingTop();
            int bottom = parent.getHeight() - parent.getPaddingBottom();
            int childCount = parent.getChildCount();
            for (int i = 0; i < spanCount - 1; i++){
                View child = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                int left = child.getRight() + params.rightMargin;
                int right = left + mDivider.getIntrinsicWidth();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

    }

}
