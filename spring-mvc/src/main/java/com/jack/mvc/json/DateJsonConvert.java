package com.jack.mvc.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.Date;

/**
 * @author yangyueming
 */
@JsonComponent
public class DateJsonConvert {
    public static class Serializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeObject(com.iscas.det.utils.DateUtils.format(date,"yyyy-MM"));
//            jsonGenerator.writeStringField(
//                    "favoriteColor",
//                    getColorAsWebColor(user.getFavoriteColor()));
//            jsonGenerator.writeEndObject();
        }
    }

    /**
     * 将字符串转为Long
     *
     * @author xyctruth
     * @create 2018/8/28 15:36
     */
    public class LongJsonDeserializer extends JsonDeserializer<Long> {
        @Override
        public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String value = jsonParser.getText();
            try {
                return value == null ? null : Long.parseLong(value);
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }

//    public static class DeSerializer extends JsonDeserializer<Model1> {
//        @Override
//        public Model1 deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
//            TextNode textNode
//                    = (TextNode) treeNode.get("date");
//            try {
//                System.out.println(textNode.asText());
//                Model1 model1 = new Model1();
//                model1.setDate(com.iscas.det.utils.DateUtils.parse(textNode.asText(), "yyyy-MM-dd HH:mm:ss"));
//                return model1;
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }

}
