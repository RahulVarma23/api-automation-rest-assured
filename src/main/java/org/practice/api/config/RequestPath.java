package org.practice.api.config;

public enum RequestPath {

    EMPLOYEES("/employees"),
    EMPLOYEE_BY_ID("employee/{id}"),
    CREATE("/create"),
    UPDATE_BY_ID("/update/{id}"),
    DELETE_BY_ID("/delete/{id}"),
    TEST("/TEST");

    private final String path;

    RequestPath(String path) {
        this.path = path;
    }

    public String getPath(){
        return path;
    }

}
