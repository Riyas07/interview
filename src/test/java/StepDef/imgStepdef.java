package StepDef;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import java.io.File;

import static io.restassured.RestAssured.given;

public class imgStepdef {
    @Given("upload img")
    public void uploadImg() {

        File f=new File("Feature/Pet.feature");
      String r=  given()
                .contentType(ContentType.MULTIPART)
                .pathParam("id",3)
                .formParam("petId",0)
                .formParam("additionalMetadata","String")
                .multiPart("file",f)
                .when()
                .post("https://petstore.swagger.io/v2/pet/{id}/uploadImage").asPrettyString();
        System.out.println(r);
    }
}
