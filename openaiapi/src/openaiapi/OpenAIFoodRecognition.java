package openaiapi;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OpenAIFoodRecognition {
    private static final String API_KEY = "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"; // 🔑 OpenAI API 키 입력
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) throws IOException {
       
        // 여러 개의 이미지 URL
        List<String> imageUrls = List.of(
            "https://cdn.aflnews.co.kr/news/photo/201612/125752_8499_3111.jpg",
            "https://kormedi.com/wp-content/uploads/2021/10/gettyimages-1347690485-580x374.jpg"
        );       

        // OpenAI Vision API로 음식 재료 인식
        String ingredients = getFoodIngredientsFromImage(imageUrls);
        System.out.println("🔍 감지된 음식 재료: " + ingredients);

        // 감지된 재료 기반 레시피 추천
        String recipe = getRecipeFromIngredients(ingredients);
        System.out.println("🍽 추천 레시피: \n" + recipe);
    }

    // OpenAI Vision API를 사용하여 음식 재료 분석
    private static String getFoodIngredientsFromImage(List<String> imageUrls) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        
        StringBuilder imageJson = new StringBuilder();
        for (String imageUrl : imageUrls) {
            imageJson.append("{\"type\": \"image_url\", \"image_url\": {\"url\": \"").append(imageUrl).append("\"}},");
        }

        if (imageJson.length() > 0) {
            imageJson.setLength(imageJson.length() - 1);
        }        

        String jsonRequest = "{"
                + "\"model\": \"gpt-4o\","
                + "\"messages\": [{\"role\": \"user\", \"content\": ["
                + "{\"type\": \"text\", \"text\": \"이 이미지에 어떤 음식 재료들이 있는지 분석해줘.\"},"
                + imageJson
                + "]}],"
                + "\"max_tokens\": 500"
                + "}";

        RequestBody body = RequestBody.create(jsonRequest, MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("API 요청 실패: " + response);

            JsonNode jsonResponse = objectMapper.readTree(response.body().string());
            return jsonResponse.get("choices").get(0).get("message").get("content").asText();
        }
    }

    // 🍽 감지된 음식 재료 기반 레시피 추천
    private static String getRecipeFromIngredients(String ingredients) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonRequest = "{"
                + "\"model\": \"gpt-4o\","
                + "\"messages\": [{\"role\": \"user\", \"content\": \"다음 재료를 사용한 요리 레시피를 추천해줘: " + ingredients + "\"}],"
                + "\"max_tokens\": 300"
                + "}";
        
        RequestBody body = RequestBody.create(jsonRequest, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("API 요청 실패: " + response);

            JsonNode jsonResponse = objectMapper.readTree(response.body().string());
            return jsonResponse.get("choices").get(0).get("message").get("content").asText();
        }
    }
}
