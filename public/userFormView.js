var Backbone = require('backbone');
var tmpl = require('./templates');
var _ = require('underscore');
var $ = require ('jquery');
var UserModel = require ('./userModel');
var QuestionCollection = require ('./questionCollection');
var QuestionCollectionView = require ('./questionCollectionView');
var QuestionForm = require ('./questionFormView');

module.exports = Backbone.View.extend({
  el: '.login-container',
  template: _.template(tmpl.userFormTmpl),
  events: {
    'submit .user-login-form' : 'submitUsername'
  },
  submitUsername: function (event) {
    event.preventDefault();
    this.model.set({
      userName: this.$el.find('.user-login-input').val(),
    });
    this.model.save();
    this.model = new UserModel ({});
    $('.login-in-page').addClass('inactive');
    $('.advice-page').removeClass('inactive');
    var questioncollection = new QuestionCollection();
    questioncollection.fetch().then(function(data){
      console.log("QUESTSIONS", data);
        var postMarkUp = new QuestionCollectionView({collection : questioncollection});
        var addQuestionForm = new QuestionForm({collection: questioncollection});
      // }
      });
  },
  initialize: function () {
    this.model = new UserModel({});
    this.render();
  },
  hide: function () {
    var userName = this.$el.find('.user-login-input').val();
    $('.question-display-container').hide();
    $('.question-display-container').find('#' + userName);
  },
  render: function () {
    var markup = this.template(this.model.toJSON());
    this.$el.html(markup);
    return this;
  }

});
