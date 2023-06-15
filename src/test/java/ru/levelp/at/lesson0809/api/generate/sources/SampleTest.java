package ru.levelp.at.lesson0809.api.generate.sources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0809.person.profile.ApiClient;
import ru.levelp.at.lesson0809.person.profile.ApiClient.Config;
import ru.levelp.at.lesson0809.person.profile.ResponseSpecBuilders;

public class SampleTest {

    private static final String BASE_URL = "http://localhost:8082";
    private static final Integer PORT = 8082;

    @Test
    public void sampleTest() {
        ApiClient api = ApiClient.api(new Config()
            .reqSpecSupplier(() -> new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setPort(PORT)
                .setContentType(ContentType.JSON)));

        // До Java 8
        //        ApiClient api = ApiClient.api(new Config()
        //            .reqSpecSupplier(new Supplier<RequestSpecBuilder>() {
        //                @Override
        //                public RequestSpecBuilder get() {
        //                    return new RequestSpecBuilder()
        //                        .setBaseUri(BASE_URL)
        //                        .setPort(PORT)
        //                        .setContentType(ContentType.JSON);
        //                }
        //            }));

        api.messengers().createMessenger()
           .messengerIdPath("HHYGTGD")
           .execute(ResponseSpecBuilders.validatedWith(ResponseSpecBuilders.shouldBeCode(204)));
    }
}
