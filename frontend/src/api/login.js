import http from "./http";

export async function login(email, password) {
  return http.post(
    "/api/v1/user/signin",
    {
        email,
        password
    },
    {
      "content-type": "application/json",
      "Accept": "application/json",
    }
  );
}
