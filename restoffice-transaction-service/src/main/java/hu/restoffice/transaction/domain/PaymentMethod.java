package hu.restoffice.transaction.domain;

/**
 *
 */
public enum PaymentMethod {

    CASH("készpénz"), TRANSFER("átutalás"), DEFFERED_CASH("halasztott készpénz");

    private String value;

    private PaymentMethod(final String value)
    {
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
}

