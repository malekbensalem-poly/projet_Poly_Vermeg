package modele;

import java.util.Vector;

public class Utilisateur extends Personne {

	private Vector<Facture> listFacture ;
	static int idUtilisateur ;
	
	
	
	public Utilisateur(String nom, String prenom, int cin, int tel) {
		super(nom, prenom, cin, tel);
		this.listFacture = new Vector<Facture>();
		idUtilisateur ++ ;
	}


	
	public Utilisateur(String nom , int cin , int tel) {
		super(nom,cin,tel);
		this.listFacture = new Vector<Facture>();
		idUtilisateur ++ ;
	}
	
	public Utilisateur(String nom , int cin ) {
		super(nom,cin);
		this.listFacture = new Vector<Facture>();
		idUtilisateur ++ ;
	}
	
	public Utilisateur() {
		super();
		this.listFacture = new Vector<Facture>();
		idUtilisateur ++ ;
	}
	
	
	
	public static int getIdUtilisateur() {
		return idUtilisateur;
	}

	public static void setIdUtilisateur(int idUtilisateur) {
		Utilisateur.idUtilisateur = idUtilisateur;
	}

	public Vector<Facture> getListFacture() {
		return listFacture;
	}

	public void setListFacture(Vector<Facture> listFacture) {
		this.listFacture = listFacture;
	}

	public static void afficherLesUtilisateur(Vector<Utilisateur> u) {
		for(int i = 0 ; i < u.size() ; i++) {
		System.out.println("idUtilisateur : "+u.get(i).getIdUtilisateur()+"Nom utilisateur = "+u.get(i).getNom()+" , cin = "+u.get(i).getCin());
		}
	}
	

}
