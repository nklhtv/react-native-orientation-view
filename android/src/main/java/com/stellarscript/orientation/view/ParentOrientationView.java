package com.stellarscript.orientation.view;

import android.content.Context;

final class ParentOrientationView extends OrientationView {

    public ParentOrientationView(final Context context) {
        super(context);
    }

    @Override
    boolean isInPortrait() {
        final int height = getHeight();
        final int width = getWidth();
        return height >= width;
    }

}
