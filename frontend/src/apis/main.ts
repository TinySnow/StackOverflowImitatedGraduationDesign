const api = {
  login: "/login",

  updateAvatar: "/user/no-pass/avatar/",
  getUserProfile: "/user/info",
  userList: "/user/all/point",
  registerUser: "/user",
  deleteUser: "/user/",

  questionList: "/test/question-lists",
  getQuestionListOfOneAuthor:"/question/no-pass/author-all/",
  newQuestion: "/question/no-pass",
  questionDetail: "/test/question-detail/",


  getCommentList: "/test/comments/",
  getCommentListOfOneAuthor:"/comment/no-pass/author-all/",
  newComment: "/comment",
  deleteComment: "/comment/",


  getPoint: "/point/info",


  getTagList: "/tag/tags/",

  
  getQuestionAuthor: (questionId: string) => {
    return "/question/pass/" + questionId + "/author";
  }

};

export default api;
