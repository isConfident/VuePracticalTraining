import axios from "axios";
import nProgress from "nprogress";
import "nprogress/nprogress.css";

const axios_get = axios.create({
  baseURL: "/static",
  timeout: 5000
});

axios_get.interceptors.request.use(config => {
  nProgress.start();
  return config;
});

axios_get.interceptors.response.use(
  res => {
    nProgress.done();
    return res;
  },
  error => {
    console.log(error.message);
    return Promise.reject(error);
  }
);
export default axios_get;
// export default {
//   axios_get(url, data) {
//     return new Promise((resolove, reject) => {
//       axios
//         .get(url, data)
//         .then(res => {
//           resolove(res.data);
//         })
//         .catch(error => {
//           reject(error);
//         });
//     });
//   }
// };
