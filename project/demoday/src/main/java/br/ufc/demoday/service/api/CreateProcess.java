package br.ufc.demoday.service.api;
import br.ufc.demoday.model.UserApi;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

// Classe usada para acessar a API da PDTech
public class CreateProcess {
    private final Dotenv dotenv = Dotenv.load();
    private final HashMap<String, String> envs = new HashMap<>();
    private final String accessToken;
    private final Gson gson = new Gson();
    private final ArrayList<UserApi> users;

    private void loadEnvs(){
        envs.put("baseUrl", dotenv.get("BASE_URL"));
    }
    public CreateProcess(ArrayList<UserApi> users) throws IOException {
        Login client = new Login();
        client.doLogin();
        accessToken = client.getAccessToken();
        loadEnvs();
        this.users = users;
    }

    public void createProcess() {
        ProcessBody body = new ProcessBody();
        body.addMembers(users);
        String json = gson.toJson(body);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(envs.get("baseUrl") + "/processes");
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
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

    public String getAccessToken(){
        return accessToken;
    }
    public String getProcessId(){
        return envs.get("processId").substring(1, envs.get("processId").length() - 1);
    }
}



