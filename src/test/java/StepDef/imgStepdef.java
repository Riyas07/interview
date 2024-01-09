package StepDef;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileOutputStream;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class imgStepdef {
    @Given("upload img")
    public void uploadImg() {
       // RestAssured.proxy= ProxySpecification.host("").withPort(0);
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
        try(FileOutputStream fg=new FileOutputStream(""))
        {

        }
        catch (Exception o)
        {
            System.out.println("Exception :"+o.getMessage());
        }
        finally {
            
        }
    }
}
