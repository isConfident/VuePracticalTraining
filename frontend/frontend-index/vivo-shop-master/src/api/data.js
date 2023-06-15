import axios_get from "./http";

export const getData = () => {
  return axios_get({
    url: "/data.json",
    method: "get"
  }); //模拟接口
};

// export function getData() {
//     return http.axios_get('/static/data.json') //模拟接口
// }
