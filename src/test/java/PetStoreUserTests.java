import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PetStoreUserTests {

    @Test
    public void getUserInfo(){

        userCreate();

        RestAssured

                .get("https://petstore.swagger.io/v2/user/bcctester2");
    }

    @Test
    public void userCreate(){

        Map<String, Object> bodyPayload=new HashMap<>();
        bodyPayload.put("id",538970);
        bodyPayload.put("username","bcctest1");
        bodyPayload.put("firstName","brkn");
        bodyPayload.put("lastName","bcc");
        bodyPayload.put("email","birkanproject@gmail.com");
        bodyPayload.put("password","bcctest97");
        bodyPayload.put("phone","05444444444");
        bodyPayload.put("userStatus",1);

        Map<String,String> header=new HashMap<>();
        header.put("accept","application/json");
        header.put("Content-Type","application/json");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers(header)
                .body(bodyPayload)
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200);

    }

    @Test
    public void updateUser(){
        Map<String, Object> bodyPayload=new HashMap<>();
        bodyPayload.put("id",538970);
        bodyPayload.put("username","bcctest123456");
        bodyPayload.put("firstName","brkn");
        bodyPayload.put("lastName","bcc");
        bodyPayload.put("email","birkanproject@gmail.com");
        bodyPayload.put("password","bcctest97");
        bodyPayload.put("phone","05444444444");
        bodyPayload.put("userStatus",1);

        RestAssured
                .given()
                .contentType("application/json")
                .body(bodyPayload)
                .when()
                .put("https://petstore.swagger.io/v2/user/bcctester1")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteUser(){

        userCreate();

        RestAssured
                .delete("https://petstore.swagger.io/v2/user/bcctest1")
                .then()
                .statusCode(200);
    }

}
