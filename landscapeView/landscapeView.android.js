import React from 'react';
import { requireNativeComponent } from 'react-native';

const RCTLandscapeView = requireNativeComponent('RCTLandscapeView');

const LandscapeView = (props) => (
    <RCTLandscapeView {...props} />
);

export default LandscapeView;
