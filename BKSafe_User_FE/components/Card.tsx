import React, { PropsWithChildren } from "react";
import { View, StyleSheet, StyleProp, ViewStyle } from "react-native";

interface CardProps extends PropsWithChildren {
  style?: StyleProp<ViewStyle>;
}

const Card = ({ children, style }: CardProps) => {
  return (
    <View style={[styles.container, styles.shadow, style]}>{children}</View>
  );
};

export default Card;

const styles = StyleSheet.create({
  container: {
    width: 330,
    borderRadius: 20,
    backgroundColor: "white",
    padding: 15,
    zIndex: 100,
  },
  shadow: {
    shadowColor: "#000",
    shadowOffset: {
      width: 0,
      height: 5,
    },
    shadowOpacity: 0.35,
    shadowRadius: 7,
    elevation: 5,
  },
});
