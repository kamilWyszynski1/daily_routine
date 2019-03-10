package routine.demo.seriallizer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import routine.demo.model.Day;
import routine.demo.model.Tag;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class TagSerializer extends StdSerializer<Tag> {

    public TagSerializer(){
        this(null);
    }

    public TagSerializer(Class<Tag> t) {
        super(t);
    }


    @Override
    public void serialize(Tag tag, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", tag.getId());
        jsonGenerator.writeStringField("title", tag.getTitle());
        jsonGenerator.writeStringField("description", tag.getDescription());
        jsonGenerator.writeStringField("color", tag.getColor());

        if (tag.getDays().size() == 0 )
            jsonGenerator.writeStringField("books", null);
        else {
            jsonGenerator.writeFieldName("books");
            jsonGenerator.writeStartArray();
            for (Day day : tag.getDays()) {
                jsonGenerator.writeNumber(day.getId());
            }
            jsonGenerator.writeEndArray();
        }
        jsonGenerator.writeEndObject();

    }
}
