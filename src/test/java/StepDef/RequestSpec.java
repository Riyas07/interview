package StepDef;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.Config;
import io.restassured.config.EncoderConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;


public class RequestSpec {

    @BeforeStep
   public void RequestSpec() throws IOException {
        System.out.println("before class worked");
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri(ProperteyGetter.getInstance().getUrl());
        builder.setBasePath("/v2");
        builder.setContentType(ContentType.JSON);
        builder.log(LogDetail.ALL);
       //builder.setConfig(RestAssuredConfig.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)));
        // builder.setConfig(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader()))
       // builder.setConfig(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
        RestAssured.requestSpecification=builder.build();
    }
}
