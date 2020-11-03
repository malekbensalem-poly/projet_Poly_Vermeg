package modele;

import java.util.Vector;

public class Administrateur extends Personne {
	
	static Vector<Produit> produits = new Vector<Produit>() ;
	static Vector<Utilisateur> utilisateurs = new Vector<Utilisateur>() ;
	
	

	

	public Administrateur(String nom, String prenom, int cin, int tel) {
		super(nom, prenom, cin, tel);
	}
	
	public Administrateur(String nom , int cin , int tel) {
		super(nom,cin,tel);
	}
	
	public Administrateur(String nom , int cin ) {
		super(nom,cin);
	}
	
	public Vector<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Vector<Produit> produits) {
		this.produits = produits;
	}

	public Vector<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Vector<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	public void ajouterProduitStock(Produit p , Vector<Produit> v1 ) {
		v1.add(p);
	}
	
	public void supprimerProduitStock(Produit p , Vector<Produit> v1) {
		v1.removeElement(p);
	}
	
	
	public void modifierReferenceProduit(Produit p , Vector<Produit> v1 , String reference) {
		for(int i = 0 ; i<v1.size() ; i++) {
			if(v1.get(i).equals(p)) {
				p.setReference(reference);
			}
		}
	}
	
	public void modifierPrixProduit(Produit p , Vector<Produit> v1 , double prix) {
		for(int i = 0 ; i<v1.size() ; i++) {
			if(v1.get(i).equals(p)) {
				p.setPrix(prix);
			}
		}
	}
	
	public void modifierQuantiteStockProduit(Produit p , Vector<Produit> v1 , int qt) {
		for(int i = 0 ; i<v1.size() ; i++) {
			if(v1.get(i).equals(p)) {
				p.setQuantiteStock(qt);
			}
		}
	}
	
	public void ajouterUtilisateur(Utilisateur u , Vector<Utilisateur> v2 ) {
		v2.add(u);
	}
	
	public void supprimerUtilisateur(Utilisateur u , Vector<Utilisateur> v2 ) {
		v2.removeElement(u);
	}
	
	public Produit getProduitFromVector(Vector<Produit> v1 , int idProduit) {
		for(int g = 0 ;  g < v1.size() ; g++) {
			if(v1.get(g).getIdProduit()==idProduit) {
				return v1.get(g) ;
			}
		}
		System.out.println("le Produit n'est pas disponible !!!");
	    return null ;	
	}

}
