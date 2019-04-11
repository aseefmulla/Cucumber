$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Feature/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Facebook login",
  "description": "",
  "id": "facebook-login",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Login with invalid credential",
  "description": "",
  "id": "facebook-login;login-with-invalid-credential",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user open the browser and launch facebook application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters \u003cusername\u003e and \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "user clicks on submit button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "application displays user and pass is incorrect",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "facebook-login;login-with-invalid-credential;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 11,
      "id": "facebook-login;login-with-invalid-credential;;1"
    },
    {
      "cells": [
        "abc3445",
        "wer123"
      ],
      "line": 12,
      "id": "facebook-login;login-with-invalid-credential;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 576082,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Login with invalid credential",
  "description": "",
  "id": "facebook-login;login-with-invalid-credential;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user open the browser and launch facebook application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters abc3445 and wer123",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "user clicks on submit button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "application displays user and pass is incorrect",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.user_open_the_browser_and_launch_facebook_application()"
});
formatter.result({
  "duration": 95912886134,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3445",
      "offset": 15
    },
    {
      "val": "123",
      "offset": 27
    }
  ],
  "location": "LoginStep.user_enters_abc_and_wer(String,String)"
});
formatter.result({
  "duration": 3825129250,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.user_clicks_on_submit_button()"
});
formatter.result({
  "duration": 29910941911,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.application_displays_user_and_pass_is_incorrect()"
});
formatter.result({
  "duration": 3671020233,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.close_the_browser()"
});
formatter.result({
  "duration": 9557954536,
  "status": "passed"
});
formatter.write("Finished scenario");
formatter.after({
  "duration": 446230,
  "status": "passed"
});
});