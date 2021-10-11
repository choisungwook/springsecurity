import http from "./http";

export async function signup(username, password) {
  return http.post(
    "/users",
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
