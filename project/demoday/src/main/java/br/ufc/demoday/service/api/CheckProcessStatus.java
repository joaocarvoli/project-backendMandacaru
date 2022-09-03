package br.ufc.demoday.service.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class CheckProcessStatus {

    private final Dotenv dotenv = Dotenv.load();
    private final HashMap<String, String> envs = new HashMap<>();
    private void loadEnvs(){
        envs.put("baseUrl", dotenv.get("BASE_URL"));
    }
    private final String processId;
    private final String accessToken;

    public CheckProcessStatus(CreateProcess process){
        loadEnvs();
        processId = process.getProcessId();
        accessToken = process.getAccessToken();
    }

    public boolean doCheck(){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(envs.get("baseUrl") + "/processes/" + processId);
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        httpGet.setHeader("x-tenant", envs.get("tenant"));

        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            if(responseBody != null){
                if(statusCode == 200){
                    JsonObject jsonObject = (JsonObject) JsonParser.parseString(responseBody);
                    if(String.valueOf(jsonObject.get("status")).equals("DONE")){ return true;}
                }
            }
            EntityUtils.consume(entity);
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
