import React, { Component, PropTypes } from 'react';
import { View } from 'react-native';
import PortraitView from '../portraitView';
import LandscapeView from '../landscapeView';

class ParentOrientationView extends Component {
    constructor(props) {
        super(props);

        this.onLayout = this.onLayout.bind(this);

        this.state = {
            isInPortrait: props.initialIsInPortrait
        };
    }

    onLayout(event) {
        const { width, height } = event.nativeEvent.layout;
        this.setState({ isInPortrait: height >= width });
        if (typeof this.props.onLayout === 'function') {
            this.props.onLayout(event);
        }
    }

    render() {
        const children = this.props.children.filter((child) => {  
            return (child.type === LandscapeView && !this.state.isInPortrait) ||
                (child.type === PortraitView && this.state.isInPortrait);
        });
        
        return (
            <View {...this.props} children={children} onLayout={this.onLayout} />
        );
    }
}

ParentOrientationView.propTypes = {
    initialIsInPortrait: PropTypes.bool.isRequired
};

ParentOrientationView.defaultProps = {
    initialIsInPortrait: true
};

export default ParentOrientationView;
