package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class CashwiseBankAccountTest {

    @Test
    public void getAllBankAccounts(){

        Response response = RestAssured.given().get("https://backend.cashwise.us/api/myaccount/bankaccount");
        System.out.println();


    }



}
