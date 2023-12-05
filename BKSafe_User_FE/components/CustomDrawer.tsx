import React from "react";
import { Text, View, StyleSheet, TouchableNativeFeedback } from "react-native";
import { DrawerContentComponentProps } from "@react-navigation/drawer";
import { COLOR } from "../constants/color";
import { Avatar, Icon } from "@rneui/themed";
import CustomDrawerItem from "./CustomDrawerItem";
const drawerItems: {
  name: string;
  icon: string;
  route: string;
}[] = [
  { name: "Home", icon: "home", route: "Home" },
  { name: "History", icon: "file-text", route: "History" },
  { name: "Profile", icon: "user", route: "Profile" },
  { name: "Setting", icon: "settings", route: "Setting" },
];

const CustomDrawer = ({ navigation, state }: DrawerContentComponentProps) => {
  return (
    <View style={styles.container}>
      <View style={styles.userItem}>
        <Icon
          name="close"
          size={30}
          color="white"
          style={styles.closeIcon}
          onPress={() => navigation.closeDrawer()}
        />
        <TouchableNativeFeedback onPress={() => navigation.navigate("Profile")}>
          <View style={styles.userInfo}>
            <Avatar
              size={50}
              source={require("../assets/images/avatar.png")}
              avatarStyle={{
                resizeMode: "contain",
                width: 50,
                height: 50,
              }}
              containerStyle={styles.avatar}
            />
            <View style={styles.info}>
              <Text style={styles.fullName}>Lê Đức Sơn</Text>
              <Text style={styles.email}>leducson007@gmail.com</Text>
            </View>
          </View>
        </TouchableNativeFeedback>
      </View>
      <View>
        {state.routes.map((route, index) => {
          const focused = index === state.index;
          return (
            <CustomDrawerItem
              key={route.key}
              focused={focused}
              {...drawerItems[index]}
              onPress={() => navigation.navigate(route.name)}
            />
          );
        })}
      </View>
    </View>
  );
};

export default CustomDrawer;

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  closeIcon: { alignSelf: "flex-end" },
  userItem: {
    height: 120,
    padding: 10,
    backgroundColor: COLOR.primary,
  },
  userInfo: {
    flex: 1,
    flexDirection: "row",
    justifyContent: "flex-start",
    gap: 10,
    alignItems: "center",
    borderRadius: 10,
  },
  avatar: {
    overflow: "hidden",
    borderRadius: 10,
    shadowColor: "#000",
    shadowOffset: {
      width: 0,
      height: 3,
    },
    shadowOpacity: 0.29,
    shadowRadius: 4.65,
    elevation: 7,
  },
  info: {},
  fullName: { fontWeight: "bold", fontSize: 20, color: "white" },
  email: { fontWeight: "500", fontSize: 15, color: "white" },
});
