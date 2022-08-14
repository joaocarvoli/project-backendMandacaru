package br.ufc.demoday.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Classe Imóvel estereotipada com as anotações @Entity, @Id, @GeneretedValue
 * para administração via Spring implementando JPA e suas variáveis.
 */

//Anotação  @Entity parametrizado com o nome da tabela que será gerenciadas via jpa
@Entity(name = "user")
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
    @JsonIgnore
    @OneToMany(mappedBy = "user_ad")
    private  List<Ad> ad;
    
     public User(int idUSer, String name, String email, String password, String cpf, String phone, String address,
            List<Ad> ad) {
        this.idUSer = idUSer;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.ad = ad;
    }

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

    public List<Ad> getAd() {
        return ad;
    }

    public void setAd(List<Ad> ad) {
        this.ad = ad;
    }
   
    @Override
    public String toString() {
        return "User [ad=" + ad + ", address=" + address + ", cpf=" + cpf + ", email=" + email + ", idUSer=" + idUSer
                + ", name=" + name + ", password=" + password + ", phone=" + phone + "Ad= " + ad +"]";
    }

}
