import http from "./http";

export async function login(formdata) {
  return http.post(
    "/login",
    formdata,
    {
      "content-type": "application/json",
      Accept: "application/json",
    }
  );
}
