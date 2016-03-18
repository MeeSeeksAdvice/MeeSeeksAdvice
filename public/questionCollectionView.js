var Backbone = require ('backbone');
var _ = require('underscore');
var tmpl = require('./templates');
var $ = require('jquery');
var QuestionModelView= require ('./questionModelView');

module.exports = Backbone.View.extend({
  el: '.question-display-container',
  initialize: function () {
    this.addAll();
    this.listenTo(this.collection, 'update', this.addAll);
  },
  addOne: function (model) {
    var modelView = new QuestionModelView({model: model});
    console.log('test', modelView);
    this.$el.append(modelView.render().el);
  },
  addAll: function () {
    _.each(this.collection.models, this.addOne, this);
    console.log('what am i',this.$el)
    window.glob = this;
  }
});
