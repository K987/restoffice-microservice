package hu.restoffice.transaction.domain;

import java.io.IOException;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 */
@JsonSerialize(using = PaymentMethod.PaymentMethodSerializer.class)
@JsonDeserialize(using = PaymentMethod.PaymentMethodDeserializer.class)
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


    public static class PaymentMethodSerializer extends JsonSerializer<PaymentMethod> {

        @Override
        public void serialize(final PaymentMethod value, final JsonGenerator gen, final SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.getValue());
        }
    }

    public static class PaymentMethodDeserializer extends JsonDeserializer<PaymentMethod> {

        /*
         * (non-Javadoc)
         *
         * @see
         * com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.
         * jackson.core.JsonParser,
         * com.fasterxml.jackson.databind.DeserializationContext)
         */
        @Override
        public PaymentMethod deserialize(final JsonParser p, final DeserializationContext ctxt)
                throws IOException, JsonProcessingException {

            String value = p.getText();
            return Stream.of(PaymentMethod.values()).filter(v -> v.getValue().equalsIgnoreCase(value)).findFirst()
                    .orElseThrow(() -> new RuntimeException("no PaymentMethod with value: " + value));
        }
    }
}

