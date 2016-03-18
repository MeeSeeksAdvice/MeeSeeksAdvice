var Backbone = require ('backbone');
module.exports = Backbone.Collection.extend ({
  url: '/question',
  initialize: function () {
    console.log ("Question collection created.");
  }
});
