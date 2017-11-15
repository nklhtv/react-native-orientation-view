import React from 'react';
import { requireNativeComponent } from 'react-native';

const RCTPortraitView = requireNativeComponent('RCTPortraitView');

const PortraitView = (props) => (
    <RCTPortraitView {...props} />
);

export default PortraitView;
