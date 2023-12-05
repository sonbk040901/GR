import { Button } from "@rneui/themed";
import { StatusBar } from "expo-status-bar";
import React from "react";
import { StyleSheet, View } from "react-native";
// import {} from ""
import MapView, { Marker } from "react-native-maps";
import { COLOR } from "../constants/color";
import { MapRouteProp, RootNavigationProp } from "../types/navigation";

interface MapProps {
  navigation: RootNavigationProp;
  route: MapRouteProp;
}

const Map = ({ navigation, route }: MapProps) => {
  const mapRef = React.useRef<MapView>(null);
  return (
    <View style={styles.container}>
      <StatusBar style="dark" />
      <View
        style={{
          position: "absolute",
          top: 25,
          left: 2,
          zIndex: 999,
        }}
      >
        <Button
          icon={{
            name: "arrow-back-outline",
            type: "ionicon",
            color: COLOR.primary,
            size: 30,
          }}
          type="clear"
          raised
          onPress={() => navigation.goBack()}
        />
      </View>
      <MapView
        ref={mapRef}
        style={{ flex: 1, width: "100%" }}
        camera={{
          center: {
            latitude: 21.007326,
            longitude: 105.847328,
          },
          pitch: 0,
          heading: 0,
          altitude: 0,
          zoom: 15,
        }}
      >
        <Marker
          coordinate={{
            latitude: 21.007326,
            longitude: 105.847328,
          }}
          title="Đại học Bách Khoa Hà Nội"
          description="ffad"
          onPress={() => {
            mapRef.current?.fitToCoordinates(
              [
                {
                  latitude: 21.007326,
                  longitude: 105.847328,
                },
                {
                  latitude: 21.008,
                  longitude: 105.85,
                },
              ],
              {
                animated: true,
              },
            );
          }}
        />
        <Marker
          coordinate={{
            latitude: 21.008,
            longitude: 105.85,
          }}
          title="Đại học Bách Khoa Hà Nội"
          description="ffad"
          onPress={() => {
            mapRef.current?.fitToCoordinates(
              [
                {
                  latitude: 21.007326,
                  longitude: 105.847328,
                },
                {
                  latitude: 21.008,
                  longitude: 105.85,
                },
              ],
              {
                edgePadding: {
                  top: 50,
                  right: 50,
                  bottom: 50,
                  left: 50,
                },
                animated: true,
              },
            );
          }}
        />
      </MapView>
    </View>
  );
};

export default Map;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    width: "100%",
    // flexDirection: "row",
    position: "relative",
    backgroundColor: "#ffffffff",
  },
});
