const api = {
  userList: "/user/all/point",
  questionList: "/test/question-lists",
  registerUser: "/user",
  login: "/login",
  questionDetail: "/test/question-detail/",
  getCommentList: "/test/comments/",
  getUserProfile: "/user/info",
  getPoint:"/point/info",
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
