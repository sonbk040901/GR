import { Icon, IconProps } from "@rneui/themed";
import React, { useEffect, useRef, useState } from "react";
import { StyleSheet, View } from "react-native";
import { TextInput } from "react-native-gesture-handler";

interface ItemProps {
  icon?: Partial<IconProps>;
  name: IconProps["name"];
  content: string;
}
const Item = ({ icon, name, content }: ItemProps) => {
  const [isChange, setIsChange] = useState(false);
  const inputRef = useRef<TextInput>(null);
  useEffect(() => {
    inputRef.current?.[isChange ? "focus" : "blur"]();
  }, [isChange]);
  return (
    <View style={styles.wrapper}>
      <View style={styles.container}>
        <Icon
          name={name}
          size={25}
          type="feather"
          {...icon}
        />
        <View style={{ flex: 1 }}>
          <TextInput
            ref={inputRef}
            numberOfLines={1}
            style={styles.text}
            editable={isChange}
          >
            {content}
          </TextInput>
        </View>
        <Icon
          name={isChange ? "edit-3" : "edit-2"}
          size={25}
          type="feather"
          style={{
            paddingHorizontal: 5,
            paddingVertical: 2,
          }}
          containerStyle={{
            borderRadius: 5,
          }}
          onPress={() => setIsChange(!isChange)}
        />
      </View>
    </View>
  );
};

export default Item;

const styles = StyleSheet.create({
  wrapper: {
    marginVertical: 5,
    borderBottomColor: "gray",
    borderBottomWidth: 0.5,
  },
  container: {
    flexDirection: "row",
    paddingVertical: 10,
    borderRadius: 5,
    alignItems: "center",
    gap: 15,
    justifyContent: "space-between",
  },
  text: {
    fontSize: 20,
    // fontWeight: "500",
  },
});
