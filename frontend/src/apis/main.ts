const api = {
  login: "/login",

  updateAvatar: "/user/no-pass/avatar/",
  updateProfile: "/user/no-pass/profile/",
  getUserProfile: "/user/info",
  userList: "/user/all/point",
  registerUser: "/user",
  deleteUser: "/user/",

  updateQuestion: "/question/no-pass",
  getQuestion: "/question/pass/",
  questionList: "/test/question-lists",
  getQuestionListOfOneAuthor: "/question/no-pass/author-all/",
  newQuestion: "/question/no-pass",
  questionDetail: "/test/question-detail/",
  deleteQuestion: "/question/no-pass/",

  getAllComments: "/comment/pass",
  getCommentList: "/test/comments/",
  getCommentListOfOneAuthor: "/comment/no-pass/author-all/",
  newComment: "/comment",
  deleteComment: "/comment/",
  updateComment: "/comment/no-pass",
  getSingleComment: "/comment/pass/",

  getPoint: "/point/info",

  getTagList: "/tag/tags/",

  getBestAnswer: "/best-answer/pass/",
  markBest: "/best-answer/no-pass/mark-best",

  getCollectionListOfOneAuthor: "/collection/no-pass/user/",
  newCollection: "/collection",
  deleteCollection: "/collection/",
  addQuestion: "/collection/no-pass/add-question",

  getQuestionAuthor: (questionId: string) => {
    return "/question/pass/" + questionId + "/author";
  },
};

export default api;
