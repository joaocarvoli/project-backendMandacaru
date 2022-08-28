package br.ufc.demoday.service.api.body;
import io.github.cdimascio.dotenv.Dotenv;

public class LoginBody {
    private final String username;
    private final String password;
    private final String client_id;
    private final String grant_type;

    public LoginBody(){
        final Dotenv dotenv = Dotenv.load();
        username = dotenv.get("USERNAME_PD_TECH");
        password = dotenv.get("PASSWORD_PD_TECH");
        client_id = dotenv.get("CLIENT_ID_PD_TECH");
        grant_type = dotenv.get("GRANT_TYPE_PD_TECH");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getGrant_type() {
        return grant_type;
    }
}
