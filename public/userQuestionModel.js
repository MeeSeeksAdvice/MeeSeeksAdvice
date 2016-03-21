var Backbone = require('backbone');
module.exports = Backbone.Model.extend ({
  urlRoot: '/user/question',
  initialize: function () {
    console.log("users question model created!");
  }
});
