package br.ufc.demoday.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/*
 * Classe Imóvel estereotipada com as anotações @Entity, @Id, @GeneretedValue 
 * para administração via Spring implementando JPA e suas variáveis.   
 * 
 * 
 */
@Entity
public class Immobile {
   
	@Id
    @GeneratedValue
    private int idImmobile;
    private String title; 
    private String address;
    private double squareMetersGround;
    private double squareMetersBuilt;
    private int roomsAmount;
    // criar bathAmount //
    private int garageAmount;

    
    //Construtor sem parâmentro com método super() explícito.
    
    public Immobile() {
        super();
    }

    
    //Contrutor com paramentros referente a classe Immobile
    
    public Immobile(int idImmobile, String title, String address, double squareMetersGround, double squareMetersBuilt, int roomsAmount, int garageAmount) {
        super();
        this.idImmobile = idImmobile;
        this.title = title;
        this.address = address;
        this.squareMetersGround = squareMetersGround;
        this.squareMetersBuilt = squareMetersBuilt;
        this.roomsAmount = roomsAmount;
        this.garageAmount = garageAmount;
    }

    
    /*
     * Getters e Setters da classe Immbile 
     */
    
    public int getIdImmobile() {
        return idImmobile;
    }

    public void setIdImmobile(int idImmobile) {
        this.idImmobile = idImmobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquareMetersGround() {
        return squareMetersGround;
    }

    public void setSquareMetersGround(double squareMetersGround) {
        this.squareMetersGround = squareMetersGround;
    }

    public double getSquareMetersBuilt() {
        return squareMetersBuilt;
    }

    public void setSquareMetersBuilt(double squareMetersBuilt) {
        this.squareMetersBuilt = squareMetersBuilt;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public int getGarageAmount() {
        return garageAmount;
    }

    public void setGarageAmount(int garageAmount) {
        this.garageAmount = garageAmount;
    }

    
    /* 
     * Anotação @Override seguindo o padrão de polimorfismo.
     * 
     * Método para retorno de dados da classe Immobile   
    */
    
    @Override
    public String toString() {
        return "Immobile{" +
                "idImmobile=" + idImmobile +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", squareMetersGround=" + squareMetersGround +
                ", squareMetersBuilt=" + squareMetersBuilt +
                ", roomsAmount=" + roomsAmount +
                ", garageAmount=" + garageAmount +
                '}';
    }
}
