var Backbone = require ('backbone');
module.exports = Backbone.Collection.extend ({
  url: '/answer',
  initialize: function () {
    console.log ("Answer collection created.");
  }
});
