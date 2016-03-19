var Backbone = require('backbone');
var $ = require ('jquery');
var UserFormView = require ('./userFormView');
var QuestionForm = require ('./questionFormView');
var QuestionCollection = require ('./questionCollection');
var QuestionCollectionView = require ('./questionCollectionView');

$(document).ready(function () {
  var addUserForm = new UserFormView();
  var addQuestionForm = new QuestionForm();
  var questioncollection = new QuestionCollection();
  // new QuestionCollectionView({})
    questioncollection.fetch().then(function(data){
      var postMarkUp = new QuestionCollectionView({collection : questioncollection});
    });
});
