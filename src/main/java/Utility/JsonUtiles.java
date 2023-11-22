package Utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtiles {

    public static ObjectMapper objectMapper = new ObjectMapper();
    public  static Map<String, Object> getJsonDataAsMap(String fileNamePath){

        String completeJsonFilePath = System.getProperty("user.dir")+"/src/test/resources/"+fileNamePath;
        Map<String,Object> data = null;
        try {
          data =    objectMapper.readValue(new File(completeJsonFilePath),new TypeReference<>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
