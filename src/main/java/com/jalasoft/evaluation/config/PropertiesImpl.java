package com.jalasoft.evaluation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesImpl implements Properties {

    private static String profileActive;

    private boolean systemProperty;

    @Value("${app.profiles.active}")
    @Override
    public void setProfileActive(String profile) {
        profileActive = profile;
    }

    @Override
    public String getProfileActive() {
        return profileActive;
    }

    @Value("${app.system.property}")
    @Override
    public void setSystemProperty(boolean property) {
        systemProperty = property;
    }

    @Override
    public boolean getSystemProperty() {
        return systemProperty;
    }
}
