import http from "./http";

export async function signup(username, password) {
  return http.post(
    "/api/v1/user/signup",
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
