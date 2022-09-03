package br.ufc.demoday.model;
import java.util.ArrayList;

public class ProcessApi {

    private final ArrayList<UserApi> users;

    public ProcessApi(){
        users = new ArrayList<>();
    }
    public ArrayList<UserApi> getUsers(){
        return users;
    }
}

