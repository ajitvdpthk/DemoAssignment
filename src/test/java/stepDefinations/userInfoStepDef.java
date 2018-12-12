package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framwork.utils.dto.User;
import framwork.utils.utils.HttpUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class userInfoStepDef {
    RequestSpecification specification=null;
    Response response=null;
    @Given("^I have uri of the resource$")
    public void iHaveUriOfTheResource()  {
        specification =HttpUtils.getRequestSpecification();
    }

    @When("^I send a get request to resource$")
    public void iSendAGetRequestToResource() {
        response=HttpUtils.getRequest(specification,"");
    }

    @Then("^I should get a response form the server and (.*) name should be present in the response received$")
    public void iShouldGetAResponseFormTheServerAndGeorgeNameShouldBePresentInTheResponseReceived(String nameToVerify) {
        String responseOfGetRequest=response.asString();
        assertThat(responseOfGetRequest.contains(nameToVerify),is(true));
    }

    @When("^I send create request to users resource with (.*) (.*)$")
    public void iSendCreateRequestToUsersResourceWithNameJob(String name,String job){
        User user=User.builder().name(name).job(job).build();
        response=HttpUtils.postRequest(specification,user);
    }

    @Then("^New user should get created with (.*) (.*)$")
    public void newUserShouldGetCreated(String name,String job){
        String responseBody=response.getBody().asString();
        assertThat(responseBody.contains(name),is(true));
        assertThat(responseBody.contains(job),is(true));
    }

    @When("^I send update request to users resource with (.*) (.*) (.*)$")
    public void iSendUpdateRequestToUsersResourceWithFirstNameLastName(String firstName,String lastName,String userIdex){
        User user=User.builder().name(firstName).job(lastName).build();
        response=HttpUtils.putRequest(specification,user,userIdex);
    }

    @When("^I send delete request to users resource with (.*)$")
    public void iSendDeleteRequestToUsersResourceWithUserIdex(String userIdex){
        response=HttpUtils.deleteRequest(specification,userIdex);

    }
}
