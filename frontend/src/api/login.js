import http from "./http";

export async function login(username, password) {
  return http.post(
    "/login",
    {
      username: username,
      password: password,
    },
    {
      "content-type": "application/json",
      Accept: "application/json",
    }
  );
}
