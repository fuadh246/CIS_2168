import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FileHelper{
    public static void main(String[] args) throws Exception {
        String apiKey = "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";
        String prompt = "Hello, ChatGPT!";

        URL url = new URL("https://api.openai.com/v1/engines/davinci-codex/completions");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Bearer " + apiKey);
        con.setRequestProperty("Content-Type", "application/json");

        String postJsonData = "{\"prompt\": \"" + prompt + "\", \"temperature\": 0.7}";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.write(postJsonData.getBytes(StandardCharsets.UTF_8));
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String generatedText = response.toString().split("\"text\": \"")[1].split("\"")[0];
        System.out.println(generatedText);
    }
}
