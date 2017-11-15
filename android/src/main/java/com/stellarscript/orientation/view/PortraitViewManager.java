package com.stellarscript.orientation.view;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

public class PortraitViewManager extends ViewGroupManager<PortraitView> {

    private static final String REACT_CLASS = "RCT" + PortraitView.class.getSimpleName();

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected PortraitView createViewInstance(final ThemedReactContext themedReactContext) {
        return new PortraitView(themedReactContext);
    }

}
