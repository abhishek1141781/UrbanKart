//equal to function authHeader()
import store from '../redux/store';
import axios from 'axios';
import { clearCurrentUser } from '../redux/action';
import { history } from '../common/history';

export const authHeader = () => {
  const currentUser = store.getState().user;

  return {
    'Content-Type': 'application/json',
    Authorization: 'Bearer ' + currentUser?.token,
  };
};
export const authImageHeader = () => {
  const currentUser = store.getState().user;

  return {
    'Content-Type': 'multipart/form-data',
    authorization: 'Bearer ' + currentUser?.token,
  };
};

export function handleResponseWithLoginCheck() {
  axios.interceptors.response.use(
    (response) => response,
    (error) => {
      const currentUser = store.getState().user;
      const isLoggedIn = currentUser?.token;
      const status = error?.response?.status;

      if (isLoggedIn && [401, 403].includes(status)) {
        store.dispatch(clearCurrentUser());
        history.push('/login');
      }

      return Promise.reject(error);
    }
  );
}
export const getUserRole = () => {
  const currentUser = store.getState().user;
  return currentUser.role;
};
