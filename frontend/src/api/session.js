import http from "./http";

// reference: https://github.com/axios/axios/issues/943
export async function sessioninfo(sessionid) {
  return http.request({
      url: "/api/v1/user/success",
      method: "get",
      headers:{
        Cookie: `JSESSIONID=${sessionid};`,
        Accept: "application/json",
        "content-type": "application/json",
      },
      withCredentials:true
    }
  );
}
