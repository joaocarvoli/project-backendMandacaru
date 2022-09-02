package br.ufc.demoday.service.api;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import br.ufc.demoday.service.api.body.LoginBody;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class ClientPdSign {
    private final Dotenv dotenv = Dotenv.load();
    private final HashMap<String, String> envs = new HashMap<>();
    private Gson gson = new Gson();
    private void loadEnvs(){
        envs.put("baseUrl", dotenv.get("LOGIN_URL"));
    }
     public void doLogin() throws IOException {
        loadEnvs();
        LoginBody body = new LoginBody();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(envs.get("baseUrl"));
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("username",body.getUsername()));
        nameValuePairs.add(new BasicNameValuePair("password",body.getPassword()));
        nameValuePairs.add(new BasicNameValuePair("client_id",body.getClient_id()));
        nameValuePairs.add(new BasicNameValuePair("grant_type",body.getGrant_type()));
        StringEntity stringEntity = new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8);
        stringEntity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-type","application/x-www-form-urlencoded");

        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == 200){
                String responseBody = EntityUtils.toString(entity);
                JsonObject jsonObject = (JsonObject) JsonParser.parseString(Objects.requireNonNull(responseBody));
                envs.put("access_token", String.valueOf(jsonObject.get("access_token")));
                envs.put("refresh_token", String.valueOf(jsonObject.get("refresh_token")));
                EntityUtils.consume(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAccessToken(){
        return envs.get("access_token");
    }
    public String getRefreshToken(){
        return envs.get("refresh_token");
    }
}
