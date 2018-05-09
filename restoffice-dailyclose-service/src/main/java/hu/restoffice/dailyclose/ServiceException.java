package hu.restoffice.dailyclose;

import java.util.Optional;

/**
 *
 */
public class ServiceException extends Exception {

    public static enum Type {
        ALREADY_EXISTS("The entity alredy exists"), NOT_EXISTS("The does not exists"), UNKNOWN(
                "Unknown type of exception"), CANT_GET_ID(
                        "entity may exists, but can't find id"), UNSUPPORTED("unsupported operation");

        private String description;

        private Type(final String descrition) {
            description = descrition;
        }

        public String getDescription() {
            return description;
        }
    }
    private static final long serialVersionUID = 1213086114851192880L;

    private Type type;
    private String message;
    private Object errorObject;

    public ServiceException(final Type type) {
        this.type = type;
        message = type.getDescription();
    }

    /**
     * @param type
     * @param message
     */
    public ServiceException(final Type type, final String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * @param type
     * @param errorObject
     */
    public ServiceException(final Type type, final Object errorObject) {
        this(type);
        this.errorObject = errorObject;
    }

    /**
     * @param type
     * @param message
     * @param errorObject
     */
    public ServiceException(final Type type, final String message, final Object errorObject) {
        this(type, message);
        this.errorObject = errorObject;
    }



    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @return the message
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @return the errorObject
     */
    public Optional<Object> getErrorObject() {
        return Optional.ofNullable(errorObject);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ServiceException [type=" + type + ", message=" + message + ", errorObject=" + errorObject
                + "]";
    }

}
