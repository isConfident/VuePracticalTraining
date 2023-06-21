import requests from "./testBackendInterface";

export const getNewsData = () => {
  return requests({
    url: "news/query",
    method: "get"
  });
};

export const getHomeData = () => {
  return requests({
    url: "homeData/query",
    method: "get"
  });
};


