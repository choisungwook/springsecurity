import http from "./http";

export async function sessioninfo() {
  return http.get(
    "/success",
    {},
    {
      "content-type": "application/json",
      Accept: "application/json",
    }
  );
}
