package br.ufc.demoday.service.api;

import br.ufc.demoday.service.api.body.ProcessStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

public class DocumentUpload {

    private final Dotenv dotenv = Dotenv.load();
    private final HashMap<String, String> envs = new HashMap<>();
    private final Gson gson = new Gson();
    private final String processId;
    private final String documentId;
    private final String acessToken;

    private void loadEnvs(){
        envs.put("tenant", dotenv.get("TENANT_API"));
        envs.put("baseUrl", dotenv.get("BASE_URL"));
    }

    public DocumentUpload(DocumentProcess documentProcess){
        loadEnvs();
        processId = documentProcess.getProcessId();
        documentId = documentProcess.getDocumentId();
        acessToken = documentProcess.acessToken;
    }
    public void sendDocument(MultipartFile document) throws IOException {
        RequestBody fileBody = RequestBody.create(okhttp3.MediaType.parse(Objects.requireNonNull(document.getContentType())), document.getBytes());
        MultipartBody multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", document.getOriginalFilename(), fileBody) // file param
                .build();

        Request request = new Request.Builder()
                .url(envs.get("baseUrl") + "/processes/" + processId + "/documents/" + documentId + "/upload")
                .addHeader("Authorization", "Bearer " + acessToken).post(multipartBody).build();

        OkHttpClient client = new OkHttpClient.Builder().build();
        Call call = client.newCall(request);

        ObjectMapper mapper = new ObjectMapper();
        Response response = call.execute();
        if(response.code() == 200){
            JsonNode jsonTree = mapper.readTree(response.body().string());
            envs.put("processId", jsonTree.get("id").asText());
        }
    }

    public boolean checkStatus() throws InterruptedException {
        while(true){
            Thread.sleep(5000);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(envs.get("baseUrl") + "/processes/" + processId + "/documents/" + documentId);
            httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + acessToken);
            httpGet.setHeader("x-tenant", envs.get("tenant"));

            try {
                CloseableHttpResponse response = httpclient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                int statusCode = response.getStatusLine().getStatusCode();
                String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                if(responseBody != null){
                    if(statusCode == 200){
                        JsonObject jsonObject = (JsonObject) JsonParser.parseString(responseBody);
                        if(String.valueOf(jsonObject.get("status")).substring(1, String.valueOf(jsonObject.get("status")).length() - 1).equals("DONE")){
                            return true;
                        }
                    }
                }
                EntityUtils.consume(entity);
                return false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void processRun(){
        ProcessStatus processStatus = new ProcessStatus();
        String json = gson.toJson(processStatus);
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch(envs.get("baseUrl") + "/processes/" + processId);
        httpPatch.setEntity(stringEntity);
        httpPatch.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + acessToken);
        httpPatch.setHeader("x-tenant", envs.get("tenant"));
        httpPatch.setHeader("Content-Type","application/json");

        try {
            CloseableHttpResponse response = httpclient.execute(httpPatch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
