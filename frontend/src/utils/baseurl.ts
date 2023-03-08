import axios from "axios";

const backend = axios.create({
  baseURL: "http://127.0.0.1:38643",
});

const search = axios.create({
  baseURL: "http://127.0.0.1:9200",
});

export { backend, search };