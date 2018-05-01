package hu.restoffice.transaction.domain;

/**
 *
 */
public enum DocumentType {

    INTERNAL("belső elszámolású"), EXTERNAL("szigorú számadású");

    private String value;

    private DocumentType(final String value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

}
