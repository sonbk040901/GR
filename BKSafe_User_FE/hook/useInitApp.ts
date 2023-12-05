import { useState } from "react";

export default () => {
  const [isLoading, setIsLoading] = useState(true);
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  return [isLoading, isAuthenticated] as const;
};
