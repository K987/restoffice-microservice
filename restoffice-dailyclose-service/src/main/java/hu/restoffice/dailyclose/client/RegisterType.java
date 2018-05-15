package hu.restoffice.dailyclose.client;

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
@JsonSerialize(using = RegisterType.RegisterTypeSerializer.class)
@JsonDeserialize(using = RegisterType.RegisterTypeDeserializer.class)
public enum RegisterType {
    CASH("pénztárgép"),
    CARD("bankkártya terminál");

    private String value;

    private RegisterType(final String value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }


    public static class RegisterTypeSerializer extends JsonSerializer<RegisterType> {

        @Override
        public void serialize(final RegisterType value, final JsonGenerator gen, final SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.getValue());
        }
    }

    public static class RegisterTypeDeserializer extends JsonDeserializer<RegisterType> {

        /*
         * (non-Javadoc)
         *
         * @see
         * com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.
         * jackson.core.JsonParser,
         * com.fasterxml.jackson.databind.DeserializationContext)
         */
        @Override
        public RegisterType deserialize(final JsonParser p, final DeserializationContext ctxt)
                throws IOException, JsonProcessingException {

            String value = p.getText();
            return Stream.of(RegisterType.values()).filter(v -> v.getValue().equalsIgnoreCase(value)).findFirst()
                    .orElseThrow(() -> new RuntimeException("no RegisterType with value: " + value));
        }
    }
}
