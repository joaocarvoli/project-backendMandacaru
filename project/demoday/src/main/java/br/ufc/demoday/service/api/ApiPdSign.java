package br.ufc.demoday.service.api;
import antlr.ANTLRStringBuffer;
import br.ufc.demoday.service.api.body.LoginBody;
import br.ufc.demoday.service.api.body.ProcessBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

// Classe usada para acessar a API da PDTech
public class ApiPdSign {
    private final Dotenv dotenv = Dotenv.load();
    private HashMap<String, String> envs = new HashMap<>();
    private ClientPdSign client = new ClientPdSign();
    private String accessToken;
    private Gson gson = new Gson();

    private void loadEnvs(){
        envs.put("baseUrl", dotenv.get("BASE_URL"));
    }
    // Esse construtor é responsável por estabalecer a conexão com a API
    public ApiPdSign() throws IOException {
        client.doLogin();
        accessToken = client.getAccessToken();
        loadEnvs();
    }

    public void createProcess() throws IOException {
        ProcessBody body = new ProcessBody();
        String json = gson.toJson(body);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(envs.get("baseUrl"));
        StringEntity stringEntity = new StringEntity(json);
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Authorization", "Bearer " + accessToken.substring(1, accessToken.length() - 1));
        httpPost.setHeader("Content-Type","application/json");

        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("The status code is: " + statusCode);
            String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            if(responseBody != null){
                System.out.println("The token is: " + accessToken.substring(1, accessToken.length() - 1));
                System.out.println("The request body was: " + json);
                System.out.println(responseBody);
                if(statusCode == 200){
                    JsonObject jsonObject = (JsonObject) JsonParser.parseString(responseBody);
                    System.out.println(jsonObject);
                }
            }
            EntityUtils.consume(entity);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



