package org.selenium.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.LoginCredentials;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static <T> T deserializeJson(String FileName, Class<T>T) throws IOException {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(FileName);
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.readValue(is, T);
    }

}
