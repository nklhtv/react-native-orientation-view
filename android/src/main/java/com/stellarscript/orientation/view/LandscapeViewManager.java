package com.stellarscript.orientation.view;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

final class LandscapeViewManager extends ViewGroupManager<LandscapeView> {

    private static final String REACT_CLASS = "RCT" + LandscapeView.class.getSimpleName();

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected LandscapeView createViewInstance(final ThemedReactContext themedReactContext) {
        return new LandscapeView(themedReactContext);
    }

}
