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
	private int idAd; 
	private boolean adStatus; 
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

	public Ad(int idAd, boolean adStatus, double price, User user) {
		super();
		this.idAd = idAd;
		this.adStatus = adStatus;
		this.price = price;
		this.user = user;
	}

	public int getIdAd() {
		return idAd;
	}

	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public boolean isAdStatus() {
		return adStatus;
	}

	public void setAdStatus(boolean adStatus) {
		this.adStatus = adStatus;
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
		return "Ad [idAd=" + idAd + ", adStatus=" + adStatus + ", price=" + price + ", user=" + user + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
