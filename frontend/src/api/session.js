import http from "./http";

export async function sessioninfo() {
  return http.get(
    "/session",
    {},
    {
      "content-type": "application/json",
      Accept: "application/json",
    }
  );
}
