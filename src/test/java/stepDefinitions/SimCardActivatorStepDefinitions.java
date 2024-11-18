package stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import au.com.telstra.simcardactivator.ActivationResponse;
import au.com.telstra.simcardactivator.SimCard;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class SimCardActivatorStepDefinitions {
  
    @Autowired
    private TestRestTemplate restTemplate;

    @Given("the sim with the following details: {string} and {string}")
    public void a_sim_card_with_the_following_details_and(String iccid, String customerEmail) {
        // Testing that Sim Card is activated successfully
        String url = "http://localhost:8080/sim_activation";
        TestJson testSimCard = new TestJson(iccid, customerEmail); 
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestJson> request = new HttpEntity<>(testSimCard, headers);

        restTemplate.postForEntity(url, request, ActivationResponse.class);

    }

    @Then("the response should indicate active")
    public void theResponseShouldQueryActiveTrue() {

        String findUrl = "http://localhost:8080/findSim/4";
        ResponseEntity<SimCard> simCardResponse = restTemplate.getForEntity(findUrl, SimCard.class);
        SimCard simCard = simCardResponse.getBody();
        assertNotNull(simCard);
        assertTrue(simCard.getActive()); // Assuming SimCard has isActive() method

    }
    
    @Then("the response should indicate inactive")
    public void SimShouldNotBeActive() {

        String findUrl = "http://localhost:8080/findSim/5";
        ResponseEntity<SimCard> simCardResponse = restTemplate.getForEntity(findUrl, SimCard.class);
        SimCard simCard = simCardResponse.getBody();
        assertNotNull(simCard);
        assertFalse(simCard.getActive()); // Assuming SimCard has isActive() method
    }

    

}