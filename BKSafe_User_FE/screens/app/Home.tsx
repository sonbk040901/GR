import React, { FC } from "react";
import { View, StyleSheet, ScrollView } from "react-native";
import type { AppNavigationProp } from "../../types/navigation";
import { COLOR } from "../../constants/color";
import { Button, Text } from "@rneui/themed";
import AppWrapper from "../../components/AppWrapper";
import TravelCard from "../../components/home/TravelCard";
import Card from "../../components/Card";
interface HomeProps {
  navigation: AppNavigationProp;
}
const Home: FC<HomeProps> = ({ navigation }) => {
  return (
    <AppWrapper>
      <View style={styles.container}>
        <Card style={styles.card}>
          <Text style={styles.cardTitle}>Xin chào, Lê Đức Sơn!</Text>
          <View style={styles.cardContent}>
            <Text style={styles.text}>Bạn muốn có một chuyến đi an toàn?</Text>
            <Text style={styles.text}>Hãy sử dụng BKSafe!</Text>
          </View>
          <Text style={styles.cardAction}>
            <Button
              title="Thuê tài xế ngay bây giờ"
              radius="md"
              buttonStyle={{ backgroundColor: COLOR.primary }}
              onPress={() => {
                navigation.push("Map", { type: "new" });
              }}
              icon={{
                name: "chevron-right",
                size: 20,
                color: "white",
                type: "feather",
              }}
              iconRight
            />
          </Text>
        </Card>
        <ScrollView
          style={{
            flex: 1,
            width: "100%",
          }}
        >
          <View style={{alignItems: "center", gap: 20, paddingVertical: 20}}>
            <TravelCard
              title="Chuyến đi hiện tại"
              status="finding"
              onPress={() => navigation.push("Map", { type: "current" })}
            />
            <TravelCard
              title="Chuyến đi hiện tại"
              status="finding"
              onPress={() => navigation.push("Map", { type: "current" })}
            />
          </View>
        </ScrollView>
      </View>
    </AppWrapper>
  );
};

export default Home;

const styles = StyleSheet.create({
  container: {
    alignItems: "center",
    flex: 1,
  },
  card: {
    alignItems: "center",
    gap: 10,
  },
  cardTitle: {
    fontSize: 20,
    fontWeight: "bold",
  },
  cardContent: {
    justifyContent: "center",
    alignItems: "center",
  },
  text: {
    fontSize: 16,
  },
  cardAction: {},
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
