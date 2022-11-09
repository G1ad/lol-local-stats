import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KeyIterator {

    public static List<String> getKeys(JsonNode json) throws JsonMappingException, JsonProcessingException {

        List<String> keys = new ArrayList<>();
        Iterator<String> iterator = json.fieldNames();
        iterator.forEachRemaining(e -> keys.add(e));
        return keys;
    }

    public static List<String> getAllKeys(JsonNode jsonNode) throws JsonMappingException, JsonProcessingException {

        List<String> keys = new ArrayList<>();
        getAllKeysUsingJsonNodeFields(jsonNode, keys);
        return keys;
    }

    private static void getAllKeysUsingJsonNodeFields(JsonNode jsonNode, List<String> keys) {
        if (jsonNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
            fields.forEachRemaining(field -> {
                keys.add(field.getKey());
                getAllKeysUsingJsonNodeFields((JsonNode) field.getValue(), keys);
            });
        } else if (jsonNode.isArray()) {
            ArrayNode arrayField = (ArrayNode) jsonNode;
            arrayField.forEach(node -> {
                getAllKeysUsingJsonNodeFields(node, keys);
            });
        }
    }


    public KeyIterator() throws IOException {
    }
}
