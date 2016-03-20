var Backbone = require('backbone');
var $ = require ('jquery');
var UserFormView = require ('./userFormView');
var QuestionForm = require ('./questionFormView');
var QuestionCollection = require ('./questionCollection');
var QuestionCollectionView = require ('./questionCollectionView');
var AnswerCollection = require ('./answerCollection');
var AnswerCollectionView = require ('./AnswerCollectionView');
var AnswerSubmitView = require ('./answerSubmitView');

$(document).ready(function () {
  var addUserForm = new UserFormView();
  var questioncollection = new QuestionCollection();
  var answersubmitview = new AnswerSubmitView();
  questioncollection.fetch().then(function(data){
    console.log("QUESTSIONS", data);
    // if ($('.questionDisplay').attr('id') === userName) {
      var postMarkUp = new QuestionCollectionView({collection : questioncollection});
      var addQuestionForm = new QuestionForm({collection: questioncollection});
    // },
    });
  var answercollection = new AnswerCollection();
  answercollection.fetch().then(function(data){
      console.log("ANSWERS", data);
      var postMarkUp2 = new AnswerCollectionView({collection : answercollection});
  });
});
