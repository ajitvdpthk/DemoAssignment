$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/featureFiles/userInfo.feature");
formatter.feature({
  "name": "Purpose of this feature is to verify the user details,create users and update exiting uset details",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Veriyf if new user is able to delete the user details from existing list of users",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Tag"
    }
  ]
});
formatter.step({
  "name": "I send delete request to users resource with \u003cuserIdex\u003e",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "firstName",
        "lastName",
        "userIdex"
      ]
    },
    {
      "cells": [
        "newFirstName",
        "newLastName",
        "1"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I have uri of the resource",
  "keyword": "Given "
});
formatter.match({
  "location": "userInfoStepDef.iHaveUriOfTheResource()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Veriyf if new user is able to delete the user details from existing list of users",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Tag"
    }
  ]
});
formatter.step({
  "name": "I send delete request to users resource with 1",
  "keyword": "When "
});
formatter.match({
  "location": "userInfoStepDef.iSendDeleteRequestToUsersResourceWithUserIdex(String)"
});
formatter.result({
  "status": "passed"
});
});