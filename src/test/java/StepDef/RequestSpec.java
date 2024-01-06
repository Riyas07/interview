package StepDef;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.Config;
import io.restassured.config.EncoderConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class RequestSpec {
    RequestSpec()
    {
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri("https://petstore.swagger.io");
        builder.setBasePath("/v2");
        builder.setContentType(ContentType.JSON);
        builder.log(LogDetail.ALL);
       //builder.setConfig(RestAssuredConfig.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)));
        // builder.setConfig(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader()))
       // builder.setConfig(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
        RestAssured.requestSpecification=builder.build();
    }
}
