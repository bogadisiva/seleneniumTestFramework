package model;

public enum HttpStatusType {
    OK("OK"),
    CREATED("Created"),
    ACCEPTED("Accepted"),
    NOT_FOUND("Not Found"),
    INTERNAL_SERVER_ERROR("Internal Server Error");

    private final String dataName;

    HttpStatusType(String dataName) {
        this.dataName = dataName;
    }

    public String getDataName() {
        return dataName;
    }
}
