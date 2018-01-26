package com.example.jpaDemo.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * JSON 工具类
 *
 * @author ck
 * 2018/1/26 11:54
 */
public class JSONUtil {

    private static final Logger log = LoggerFactory.getLogger(JSONUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, true);
        mapper.configure(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED, false);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    }

    public JSONUtil() {
    }

    public static String toPrettyJSONString(Object object) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (RuntimeException var2) {
            throw var2;
        } catch (Exception var3) {
            log.error("Unable to serialize to json: " + object, var3);
            return new String();
        }
    }

    public static String toJSONString(Object object) {
        StringWriter writer = new StringWriter();

        try {
            mapper.writeValue(writer, object);
        } catch (RuntimeException var3) {
            throw var3;
        } catch (Exception var4) {
            log.error("Unable to serialize to json: " + object, var4);
            return null;
        }

        return writer.toString();
    }

    public static <T> T parse(String json, Class<T> type) {
        try {
            T object = mapper.readValue(json, type);
            return object;
        } catch (RuntimeException var4) {
            log.error("Runtime exception during deserializing ");
            throw var4;
        } catch (Exception var5) {
            log.error("Exception during deserializing[" + json + "]", var5);
            return null;
        }
    }

    public static List<Map<String, Object>> toArray(JsonParser jp) {
        try {
            return (List) mapper.readValue(jp, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (Exception var2) {
            log.error("Runtime exception ", var2);
            return null;
        }
    }

    public static <T> List<T> toArray(JsonParser jp, Class<T> type) {
        try {
            return (List) mapper.readValue(jp, new TypeReference<List<T>>() {
            });
        } catch (Exception var3) {
            log.error("Runtime exception ", var3);
            return null;
        }
    }

    public static List<Map<String, Object>> toArray(String jsonArrayString) {
        try {
            return (List) mapper.readValue(jsonArrayString, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (Exception var2) {
            log.error("Runtime exception", var2);
            return null;
        }
    }

}
