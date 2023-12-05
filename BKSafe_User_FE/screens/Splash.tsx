import React, { useEffect } from "react";
import { ActivityIndicator, StyleSheet } from "react-native";
import type { RootNavigationProp } from "../types/navigation";
import { COLOR } from "../constants/color";
import { LinearGradient } from "expo-linear-gradient";
import { Image } from "@rneui/themed";
import useInitApp from "../hook/useInitApp";
interface SplashProps {
  navigation: RootNavigationProp;
}
const Splash = ({ navigation }: SplashProps) => {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [isLoading, isAuthenticated] = useInitApp();
  useEffect(() => {
    setTimeout(() => {
      navigation.replace("App");
    }, 2000);
  }, [navigation]);
  return (
    <LinearGradient
      colors={["#8abfff", COLOR.primary]}
      style={styles.container}
    >
      <Image
        source={require("../assets/images/logo.png")}
        style={{
          width: "100%",
          height: 250,
        }}
        resizeMode="contain"
      />
      <ActivityIndicator
        size="large"
        color="white"
      />
    </LinearGradient>
  );
};

export default Splash;

const styles = StyleSheet.create({
  container: {
    backgroundColor: COLOR.primary,
    flex: 1,
    justifyContent: "center",
  },
});
