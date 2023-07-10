package ru.levelp.at.taf.trello.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({
    "classpath:env/${env}/api.properties",
    "system:properties"
})
public interface ApiConfiguration extends Config {

    @Key("api.site.url")
    String url();

    @Key("api.site.api.key")
    String apiKey();

    @Key("api.site.api.token")
    String apiToken();
}
