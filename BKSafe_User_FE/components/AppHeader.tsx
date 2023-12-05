import { DrawerHeaderProps } from "@react-navigation/drawer";
import React, { FC } from "react";
import { Text, View, StyleSheet } from "react-native";
import { COLOR } from "../constants/color";
import { SafeAreaView } from "react-native-safe-area-context";
import { Button } from "@rneui/themed";

const AppHeader: FC<DrawerHeaderProps> = ({ navigation, route }) => {
  return (
    <SafeAreaView style={styles.container}>
      <Text
        style={{
          textAlign: "center",
          color: "white",
          fontSize: 30,
          fontWeight: "bold",
        }}
      >
        {route.name === "Home" ? "BKSafe" : route.name}
      </Text>
      <View
        style={{
          position: "absolute",
          bottom: 0,
          left: 0,
          justifyContent: "center",
          alignItems: "center",
          height: "100%",
        }}
      >
        <Button
          radius="sm"
          buttonStyle={{ backgroundColor: "transparent" }}
          icon={{
            name: "menu",
            size: 35,
            color: "white",
            type: "feather"
          }}
          onPress={() => {
            navigation.toggleDrawer();
          }}
        />
      </View>
    </SafeAreaView>
  );
};

export default AppHeader;

const styles = StyleSheet.create({
  container: {
    height: 120,
    backgroundColor: COLOR.primary,
    // flexDirection: "row",
    justifyContent: "center",
    alignContent: "center",
  },
});
