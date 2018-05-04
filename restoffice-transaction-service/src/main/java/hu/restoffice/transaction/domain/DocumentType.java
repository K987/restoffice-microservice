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
@JsonSerialize(using = DocumentType.DocumentTypeSerializer.class)
@JsonDeserialize(using = DocumentType.DocumentTypeDeserializer.class)
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

    public static class DocumentTypeSerializer extends JsonSerializer<DocumentType> {

        @Override
        public void serialize(final DocumentType value, final JsonGenerator gen, final SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.getValue());
        }
    }

    public static class DocumentTypeDeserializer extends JsonDeserializer<DocumentType> {

        /*
         * (non-Javadoc)
         *
         * @see
         * com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.
         * jackson.core.JsonParser,
         * com.fasterxml.jackson.databind.DeserializationContext)
         */
        @Override
        public DocumentType deserialize(final JsonParser p, final DeserializationContext ctxt)
                throws IOException, JsonProcessingException {

            String value = p.getText();
            return Stream.of(DocumentType.values()).filter(v -> v.getValue().equalsIgnoreCase(value)).findFirst()
                    .orElseThrow(() -> new RuntimeException("no DocumentType with value: " + value));
        }
    }
}
