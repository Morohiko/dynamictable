package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Converter {

    public static String toJSON(Model model) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonObject = mapper.writeValueAsString(model);
        System.out.println("json = " + jsonObject);
        return jsonObject;
    }

    public static Model toJavaObject(String jsonObject, Model model) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        model = mapper.readValue(jsonObject, model.getClass());
        return model;
    }

}
