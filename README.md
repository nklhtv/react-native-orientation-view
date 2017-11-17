# react-native-orientation-view

### This component gives you an alternative way of writing orientation(size) specific UI in ReactNative by changing the ui on the UI Thread instead of JS thread.

#### How would you do the same using this plugin:
```javascript
render() {
  return (
    <OrientationView style={{flex: 1}}>
      <LandscapeView style={StyleSheet.absoluteFill}>{this.renderLandscape()}</LandscapeView>
      <PortraitView style={StyleSheet.absoluteFill}>{this.renderPortrait()}</PortraitView>
    </OrientationView>
  );
}
```

#### How would you declare orientation(size) specific UI in vanilla RN:
```javascript
render() {
  const {height, width} = Dimensions.get('window');
  if (height >= width) {
    return this.renderPortrait();
  } else {
    return this.renderLandscape();
  }
}
```

#### Or even worse using [react-native-orientation](https://github.com/yamill/react-native-orientation)
