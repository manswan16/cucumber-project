package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponses;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.APIRunner;
import utilities.CashwiseAuthorizationToken;
import utilities.Config;

import java.util.HashMap;
import java.util.Map;

public class CashwiseSellerTest {

    @Test
    public void getSingleSeller() {
        int id = 1730;
        String token = CashwiseAuthorizationToken.getToken();
        String url = Config.getProperty("cashwiseURI") + "/api/myaccount/sellers/" + id;

        Response response = RestAssured.given().auth().oauth2(token).get(url);
        System.out.println("status code: " + response.statusCode());
        response.prettyPrint();
    }

    @Test
    public void getAllSellers() {
        String token = CashwiseAuthorizationToken.getToken();
        String url = Config.getProperty("cashwiseURI") + "/api/myaccount/sellers";
        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", true);
        params.put("page", 1);
        params.put("size", 4);

        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);

        System.out.println("status code: " + response.statusCode());
        response.prettyPrint();
    }

    @Test
    public void createSeller() throws JsonProcessingException {
        String token = CashwiseAuthorizationToken.getToken();
        String url = Config.getProperty("cashwiseURI") + "/api/myaccount/sellers/";
        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name("MCDonalds");
        requestBody.setSeller_name("Joshua");
        requestBody.setEmail("Joshua@gmail.com");
        requestBody.setPhone_number("1234567896");
        requestBody.setAddress("22 S MCdonalds street");

        Response response = RestAssured.given().auth().oauth2(token)
                .contentType(ContentType.JSON).body(requestBody).post(url);

        System.out.println("status code: " + response.statusCode());
        response.prettyPrint();

        ObjectMapper mapper = new ObjectMapper();
        CustomResponses customResponses = mapper.readValue(response.asString(), CustomResponses.class);
        System.out.println("seller id : " + customResponses.getSeller_id());
    }

    @Test
    public void createManySeller() {
        String token = CashwiseAuthorizationToken.getToken();
        String url = Config.getProperty("cashwiseURI") + "/api/myaccount/sellers/";
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            RequestBody requestBody = new RequestBody();
            requestBody.setCompany_name(faker.company().name());
            requestBody.setSeller_name(faker.name().fullName());
            requestBody.setEmail(faker.internet().emailAddress());
            requestBody.setPhone_number(faker.phoneNumber().phoneNumber());
            requestBody.setAddress(faker.address().fullAddress());

            Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
                    .body(requestBody).post(url);

            System.out.println("status code :" + response.statusCode());

        }
    }

    @Test
    public void getEmailOfAllSellers() throws JsonProcessingException {
        String token = CashwiseAuthorizationToken.getToken();
        String url = Config.getProperty("cashwiseURI") + " /api/myaccount/sellers";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("isArchived", false);
        parameters.put("page", 2);
        parameters.put("size", 10);
        Response response = RestAssured.given().auth().oauth2(token).params(parameters).get(url);
        System.out.println("status code: " + response.statusCode());

        ObjectMapper mapper = new ObjectMapper();

        CustomResponses customResponse = mapper.readValue(response.asString(), CustomResponses.class);

        int size = customResponse.getResponses().size();

        for (int i = 0; i < size; i++) {
            System.out.println("user's email :" + customResponse.getResponses().get(i).getEmail());
        }

    }

    @Test
    public void getSeller() {
        String path = "/api/myaccount/sellers/1853";
        APIRunner.runGet(path);
        System.out.println("seller's name :" + APIRunner.getCustomResponses().getSeller_name());
        System.out.println("seller's email :" + APIRunner.getCustomResponses().getEmail());
    }

    @Test
    public void getSellersList(){
        String path = "/api/myaccount/sellers/";
        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);


        APIRunner.runGet(path, params);
    }


}
