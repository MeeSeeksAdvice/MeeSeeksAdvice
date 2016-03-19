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
  var addQuestionForm = new QuestionForm();
  var questioncollection = new QuestionCollection();
  var answersubmitview = new AnswerSubmitView();
  questioncollection.fetch().then(function(data){
      var postMarkUp = new QuestionCollectionView({collection : questioncollection});
    });
  var answercollection = new AnswerCollection();
  console.log('answer collection = ',answercollection);
  answercollection.fetch().then(function(data){
      var postMarkUp2 = new AnswerCollectionView({collection : answercollection});
  });
});
