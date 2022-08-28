package br.ufc.demoday.service.api;
import br.ufc.demoday.service.api.body.ProcessBody;
import com.google.gson.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;

// Classe usada para acessar a API da PDTech
public class CreateProcess {
    private final Dotenv dotenv = Dotenv.load();
    private final HashMap<String, String> envs = new HashMap<>();
    private final String accessToken;
    private final Gson gson = new Gson();

    private void loadEnvs(){
        envs.put("baseUrl", dotenv.get("BASE_URL"));
    }
    public CreateProcess() throws IOException {
        Login client = new Login();
        client.doLogin();
        accessToken = client.getAccessToken();
        loadEnvs();
    }

    public void createProcess() {
        ProcessBody body = new ProcessBody();
        body.addMember("João Victor", "joaocarvoli@hotmail.com", "056.681.043-38");
        body.addMember("JV", "jvcarvoli@gmail.com", "056.681.043-38");
        String json = gson.toJson(body);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(envs.get("baseUrl") + "/processes");
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        System.out.println("THE TOKEN ON LOGIN PART IS: " + accessToken);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        httpPost.setHeader("Content-Type","application/json");
        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            if(responseBody != null){
                if(statusCode == 200){
                    JsonObject jsonObject = (JsonObject) JsonParser.parseString(responseBody);
                    envs.put("processId", String.valueOf(jsonObject.get("id")));
                }
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAcessToken(){
        return accessToken;
    }
    public String getProcessId(){
        return envs.get("processId");
    }
}



