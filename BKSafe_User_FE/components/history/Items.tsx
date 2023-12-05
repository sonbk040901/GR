import React from "react";
import { FlatList, StyleSheet, View } from "react-native";
import Item, { ItemProps } from "./Item";

interface ItemsProps {
  data: ItemProps[];
  onSelected?: (item: Omit<ItemProps, "onPress">) => void;
}

const Items = (props: ItemsProps) => {
  const { data, onSelected } = props;

  return (
    <View style={styles.container}>
      <FlatList
        showsVerticalScrollIndicator={false}
        style={{ width: "100%" }}
        data={data}
        renderItem={(data) => (
          <Item
            {...data.item}
            onPress={() => onSelected?.(data.item)}
          />
        )}
        keyExtractor={(item) => item.id.toString()}
      />
    </View>
  );
};

export default Items;

const styles = StyleSheet.create({
  container: { flex: 1 },
});
