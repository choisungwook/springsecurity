import http from "./http";

export async function sessioninfo(token) {
  return http.get(
    "/api/v1/user/success",
    {},    
    {
      "Authorization": `${token}`,
      "content-type": "application/json",
      "Accept": "application/json",
    }
  );
}
