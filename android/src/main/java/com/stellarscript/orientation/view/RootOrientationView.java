package com.stellarscript.orientation.view;

import android.content.Context;

final class RootOrientationView extends OrientationView {

    public RootOrientationView(final Context context) {
        super(context);
    }

    @Override
    boolean isInPortrait() {
        final int height = getRootView().getHeight();
        final int width = getRootView().getWidth();
        return height >= width;
    }

}
