var Backbone = require('backbone');
var $ = require ('jquery');
var UserFormView = require ('./userFormView');
var QuestionForm = require ('./questionFormView');

$(document).ready(function () {
  var addUserForm = new UserFormView();
  var addQuestionForm = new QuestionForm();
});
