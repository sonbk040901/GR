import * as React from "react";
import { Text, View, StyleSheet } from "react-native";
import type { AuthNavigationProp } from "../../types/navigation";
import { useFocusEffect, useNavigation } from "@react-navigation/native";

const Login = () => {
  const navigation = useNavigation<AuthNavigationProp>();
  useFocusEffect(() => {
    console.log(navigation.getState());
  });
  return (
    <View style={styles.container}>
      <Text>Login</Text>
    </View>
  );
};

export default Login;

const styles = StyleSheet.create({
  container: {},
});
