package ru.levelp.at.taf.trello.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({
    "classpath:env/${env}/ui.properties",
    "system:properties"
})
public interface UiConfiguration extends Config {

    @Key("site.url")
    String url();

    @Key("site.username")
    String username();

    @Key("site.password")
    String password();
}
