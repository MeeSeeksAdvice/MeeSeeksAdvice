var Backbone = require ('backbone');
var _ = require('underscore');
var tmpl = require('./templates');
var QuestionModel = require ('./questionModel');

module.exports = Backbone.View.extend({
  el: '.question-display-container',
  initialize: function () {
      this.addAll();
      this.listenTo(this.collection, 'update', this.addAll);
  },
  addOne: function (model) {
    var modelView = new QuestionModel({model: model});
    this.$el.append(modelView.render());
  },
  addAll: function () {
    _.each (this.collection.models, this.addOne, this);
  }
});
