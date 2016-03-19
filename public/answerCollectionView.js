var Backbone = require ('backbone');
var _ = require('underscore');
var tmpl = require('./templates');
var $ = require('jquery');
var AnswerModelView= require ('./answerModelView');

module.exports = Backbone.View.extend({
  el: '.answer-display-container',
  initialize: function () {
    this.addAll();
    this.listenTo(this.collection, 'update', this.addAll);
  },
  addOne: function (model) {
    var modelView = new AnswerModelView({model: model});
    this.$el.append(modelView.render().el);
  },
  addAll: function () {
    _.each(this.collection.models, this.addOne, this);
  }
});
