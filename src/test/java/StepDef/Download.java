package StepDef;

import io.restassured.RestAssured;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Download {
    public static void main(String[] args) throws IOException {
       InputStream inputStream= RestAssured.given()
                .when().get("https://spdn.poumod.com/HappyMod-3-0-7.apk")
                .then()
               .assertThat().statusCode(200)
                .extract().response().asInputStream()
                ;
       byte[] b=new byte[inputStream.available()];
       inputStream.read(b);
        FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Muham\\Downloads\\Telegram Desktop\\HappyMod-3-0-7.apk");
        fileOutputStream.write(b);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
