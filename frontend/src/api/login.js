import http from "./http";

export async function login(params) {
  return http.post(
    "/api/v1/user/login",
    params,
    {
      "content-type": "application/json",
      Accept: "application/json",
    }
  );
}
