package br.ufc.demoday.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "ad")
public class Ad {
	@Id
    @GeneratedValue
	private int id_ad;
	private boolean adStatus;
	private int idImmobile;
	private double price;
	@ManyToOne
	@JoinColumn(name="id_user")
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
		this.idImmobile = idImmobile;
		this.price = price;
		this.user = user;
	}

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
