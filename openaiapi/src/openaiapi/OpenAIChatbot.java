package openaiapi;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OpenAIChatbot {
    private static final String API_KEY = "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"; // OpenAI API 키 입력
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) throws IOException {
        String prompt = "개와 고양이의 생물학적 차이점을 알려줘!";

        String response = getChatGPTResponse(prompt);
        System.out.println("ChatGPT 응답: " + response);
    }

    public static String getChatGPTResponse(String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        // JSON 요청 본문 구성
        String json = "{"
                + "\"model\": \"gpt-4\","
                + "\"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},"
                + "{\"role\": \"user\", \"content\": \"" + prompt + "\"}],"
                + "\"max_tokens\": 100"
                + "}";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));

        // HTTP 요청 구성
        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .post(body)
                .build();

        // 응답 처리
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JsonNode jsonResponse = objectMapper.readTree(response.body().string());
            return jsonResponse.get("choices").get(0).get("message").get("content").asText();
        }
    }
}
