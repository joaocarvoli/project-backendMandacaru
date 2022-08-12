package br.ufc.demoday.model;

import java.util.ArrayList;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import antlr.collections.List;
import br.ufc.demoday.service.AdService;


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

   

   
    
  //Anotações de relacionamento com a classe entidade Ad
    @OneToMany
    @JoinColumn(name = "teste_ad")// name diferente do campo definido na classe entidade Ad 
    @JsonIgnore
    private Ad ad;
    
    //criar variavel lista da classe entidade Ad contendo id_ad
    
    public User(){
        super();
    }
      
    
    //Criar contrutor parametrizado com as variáveis acima declaradas
    

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
    
    //Criar metodo tostring com anotação @overrider e retorno 

}

