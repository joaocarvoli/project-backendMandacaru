package br.ufc.demoday.model;
import java.util.List;

public class Process {

    private List<User> users;
    List<User> users;

    //Pode setar o id ou não user.setId(resultSet.getLong("A"));
    //Como é possivel pegar o json?
    public Process(){
       users = new ArrayList<User>();
    }

    private void AdUser(User user){
        users.add(user);
    }

}

public class User () {
    String name;
    String email;
}