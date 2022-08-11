package br.ufc.demoday.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "user")
public class User {
	
	@Id
    @GeneratedValue
	private int idUser;
	private String name;
	private String email;
	private String password;
	private String cpf;
	private String phone;
	private String address;

	@OneToMany(mappedBy = "user")
	private List<Ad> id_ad;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int idUser, String name, String email, String password, String cpf, String phone, String address,
			List<Ad> id_ad) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.phone = phone;
		this.address = address;
		this.id_ad = id_ad;
	}



	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
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



	public List<Ad> getId_ad() {
		return id_ad;
	}



	public void setId_ad(List<Ad> id_ad) {
		this.id_ad = id_ad;
	}



	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf="
				+ cpf + ", phone=" + phone + ", address=" + address + ", id_ad=" + id_ad + "]";
	}
	
	
	
	
	
	
	
}
