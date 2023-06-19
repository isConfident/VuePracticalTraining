import axios from "axios";
import nProgress from "nprogress";
import "nprogress/nprogress.css";

const requests = axios.create({
  baseURL: "http://localhost:8080/Foreground_war_exploded/api",
  timeout: 5000
});

requests.interceptors.request.use(config => {
  nProgress.start();
  return config;
});

requests.interceptors.response.use(
  res => {
    nProgress.done();
    return res;
  },
  error => {
    console.log(error.message);
    return Promise.reject(error);
  }
);
export default requests;
// export default {
//   requests(url, data) {
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
