package br.ufc.demoday.model;

import java.lang.StackWalker.Option;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	private String adStatus = "pending";
	private double price;
	@ManyToOne
	@JoinColumn(name="id_user") //ok
	@JsonIgnore
	private User user_ad;
	@OneToOne
	@JoinColumn(name = "id_immobile") //ok
	private Immobile immobile;

	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ad(int idAd, double price, User user, Immobile immobile) {
		super();
		this.idAd = idAd;
		this.price = price;
		this.user_ad = user;
		this.immobile = immobile;
	}

	public int getIdAd() {
		return idAd;
	}

	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	//Atualização de set AdStatus
	public void setAdStatus(String adStatus) {
		this.adStatus = adStatus;
	}

	public String getadStatus(){
		return adStatus;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user_ad;
	}

	public void setUser(User user) {
		this.user_ad = user;
	}

	public Immobile getImmobile() {
		return immobile;
	}

	public void setImmobile(Immobile immobile) {
		this.immobile = immobile;
	}

	@Override
	public String toString() {
		return "Ad [idAd= " + idAd + ", adStatus= " + adStatus + ", price= " + price + ", user= " + user_ad + ", Immobile= " + immobile +"]";
	}










}
