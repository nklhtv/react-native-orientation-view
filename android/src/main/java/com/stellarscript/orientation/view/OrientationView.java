package com.stellarscript.orientation.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.facebook.react.views.view.ReactViewGroup;

import java.util.HashSet;

final class OrientationView extends ReactViewGroup {

    private static final String TAG = OrientationView.class.getSimpleName();

    private final HashSet<View> mAllChildren;
    private final HashSet<View> mHiddenChildren;

    public OrientationView(final Context context) {
        super(context);
        mAllChildren = new HashSet<>();
        mHiddenChildren = new HashSet<>();
    }

    @Override
    public void onViewAdded(final View child) {
        super.onViewAdded(child);
        mAllChildren.add(child);
        if (!(child instanceof PortraitView) && !(child instanceof LandscapeView)) {
            Log.w(TAG, "OrientationView supports only PortraitView and LandscapeView children");
        }
    }

    @Override
    public void onViewRemoved(final View child) {
        super.onViewRemoved(child);
        if (!mHiddenChildren.contains(child)) {
            mAllChildren.remove(child);
        }
    }

    @Override
    @SuppressLint("DrawAllocation")
    protected void onLayout(final boolean changed, final int left, final int top, final int right, final int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            final int height = getHeight();
            final int width = getWidth();
            final boolean isInPortrait = height >= width;
            final HashSet<View> childrenToHide = new HashSet<>();
            final HashSet<View> childrenToAdd = new HashSet<>();
            final HashSet<View> childrenToRemove = new HashSet<>();

            for (final View child : mAllChildren) {
                if (child instanceof PortraitView) {
                    if (isInPortrait) {
                        childrenToAdd.add(child);
                    } else {
                        childrenToHide.add(child);
                    }
                }
                else if (child instanceof LandscapeView) {
                    if (isInPortrait) {
                        childrenToHide.add(child);
                    } else {
                        childrenToAdd.add(child);
                    }
                }
                else {
                    childrenToRemove.add(child);
                }
            }

            mAllChildren.clear();
            mHiddenChildren.clear();
            for (final View child : childrenToRemove) {
                removeView(child);
            }
            for (final View child : childrenToHide) {
                hideView(child);
            }
            for (final View child : childrenToAdd) {
                final ViewParent parent = child.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(child);
                }

                addView(child);
            }
        }
    }

    private void hideView(final View child) {
        mHiddenChildren.add(child);
        mAllChildren.add(child);
        removeView(child);
    }

}
