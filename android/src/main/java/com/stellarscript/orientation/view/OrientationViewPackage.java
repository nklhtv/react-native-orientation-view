package com.stellarscript.orientation.view;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class OrientationViewPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(final ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(final ReactApplicationContext reactApplicationContext) {
        return Arrays.<ViewManager>asList(
                new OrientationViewManager(),
                new PortraitViewManager(),
                new LandscapeViewManager());
    }

}
