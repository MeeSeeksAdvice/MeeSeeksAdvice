module.exports = {
  userFormTmpl : [
    '<form class="user-login-form">',
        '<input type="text" name="username" class="user-login-input form-control" placeholder = "Enter Username"value="">',
        '<button type="button" class ="user-login-button btn btn-default" name="button">SUBMIT</button>',
    '</form>'
  ].join(""),

  questionForm : [
    '<form class="question-form">',
        "<h3>What's your question for Meseeks?</h3>",
        '<input type="text" name="" class ="question-input" value="" placeholder = "Enter Question">',
        '<button type="button" name="" class = "question-button">Submit</button>',
    '</form>'
  ].join(""),

  questionDisplay: [
    '<div id = <%= userName %>>',
        '<h4 class="username-display"><%= userName %></h4>',
        '<h3 class="question-display"><%= question %></h3>',
    '</div>'
  ].join(""),

  answerDisplay: [
    // '<div data-id = <%= userName %>>',
        '<h4 class="username-display"><%= answer %></h4>',
    // '</div>'
  ].join("")
};
