import React, { Component } from 'react';
import { StyleSheet, Text, View, Dimensions, TouchableOpacity } from 'react-native';
import { OrientationView, LandscapeView, PortraitView } from 'react-native-orientation-view';

class App extends Component {
    constructor(props) {
        super(props);

        this.state = {
            approach: 'dimensions'
        };
    }

    componentDidMount() {
        Dimensions.addEventListener('change', () => {
            this.forceUpdate();
        });
    }

    toggleApproach() {
        this.setState({
            approach: this.state.approach === 'dimensions' ? 'orientationview' : 'dimensions'
        });
    }

    render() {
        for (var i = 0; i < 300000; i++) {
            var x = new Date();
            console.log(i, x);
        }
        
        return (
            <View style={{flex: 1}}>

                <TouchableOpacity style={{height: 50, alignItems: 'center', justifyContent: 'center'}} onPress={this.toggleApproach.bind(this)}>
                    <Text>{this.state.approach}</Text>
                </TouchableOpacity>

                {
                    this.state.approach === 'dimensions' ?
                        this.renderDimensionsApproach()
                        :
                        this.renderOrientationViewApproach()
                }

            </View>
        );
    }

    renderPortrait() {
        return (
            <View style={{flex: 1, flexDirection: 'row'}}>
                <View style={{flex: 1, backgroundColor: 'red'}}>
                    <Text>Portrait</Text>
                </View>
                <View style={{flex: 1, backgroundColor: 'blue'}}>
                    <Text>Portrait</Text>
                </View>
            </View>
        );
    }

    renderLandscape() {
        return (
            <View style={{flex: 1, flexDirection: 'column'}}>
                <View style={{flex: 1, backgroundColor: 'yellow'}}>
                    <Text>Landscape</Text>
                </View>
                <View style={{flex: 1, backgroundColor: 'green'}}>
                    <Text>Landscape</Text>
                </View>
            </View>
        );
    }

    renderDimensionsApproach() {
        const { height, width } = Dimensions.get('window');
        if (height >= width) {
          return this.renderPortrait();
        } else {
          return this.renderLandscape();
        }
    }

    renderOrientationViewApproach() {
        return (
            <OrientationView style={{flex: 1}}>
                <LandscapeView style={StyleSheet.absoluteFill}>{this.renderLandscape()}</LandscapeView>
                <PortraitView style={StyleSheet.absoluteFill}>{this.renderPortrait()}</PortraitView>
            </OrientationView>
        );
    }
}

export default App;
