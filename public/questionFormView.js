var Backbone = require ('backbone');
var tmpl = require ('./templates');
var _ = require ('underscore');
var $ = require ('jquery');
var QuestionModel = require ('./questionModel');

module.exports = Backbone.View.extend ({
  el: '.question-container',
  template: _.template(tmpl.questionForm),
  events: {
    'click .question-button' : 'submitQuestion'
  },
  submitQuestion: function (event) {
    event.preventDefault();
    this.model.set({
        question: this.$el.find('.question-input').val(),
    });
    this.model.save();
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
  }
});
