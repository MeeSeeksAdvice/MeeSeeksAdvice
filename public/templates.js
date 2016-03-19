module.exports = {
  userFormTmpl : [
    '<form class="user-login-form">',
        '<input type="text" name="username" class="user-login-input form-control" placeholder = "Enter Username"value="">',
        '<button type="submit" class ="user-login-button btn btn-default" name="button">SUBMIT</button>',
    '</form>'
  ].join(""),

  questionForm : [
    '<form class="question-form">',
        "<h3>What's your question for Meseeks?</h3>",
        '<input type="text" name="" class ="question-input" value="" placeholder = "Enter Question">',
        '<button type="submit" name="" class="question-button">Submit</button>',
    '</form>'
  ].join(""),

  questionDisplay: [
    '<div class = "questionDisplay" id = <%= userName %>>',
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
