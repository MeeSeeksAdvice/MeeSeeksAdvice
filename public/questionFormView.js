var Backbone = require ('backbone');
var tmpl = require ('./templates');
var _ = require ('underscore');
var $ = require ('jquery');
var QuestionModel = require ('./questionModel');
var LogoutModel = require ('./logoutModel');

module.exports = Backbone.View.extend ({
  el: '.question-container',
  template: _.template(tmpl.questionForm),
  events: {
    'submit .question-form' : 'submitQuestion',
    'click .logout-button' : 'logoutUser'
  },
  submitQuestion: function (event) {
    event.preventDefault();
    this.model.set({
        question: this.$el.find('.question-input').val(),

    });
    this.model.save();
    this.collection.fetch().success(function (data) {

   console.log('we are fetching and done');
 });
    this.model = new QuestionModel({});
    this.$el.find('input').val('');
  },
  initialize: function () {
    this.model = new QuestionModel ({});
    this.render();
  },
  render: function () {
    var markup = this.template(this.model.toJSON());
    this.$el.html(markup);
    return this;
  },
  logoutUser: function() {
    event.preventDefault();
    console.log("CLICKY LOGOUT");
    var logout = new LogoutModel();
    $('.login-in-page').removeClass('inactive');
    $('.advice-page').addClass('inactive');
    location.reload(true);
  },
});
