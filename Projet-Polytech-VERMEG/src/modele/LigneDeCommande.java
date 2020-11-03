package modele;

public class LigneDeCommande {
	
	 private Facture facture ;
	 private Produit produit ;
	 private int quantite ;
	 
	 public LigneDeCommande(Facture facture , Produit produit , int quantite) {
		 this.facture = facture ;
		 this.produit = produit ;
		 this.quantite = quantite ;
	 }

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	 
	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	void afficherLigneDeCommende() {
		System.out.println("LigneDeCommande contient : Produit = "+this.getProduit().getReference()+" , Prix = "
				+this.getProduit().getPrix()+" , Quantite = "+this.getQuantite()) ;
	}
	 
	 
	 
	 
	 

}
