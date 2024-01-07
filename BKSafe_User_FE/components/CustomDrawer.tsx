import { DrawerContentComponentProps } from "@react-navigation/drawer";
import { Avatar, Icon } from "@rneui/themed";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import { TouchableOpacity } from "react-native-gesture-handler";
import { COLOR } from "../constants/color";
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
        <TouchableOpacity onPress={() => navigation.closeDrawer()}>
          <Icon
            name="close"
            type="ionicon"
            size={35}
            color="white"
            style={styles.closeIcon}
          />
        </TouchableOpacity>
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
      </View>
      <View style={styles.drawerItem}>
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
      <View style={styles.drawerFooter}>
        <Text>
          <Text style={{ fontWeight: "bold" }}>BKSafe</Text> &copy;2024 by{" "}
          <Text style={{ fontWeight: "bold", fontStyle: "italic" }}>
            Lê Đức Sơn
          </Text>
        </Text>
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
  drawerItem: {
    flex: 1,
  },
  drawerFooter: {
    height: 30,
    justifyContent: "center",
    alignItems: "center",
  },
  info: {},
  fullName: { fontWeight: "bold", fontSize: 20, color: "white" },
  email: { fontWeight: "500", fontSize: 15, color: "white" },
});
