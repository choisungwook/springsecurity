import http from "./http";

export async function login(formdata) {
  return http.post(
    "/api/v1/user/login",
    formdata,
    {
      "content-type": "application/json",
      Accept: "application/json",
    }
  );
}
