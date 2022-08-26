package br.ufc.demoday.service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;


public class ClientPdSign {
    private final Dotenv dotenv = Dotenv.load();
    private final HashMap<String, String> envs = new HashMap<>();
    private void loadEnvs(){
        envs.put("baseUrl", dotenv.get("API_PD_TECH_URL"));
        envs.put("username", dotenv.get("USERNAME_PD_TECH"));
        envs.put("password", dotenv.get("PASSWORD_PD_TECH"));
        envs.put("clientId", dotenv.get("CLIENT_ID_PD_TECH"));
        envs.put("grantType", dotenv.get("GRANT_TYPE_PD_TECH"));
    }
    public Boolean doLogin(){
        loadEnvs();
        OkHttpClient client = new OkHttpClient.Builder().build();
        RequestBody formBody = new FormBody.Builder()
                .add("username", envs.get("username"))
                .add("password", envs.get("password"))
                .add("client_id", envs.get("clientId"))
                .add("grant_type", envs.get("grantType"))
                .build();

        Request request = new Request.Builder()
                .url(envs.get("baseUrl"))
                .post(formBody)
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            if(response.code() == 200){
                JsonObject jsonObject = JsonParser.parseString(Objects.requireNonNull(response.body()).string()).getAsJsonObject();
                envs.put("access_token", String.valueOf(jsonObject.get("access_token")));
                envs.put("refresh_token", String.valueOf(jsonObject.get("refresh_token")));
                return true;
            }
            return false;


        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getAccessToken(){
        return envs.get("access_token");
    }
    public String getRefreshToken(){
        return envs.get("refresh_token");
    }
}
