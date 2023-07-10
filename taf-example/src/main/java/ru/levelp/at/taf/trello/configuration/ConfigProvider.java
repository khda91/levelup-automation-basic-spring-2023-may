package ru.levelp.at.taf.trello.configuration;

import org.aeonbits.owner.ConfigCache;

public final class ConfigProvider {

    private ConfigProvider() {
    }

    public static UiConfiguration uiConfiguration() {
        return ConfigCache.getOrCreate(UiConfiguration.class);
    }

    public static ApiConfiguration apiConfiguration() {
        return ConfigCache.getOrCreate(ApiConfiguration.class);
    }
}
