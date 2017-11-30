package com.stellarscript.orientation.view;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

public class ParentOrientationViewManager extends ViewGroupManager<ParentOrientationView> {

    private static final String REACT_CLASS = "RCT" + ParentOrientationView.class.getSimpleName();

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected ParentOrientationView createViewInstance(final ThemedReactContext themedReactContext) {
        return new ParentOrientationView(themedReactContext);
    }

}
