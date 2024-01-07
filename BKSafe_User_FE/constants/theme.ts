import { createTheme } from "@rneui/themed";
export const theme = createTheme({
  lightColors: {
    primary: "#1F87FE",
    secondary: "#6E7E91",
    success: "#00C48C",
    warning: "#FF8A00",
    error: "#FF3D71",
    black: "#2D3142",
    white: "#FFFFFF",
  },
  darkColors: {
    primary: "#1F87FE",
    secondary: "#6E7E91",
    success: "#00C48C",
    warning: "#FF8A00",
    error: "#FF3D71",
    black: "#2D3142",
    white: "#FFFFFF",
  },
  mode: "light",
  components: {
    Button: { radius: "md" },
    Icon: {
      color: "#1F87FE",
    },
  },
});
