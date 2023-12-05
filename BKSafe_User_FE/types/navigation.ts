import { DrawerNavigationProp } from "@react-navigation/drawer";
import { RouteProp } from "@react-navigation/native";
import { StackNavigationProp } from "@react-navigation/stack";
export type RootNavigationParamList = {
  Splash: undefined;
  App: undefined;
  Map: {
    type: "new" | "current" | "previous";
  };
  Auth: undefined;
};
export type RootNavigationProp = StackNavigationProp<RootNavigationParamList>;
export type AppNavigationParamList = {
  Home: undefined;
  Settings: undefined;
  Profile: undefined;
};
export type AppNavigationProp = DrawerNavigationProp<AppNavigationParamList> &
  StackNavigationProp<RootNavigationParamList>;
export type AuthNavigationParamList = {
  GetStarted: undefined;
  Login: undefined;
  Register: undefined;
};
export type AuthNavigationProp = StackNavigationProp<AuthNavigationParamList> &
  StackNavigationProp<RootNavigationParamList>;
export type MapRouteProp = RouteProp<RootNavigationParamList, "Map">;