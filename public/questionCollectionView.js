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
    this.listenTo(this.collection, 'change', this.addAll);
    this.listenTo(this.collection, 'add', this.addAll);

  },
  addOne: function (model) {
      var modelView = new QuestionModelView({model: model});
      this.$el.prepend(modelView.render().el);
  },
  addAll: function () {
      this.$el.html('');
    _.each(this.collection.models, this.addOne, this);
  },


});
