var Backbone = require('backbone');
module.exports = Backbone.Model.extend ({
  urlRoot: '/question',
  initialize: function () {
    console.log("questionModel created!");
  }
});
