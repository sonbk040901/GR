import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import "react-native-gesture-handler";
import { RootNavigationParamList } from "./types/navigation";
import AppNavigator from "./navigators/AppNavigator";
import AuthNavigator from "./navigators/AuthNavigator";
import Splash from "./screens/Splash";
import { StatusBar } from "expo-status-bar";
import Map from "./screens/Map";
import { ThemeProvider } from "@rneui/themed";
import { theme } from "./constants/theme";

const Stack = createStackNavigator<RootNavigationParamList>();
export default function Root() {
  return (
    <ThemeProvider theme={theme}>
      <NavigationContainer>
        <StatusBar style="light" />
        <Stack.Navigator
          screenOptions={{ headerShown: false, animationEnabled: true }}
        >
          <Stack.Screen
            name="Splash"
            component={Splash}
          />
          <Stack.Screen
            name="App"
            component={AppNavigator}
          />
          <Stack.Screen
            name="Auth"
            component={AuthNavigator}
          />
          <Stack.Screen
            name="Map"
            component={Map}
            options={{}}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </ThemeProvider>
  );
}
