package hu.restoffice.employee.domain;

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
@JsonSerialize(using = JobPosition.JobPositionSerializer.class)
@JsonDeserialize(using = JobPosition.JobPositionDeserializer.class)
public enum JobPosition {

    WAITER("felszolgáló"), BARTENDER("pultos"), CHEF("szakács");

    private String value;

    private JobPosition(final String value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }


    public static class JobPositionSerializer extends JsonSerializer<JobPosition> {

        @Override
        public void serialize(final JobPosition value, final JsonGenerator gen, final SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.getValue());
        }
    }

    public static class JobPositionDeserializer extends JsonDeserializer<JobPosition> {

        /*
         * (non-Javadoc)
         *
         * @see
         * com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.
         * jackson.core.JsonParser,
         * com.fasterxml.jackson.databind.DeserializationContext)
         */
        @Override
        public JobPosition deserialize(final JsonParser p, final DeserializationContext ctxt)
                throws IOException, JsonProcessingException {

            String value = p.getText();
            return Stream.of(JobPosition.values()).filter(v -> v.getValue().equalsIgnoreCase(value)).findFirst()
                    .orElseThrow(() -> new RuntimeException("no JobPosition with value: " + value));
        }
    }
}