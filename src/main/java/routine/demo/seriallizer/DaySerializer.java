package routine.demo.seriallizer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import routine.demo.model.Day;
import routine.demo.model.Tag;

import java.io.IOException;

public class DaySerializer extends StdSerializer<Day> {
    public DaySerializer(){
        this(null);
    }

    public DaySerializer(Class<Day> t) {
        super(t);
    }

    @Override
    public void serialize(Day day, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", day.getId());
        jsonGenerator.writeStringField("title", day.getTitle());
        jsonGenerator.writeStringField("description", day.getDescription());

        if (day.getTags().size() == 0 )
            jsonGenerator.writeStringField("tags", null);
        else {
            jsonGenerator.writeFieldName("tags");
            jsonGenerator.writeStartArray();
            for (Tag tag : day.getTags()) {
                jsonGenerator.writeNumber(tag.getId());
            }
            jsonGenerator.writeEndArray();
        }
        jsonGenerator.writeEndObject();
    }
}
