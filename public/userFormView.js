var Backbone = require('backbone');
var tmpl = require('./templates');
var _ = require('underscore');
var UserModel = require ('./userModel');

module.exports = Backbone.View.extend({
  el: '.login-container',
  template: _.template(tmpl.userFormTmpl),
  events: {
    'click .user-login-button' : 'submitUsername'
  },
  submitUsername: function (event) {
    event.preventDefault();
    console.log ("clicky?");
    this.model.set({
      userName: this.$el.find('.user-login-input').val(),
    });
    this.model.save();
    this.model = new UserModel ({});
  },
  initialize: function () {
    this.model = new UserModel({});
    this.render();

    console.log ("initialize is working!");
  },
  render: function () {
    var markup = this.template(this.model.toJSON());
    this.$el.html(markup);
    return this;
  }

});
