package modele;

import java.util.Vector;

public class Facture {

	private static int idFacture ;
    private Vector<LigneDeCommande> achat ;
	
	
	
	public Facture(Vector<LigneDeCommande> achat) {
		this.idFacture ++ ;
		this.achat = achat;
	}
	public int getIdFacture() {
		return idFacture;
	}
	public Vector<LigneDeCommande> getAchat() {
		return achat;
	}
	public void setAchat(Vector<LigneDeCommande> achat) {
		this.achat = achat;
	}
	
	public void ajouterLigneDeCommande(Vector<LigneDeCommande> achat , LigneDeCommande c ) {
		achat.add(c) ;
	}
	
	public void afficherFacture(Vector<LigneDeCommande> achat) {
		for(int i = 0 ; i < achat.size() ; i++) {
			achat.get(i).afficherLigneDeCommende();
		}
	}
	
	public double calculerTotalPrix(Vector<LigneDeCommande> achat) {
		double s = 0 ;
		for(int j = 0 ; j < achat.size() ; j++) {
			s += achat.get(j).getQuantite()*achat.get(j).getProduit().getPrix() ;
		}
		return s ;
	}
	
	
	
	
	
	
}
