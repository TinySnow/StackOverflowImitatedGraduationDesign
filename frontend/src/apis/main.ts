const api = {
  userList: "/user",
  questionList: "/test/question-lists",
  registerUser: "/user",
  login: "/login/body",
  questionDetail: "test/question-detail/",
  elastic: {
    search: (type: string) => {
      return type + "/_search";
    },
    content: (content: Object) => {
      return {
        query: {
          match: content,
        },
      };
    },
  },
};

export default api;
