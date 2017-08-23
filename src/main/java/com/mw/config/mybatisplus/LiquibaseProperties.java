package com.mw.config.mybatisplus;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;
import java.util.Map;

@ConfigurationProperties(prefix = "liquibase", ignoreUnknownFields = false)
public class LiquibaseProperties {
    @NotNull
    private String changeLog ;
    private boolean checkChangeLogLocation = true;
    private String contexts;
    private String defaultSchema;
    private boolean dropFirst;
    private boolean enabled = true;
    private String user;
    private String password;
    private String url;
    private String labels;
    private Map<String, String> parameters;

    public LiquibaseProperties() {
    }

    public String getChangeLog() {
        return this.changeLog;
    }

    public void setChangeLog(String changeLog) {
        this.changeLog = changeLog;
    }

    public boolean isCheckChangeLogLocation() {
        return this.checkChangeLogLocation;
    }

    public void setCheckChangeLogLocation(boolean checkChangeLogLocation) {
        this.checkChangeLogLocation = checkChangeLogLocation;
    }

    public String getContexts() {
        return this.contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public String getDefaultSchema() {
        return this.defaultSchema;
    }

    public void setDefaultSchema(String defaultSchema) {
        this.defaultSchema = defaultSchema;
    }

    public boolean isDropFirst() {
        return this.dropFirst;
    }

    public void setDropFirst(boolean dropFirst) {
        this.dropFirst = dropFirst;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabels() {
        return this.labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
