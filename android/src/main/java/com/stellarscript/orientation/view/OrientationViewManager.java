package com.stellarscript.orientation.view;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

final class OrientationViewManager extends ViewGroupManager<OrientationView> {

    private static final String REACT_CLASS = "RCT" + OrientationView.class.getSimpleName();

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected OrientationView createViewInstance(final ThemedReactContext themedReactContext) {
        return new OrientationView(themedReactContext);
    }

}
