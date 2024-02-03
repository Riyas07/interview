package StepDef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.Config;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.util.*;

import static io.restassured.RestAssured.*;

public class PetStepdef {
    @Given("wite payload with following details")
    public void wite_payload_with_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>>data=dataTable.asMaps(String.class,String.class);
        for(Map<String,String>m:data)
        {
            for (String key:m.keySet())
            {
                switch (key)
                {
                    case "id":if (!m.get(key).isEmpty())pojo.getPojoInstance().setId(Integer.parseInt(m.get(key)));else System.exit(-1);
                    break;
                    case "name":if (!m.get(key).isEmpty())pojo.getPojoInstance().setName(m.get(key));else System.exit(-1);
                    break;
                    case "status":if (!m.get(key).isEmpty())pojo.getPojoInstance().setStatus(m.get(key));else System.exit(-1);
                }
            }
        }
    }
    Map<String, Object>category=new LinkedHashMap<>();
    @When("add the category")
    public void add_the_category(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>>data=dataTable.asMaps(String.class,String.class);
        for (Map<String,String>m:data)
        {
            for (String key:m.keySet())
            {
                switch (key)
                {
                    case "id":if (!m.get(key).isEmpty())category.put(key,m.get(key));else System.exit(-1);
                    break;
                    case "name":if (!m.get(key).isEmpty()){category.put(key,m.get(key));}else System.exit(-1);
                    break;
                }
            }
        }
        pojo.getPojoInstance().setCategory(category);
    }
    @Then("add the photoUrls")
    public void add_the_photo_urls(io.cucumber.datatable.DataTable dataTable) {
       String photo= dataTable.asMaps(String.class,String.class).get(0).get("photoUrls");
       List ll= new ArrayList<>();
       ll.add(photo);
       pojo.getPojoInstance().setPhotoUrls(ll);
    }
    @Then("add the tags")
    public void add_the_tags(io.cucumber.datatable.DataTable dataTable) {
        Map<String,Object>tag=new LinkedHashMap<>();
        List<Map<String,Object>> l=new ArrayList();
        l.add(tag);
        List<Map<String,String>>data=dataTable.asMaps(String.class,String.class);
        for (Map<String,String>m:data)
        {
            for (String key:m.keySet())
            {
                switch (key)
                {
                    case "id":if (!m.get(key).isEmpty())tag.put(key,m.get(key));else System.exit(-1);
                        break;
                    case "name":if (!m.get(key).isEmpty()){tag.put(key,m.get(key));}else System.exit(-1);
                        break;
                }
            }
        }
        pojo.getPojoInstance().setTags(l);
    }

    @Then("generate payload")
    public void generatePayload() throws JsonProcessingException, FileNotFoundException {
        ObjectMapper objectMapper=new ObjectMapper();
       String payload= objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo.getPojoInstance());
        System.out.println(payload);
        InputStream inputStream=new FileInputStream("src/test/java/resources/pet.json");
      JsonNode node= objectMapper.readTree(payload);
      JsonSchemaFactory schemaFactory=  JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
     JsonSchema schema= schemaFactory.getSchema(inputStream);
    Set<ValidationMessage>v= schema.validate(node);
    if (!v.isEmpty())
    {
        for (ValidationMessage vv:v)
        {
            System.out.print(vv);
        }
    }
    else {
        System.out.println("Schema validation completed");
    }
    }
    public static int i=1;
    private static String[] name={"riyas","sam","jack"};
    private static String[] status={"available","notavailable","available"};
    static int n=0;
    @Then("trigger the request and validate the responses")
    public void triggerTheRequestAndValidateTheResponses() throws IOException {

            RestAssured.useRelaxedHTTPSValidation();
            int response=  given(requestSpecification)
                    //.filter(new ResponseLoggingFilter(LogDetail.BODY,new PrintStream("print/print.txt")))
                    .body(pojo.getPojoInstance()).when()
                    .post("pet")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("id",Matchers.comparesEqualTo(i),"name",Matchers.containsString(name[n]),"status",Matchers.containsString(status[n]),"id",Matchers.is(Matchers.not(Matchers.comparesEqualTo(0))),
                            "category",Matchers.hasValue(0),"photoUrls",Matchers.hasItem("String"),"tags[0]",Matchers.hasValue(0)).extract().response().header("Content-Type").compareTo("application/json");
            //System.out.println(response);
           i++;
           n++;
    }


}
