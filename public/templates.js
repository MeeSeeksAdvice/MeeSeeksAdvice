module.exports = {
  userFormTmpl : [
    '<form class="user-login-form">',
        '<input type="text" name="username" class="user-login-input form-control" placeholder = "Enter Username"value="">',
        '<button type="submit" class ="user-login-button btn btn-default" name="button">SUBMIT</button>',
    '</form>'
  ].join(""),

  questionForm : [
    '<form class="question-form">',
        "<h3>What's your question for Mr. Meeseeks?</h3>",
        '<input type="text" name="" class ="question-input" value="" placeholder = "Ask Mr. Meeseeks a question">',
        '<button type="submit" name="" class="question-button">Submit</button>',
        '<button name="" class="logout-button">Logout</button>',

    '</form>'
  ].join(""),

  questionDisplay: [
    '<section class = "questionDisplay" id = <%= user.userName %> =  >',
        '<h4 class="username-display"><%= user.userName %>:</h4>',
        '<h3 class="question-display"><%= question %></h3>',

        '<h3 class="answer-display"> <span class = meeseeks-answer> Meeseeks: </span><%= answer.answer %></h3>',
        '<button class = "delete-button">DELETE</button>',
        '<button class = "edit-button">EDIT</button>',
    '</section>'
  ].join(""),

  editPost: [
    "<form class = 'edit-form'>",
      "<input type='text' class = 'edit-question-input' placeholder = <%= question %>>",
      "<button class = 'submit-edit-button'>SUBMIT EDIT</button>",
    "</form>"
  ].join("")

};
