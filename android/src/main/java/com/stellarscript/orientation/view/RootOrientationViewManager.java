package com.stellarscript.orientation.view;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

final class RootOrientationViewManager extends ViewGroupManager<RootOrientationView> {

    private static final String REACT_CLASS = "RCT" + RootOrientationView.class.getSimpleName();

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected RootOrientationView createViewInstance(final ThemedReactContext themedReactContext) {
        return new RootOrientationView(themedReactContext);
    }

}
