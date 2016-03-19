var Backbone = require('backbone');

module.exports = Backbone.Model.extend ({
  urlRoot: '/answer',
  initialize: function () {
    console.log("Answer model created!");
  }
});
