var Backbone = require('backbone');
var tmpl = require('./templates');
var _ = require('underscore');
var $ = require ('jquery');
var UserModel = require ('./userModel');

module.exports = Backbone.View.extend({
  el: '.login-container',
  template: _.template(tmpl.userFormTmpl),
  events: {
    'click .user-login-button' : 'submitUsername'
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
  },
  initialize: function () {
    this.model = new UserModel({});
    this.render();
  },
  render: function () {
    var markup = this.template(this.model.toJSON());
    this.$el.html(markup);
    return this;
  }

});
