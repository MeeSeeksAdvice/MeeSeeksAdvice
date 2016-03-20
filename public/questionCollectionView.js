var Backbone = require ('backbone');
var _ = require('underscore');
var tmpl = require('./templates');
var $ = require('jquery');
var QuestionModelView= require ('./questionModelView');
var AnswerModelView = require ('./answerModelView');

module.exports = Backbone.View.extend({
  el: '.question-display-container',
  initialize: function () {
    this.addAll();
    this.listenTo(this.collection, 'update', this.addAll);
    this.listenTo(this.collection, 'change', this.addAll);
    this.listenTo(this.collection, 'add', this.addAll);

  },
  addOne: function (model) {
    var modelView = new QuestionModelView({model: model});
    userName = modelView.model.attributes.user.userName;
    this.$el.prepend(modelView.render().el);
  },
  addAll: function () {
    _.each(this.collection.models, this.addOne, this);
  }
});
