package br.ufc.demoday.service.api;

import br.ufc.demoday.service.api.body.DocumentProcessBody;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class DocumentProcess {
    private final Dotenv dotenv = Dotenv.load();
    private final HashMap<String, String> envs = new HashMap<>();
    private final Gson gson = new Gson();
    private final String processId;
    protected final String acessToken;

    private void loadEnvs(){
        envs.put("baseUrl", dotenv.get("BASE_URL"));
    }

    public DocumentProcess(@NotNull CreateProcess process){
        loadEnvs();
        processId = process.getProcessId();
        acessToken = process.getAccessToken();
    }

    public void createProcessDocument(String documentName){
        DocumentProcessBody documentProcess = new DocumentProcessBody();
        documentProcess.setName(documentName);
        String json = gson.toJson(documentProcess);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(envs.get("baseUrl") + "/processes/" + processId + "/documents");
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + acessToken);
        httpPost.setHeader("Content-Type","application/json");
        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            if(responseBody != null){
                if(statusCode == 200){
                    JsonObject jsonObject = (JsonObject) JsonParser.parseString(responseBody);
                    envs.put("documentId", String.valueOf(jsonObject.get("id")));
                }
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getDocumentId(){
        return envs.get("documentId").substring(1, envs.get("documentId").length() - 1);
    }
    public String getProcessId(){
        return processId;
    }
}
