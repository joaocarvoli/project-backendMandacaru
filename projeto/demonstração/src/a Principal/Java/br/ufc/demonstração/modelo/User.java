package br.ufc.demoday.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue
    private int idUSer;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private String address;


    @OneToMany
    @JoinColumn(name = "teste_ad");
    @JsonIgnore
    private Ad ad;

    public User(){
        super();
    }






    public int getIdUSer() {
        return idUSer;
    }


    public void setIdUSer(int idUSer) {
        this.idUSer = idUSer;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

}
