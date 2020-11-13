package model;

public class Person {

	private String nom;
	private String prenom;
	private int cin;
	private int tel;
	private String role;

	public Person(String nom, String prenom, int cin, int tel, String role, int id) {
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.tel = tel;
		this.role = role;

	}

	public Person(String nom, String prenom, int cin, int tel, String role) {
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.tel = tel;
		this.role = role;
	}

	public Person(String nom, String prenom, int cin, int tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.tel = tel;
	}

	public Person(String nom, int cin, int tel) {
		this.nom = nom;
		this.cin = cin;
		this.tel = tel;
	}

	public Person(String nom, int cin) {
		this.nom = nom;
		this.cin = cin;
	}

	public Person() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
