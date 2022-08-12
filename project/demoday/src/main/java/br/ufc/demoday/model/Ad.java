package br.ufc.demoday.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


/*
 * Classe Imóvel estereotipada com as anotações @Entity, @Id, @GeneretedValue 
 * para administração via Spring implementando JPA e suas variáveis.   
 */

//Anotação  @Entity parametrizado com o nome da tabela que será gerenciadas via jpa
@Entity(name = "ad")
public class Ad {
	
	
	@Id
    @GeneratedValue
	private int id_ad;   // variável diferente do padrão cammel Case  
	private boolean adStatus;
	private int idImmobile;   // Variável não pertence a essa Classe entidade 
	private double price;
	
	//Anotações de relacionamento com a classe entidade User
	@ManyToOne
	@JoinColumn(name="id_user") //name da tabela diferente do padrão cammel case e da Classe entidade User
	
	//>>>>>>>>incluir anotação de relação um para um com a Classe entidade Immobile e junção   
	
	@JsonIgnore
	private User user;
	
	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ad(int id_ad, boolean adStatus, int idImmobile, double price, User user) {
		super();
		this.id_ad = id_ad;
		this.adStatus = adStatus;
		this.idImmobile = idImmobile; //requer alteração decorrente das observações logo acima 
		this.price = price;
		this.user = user;
	}

	//requer alteração decorrente das observações logo acima 
	
	public int getId_ad() {
		return id_ad;
	}

	public void setId_ad(int id_ad) {
		this.id_ad = id_ad;
	}

	public boolean isAdStatus() {
		return adStatus;
	}

	public void setAdStatus(boolean adStatus) {
		this.adStatus = adStatus;
	}

	public int getIdImmobile() {
		return idImmobile;
	}

	public void setIdImmobile(int idImmobile) {
		this.idImmobile = idImmobile;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	@Override
	public String toString() {
		
		return "Ad [id_ad=" + id_ad + ", adStatus=" + adStatus + ", idImmobile=" + idImmobile + ", price=" + price
				+ ", user=" + user + "]";
	}

	
	
	
	
	
	
	
	
}
