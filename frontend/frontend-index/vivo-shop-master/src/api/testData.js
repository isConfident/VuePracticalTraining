import requests from "./testBackendInterface";

export const getNewsData = () => {
  return requests({
    url: "news/getAllNews",
    method: "get"
  });
};

export const getHomeData = () => {
  return requests({
    url: "",
    method: "get"
  });
};
