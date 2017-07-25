package com.d2d.service.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class JSONUtil {
    private static JSONUtil jsonUtil;

    private JSONUtil() {
    }

    public static JSONUtil getInstanse() {
        if (jsonUtil == null) {
            jsonUtil = new JSONUtil();
        }
        return jsonUtil;
    }

    public void write(String fileNameWithPath, Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String string = fileNameWithPath;
            synchronized (string) {
            	mapper.setSerializationInclusion(Inclusion.NON_NULL);
            	mapper.writeValue(new File(fileNameWithPath), obj);
            }
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getStringByObject(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
        	return mapper.writeValueAsString(obj);
        }catch (JsonGenerationException e) {
            e.printStackTrace();
        }catch (JsonMappingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String read(String fileNameWithPath) {
        String jsonString;
        jsonString = null;
        try {
            JsonFactory jfactory = new JsonFactory();
            String string = fileNameWithPath;
            synchronized (string) {
                JsonParser jsonParser = jfactory.createJsonParser(new File(fileNameWithPath));
                ObjectMapper objectMapper = new ObjectMapper();
                jsonString = objectMapper.readTree(jsonParser).toString();
                jsonParser.close();
            }
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Object read(String fileNameWithPath, Class clazz) throws FileNotFoundException, IOException {
       try {
            synchronized (fileNameWithPath) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(new File(fileNameWithPath), clazz);
            }
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
       	catch (FileNotFoundException e) {
           e.printStackTrace();
       	}
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(JSONUtil.getInstanse().read("/home/guruprit/Desktop/DATAHOME/DEALS/2/0/summary.json"));
    }
}

