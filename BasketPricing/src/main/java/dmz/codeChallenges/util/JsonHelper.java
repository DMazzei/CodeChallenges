package dmz.codeChallenges.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dmz.codeChallenges.model.BasketItem;
import dmz.codeChallenges.model.SpecialOffer;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonHelper {

    public static List<BasketItem> LoadBasketItems(URI fileURI) throws IOException {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        return objectMapper.readValue(ReadFile(fileURI), new TypeReference<List<BasketItem>>() { });
    }
    
    public static List<SpecialOffer> LoadSpecialOffer(URI fileURI) throws IOException {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        return objectMapper.readValue(ReadFile(fileURI), new TypeReference<List<SpecialOffer>>() { });
    }
    
    private static byte[] ReadFile(URI fileURI) throws IOException {
        //read json file data to String
        return Files.readAllBytes(Paths.get(fileURI));
    }
}
