import * as React from "react";
import { Text, View, StyleSheet } from "react-native";
import AppWrapper from "../../components/AppWrapper";
import { AppNavigationProp } from "../../types/navigation";

interface SettingProps {
  navigation: AppNavigationProp;
}

const Setting = ({}: SettingProps) => {
  return (
    <AppWrapper>
      <View style={styles.container}>
        <Text>Setting</Text>
      </View>
    </AppWrapper>
  );
};

export default Setting;

const styles = StyleSheet.create({
  container: {},
});
