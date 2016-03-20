var Backbone = require ('backbone');
var _ = require ('underscore');
var tmpl = require('./templates');

module.exports = Backbone.View.extend ({
  tagName: 'article',
  template: _.template(tmpl.questionDisplay),
  editTemplate: _.template(tmpl.editPost),
  intialize: function () {
    this.listenTo(this.model, 'change', this.render);
  },
  render: function () {
    var markup = this.template(this.model.toJSON());

    this.$el.html(markup);
    return this;
  },
  events:  {
    'click .delete-button' : 'deletePost',
    'click .edit-button' : 'toggleEdit',
    'click .submit-edit-button' : 'editPost'
  },
  deletePost: function (event) {
    event.preventDefault();
    this.model.destroy();
  },
  toggleEdit: function (event) {
    event.preventDefault();
    this.$el.append(this.editTemplate(this.model.toJSON()));
  },
  editPost: function (event) {
    event.preventDefault();
    console.log("submit edit button working!");
    this.model.set({
      question: this.$el.find('.edit-question-input').val(),
    });
    this.model.save();
  }
});
