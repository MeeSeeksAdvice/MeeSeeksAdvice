var Backbone = require ('backbone');
var tmpl = require ('./templates');
var _ = require ('underscore');
var $ = require ('jquery');
var AnswerModel = require ('./answerModel');

module.exports = Backbone.View.extend({
el: '.answer-display-container',
template: _.template(tmpl.answerDisplay),
events: {
  'click .question-button' : 'addAnswer'
},
addAnswer: function (event) {
  event.preventDefault();
  this.model = new AnswerModel({});
  console.log ("answerSubmitView//line18", this.model);
},
initialize: function() {
  this.model = new AnswerModel ({});
  this.render();
},
});
