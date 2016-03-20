var Backbone = require('backbone');
var $ = require ('jquery');
var UserFormView = require ('./userFormView');
var QuestionForm = require ('./questionFormView');
var QuestionCollection = require ('./questionCollection');
var QuestionCollectionView = require ('./questionCollectionView');

$(document).ready(function () {
  var addUserForm = new UserFormView();
  var questioncollection = new QuestionCollection();
  questioncollection.fetch().then(function(data){
    console.log("QUESTSIONS", data);
      var postMarkUp = new QuestionCollectionView({collection : questioncollection});
      var addQuestionForm = new QuestionForm({collection: questioncollection});
    // }
    });
});
