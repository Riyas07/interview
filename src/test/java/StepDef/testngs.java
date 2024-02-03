package StepDef;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;

import static io.restassured.RestAssured.given;

public class testngs
{
    static  int  dig = 1;
    @Test(invocationCount = 5)
    public void uploadImg() {

        // RestAssured.proxy= ProxySpecification.host("").withPort(0);
        File f = new File("Feature/Pet.feature");
        String r = given()
                .contentType(ContentType.JSON)
                .pathParam("id", 3)
                .formParam("petId", 0)
                .formParam("additionalMetadata", "String")
                .multiPart("file", f)
                .when()
                .post("https://petstore.swagger.io/v2/pet/{id}/uploadImage").asPrettyString();
        System.out.println(r + " " + dig);
        dig++;
        try (FileOutputStream fg = new FileOutputStream("")) {

        } catch (Exception o) {
            System.out.println("Exception :" + o.getMessage());
        } finally {

        }
    }}
