let user = null;

const getToken = () => {
  return user ? user.token : null;
}

const isLoggedIn = () => {
  return user !== null;
}

const login = (token) => {
  user = { token };
}

const logout = () => {
  user = null;
}

export const useAuth = () => {
  return { auth: { getToken, isLoggedIn, login, logout } };
}
