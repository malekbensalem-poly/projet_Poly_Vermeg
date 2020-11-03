package entreePoint;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import modele.Administrateur;
import modele.Facture;
import modele.LigneDeCommande;
import modele.Produit;
import modele.Utilisateur;

public class Main {
	

	public static void main(String[] args)  {


		int adminOuUtilisateur ;
		int ajoutUtilisateurProduit ;
		boolean sortirAdmin = false;
		boolean sortirUtilisateur = false;
		Administrateur admin = new Administrateur("soumer" , "ahmed" , 14264365 , 20154927);
		System.out.println("Si vous etes administrateur taper 1 si un utilisateur taper 2 !!!");
		
		
		
		try {
		do {
			Scanner clavierAdminOuUtilisateur = new Scanner(System.in) ;
			adminOuUtilisateur = clavierAdminOuUtilisateur.nextInt();
			
			if(adminOuUtilisateur == 1) {
				System.out.println("Bienvenue ADMIN !");
				System.out.println("Si Vouler vous Ajouter Client taper 1 "
						+ "Si Vouler vous Ajouter Produit taper 2 !");
				
				do {
					Scanner clavierAjoutUtilisateurOuProduit = new Scanner(System.in) ;
					ajoutUtilisateurProduit = clavierAjoutUtilisateurOuProduit.nextInt();
					if(ajoutUtilisateurProduit == 1) {
						Scanner clavierAjoutUtilisateur = new Scanner(System.in) ;
						System.out.println("saisir le nom de l'utilisateur !!");
						String nom  = clavierAjoutUtilisateur.nextLine();
						System.out.println("saisir le prenom de l'utilisateur !!");
						String prenom  = clavierAjoutUtilisateur.nextLine();
						System.out.println("saisir le cin de l'utilisateur !!");
						int cin  = clavierAjoutUtilisateur.nextInt();
						System.out.println("saisir le num tel de l'utilisateur !!");
						int tel  = clavierAjoutUtilisateur.nextInt();
						Utilisateur u = new Utilisateur(nom , prenom , cin , tel);
						admin.ajouterUtilisateur(u, admin.getUtilisateurs());
						System.out.println("Utilisateur ajouter avec succes !");
						System.out.println("ajout utilisateur taper 1 ajout produit taper 2 !!!");
						
						
					}
					else if(ajoutUtilisateurProduit == 2) {
						
						Scanner clavierAjoutProduit = new Scanner(System.in) ;
						System.out.println("saisir l'id du produit !!");
						int idProduit  = clavierAjoutProduit.nextInt();
						System.out.println("saisir la disignation du produit !!");
						String disignation  = clavierAjoutProduit.nextLine();
						System.out.println("saisir la reference du produit !!");
						String reference  = clavierAjoutProduit.nextLine();
						System.out.println("saisir la quantite du produit dans le stock !!");
						int quantiteStock  = clavierAjoutProduit.nextInt();
						System.out.println("saisir le prix du produit !!");
						double prix  = clavierAjoutProduit.nextDouble();
						Produit p = new Produit(idProduit , disignation , reference , quantiteStock , prix);
						admin.ajouterProduitStock(p, admin.getProduits());
						System.out.println("produit ajouter avec succes !");
						Produit.afficherLesProduit(admin.getProduits()) ;
						System.out.println("ajout utilisateur taper 1 ajout produit taper 2 !!!");
					}
					else {
						System.out.println("Taper 1 pour continuer en tant que admin ou 2 pour ouvrir en tant que utilisateur s'il vous plait  !");
						sortirAdmin = true;
					    }
					
				}while((ajoutUtilisateurProduit != 1 || ajoutUtilisateurProduit != 2)&&!sortirAdmin);
			}
			
			
			
			else if (adminOuUtilisateur == 2) {
				System.out.println("Bienvenue cher utilisateur !");
				
				
				Vector <LigneDeCommande> lesAchat = new Vector<LigneDeCommande>() ; 
				Facture f = new Facture(lesAchat) ;
				Produit.afficherLesProduit(admin.getProduits()) ;
				
				
				do {	
				System.out.println("Donner l'id du produit que voulez vous acheté ou autre nombre pour quitté") ;
				Scanner clavierIdProduit = new Scanner(System.in) ;
				int idProduitChoisit = clavierIdProduit.nextInt();
				Produit p = admin.getProduitFromVector(admin.getProduits(), idProduitChoisit);
				if (p != null) {
				System.out.println("Donner quantite que tu veut l'acheter !!!") ;
				int quantiteProduitChoisit = clavierIdProduit.nextInt();
				LigneDeCommande l = new LigneDeCommande(f,p,quantiteProduitChoisit); 
				f.ajouterLigneDeCommande(lesAchat, l);
				f.afficherFacture(lesAchat);
				System.out.println("Le prix totale = "+f.calculerTotalPrix(lesAchat));}
				
				else {
					System.out.println("Le prix totale = "+f.calculerTotalPrix(lesAchat));
					System.out.println("Si vous etes administrateur taper 1 si un utilisateur taper 2 !!!");
					sortirUtilisateur = true ;} 
				
				
				}while(!sortirUtilisateur) ;
				
			
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
			else System.out.println("Taper 1 ou 2  s'il vous plait  admin ou utilisateur !!!");
		
		
		
		
		}while(adminOuUtilisateur!=1 || adminOuUtilisateur!=2) ;
		
		
		}catch(InputMismatchException e) {
			System.out.println("Respecter les types de donneé saisie et notre messages d'indication !!!!");
			System.out.println("redemarrer le programme !!");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*		Vector <LigneDeCommande> tableauAchat = new Vector<LigneDeCommande>() ; 
		Facture f = new Facture(tableauAchat) ;
		Scanner clavier = new Scanner(System.in);
		System.out.println("***** Entrer les Lignes de commande *****") ;
		
		
		System.out.println("La reference du produit 1 !? .... = ");
		String a = clavier.nextLine();
		System.out.println("Le prix du produit  !? .... = ");
		Double b = clavier.nextDouble();
		Produit p1 = new Produit(a,b);
		p1.afficherProduit();
		System.out.println("La quantite du produit  !? .... = ");
		int c = clavier.nextInt();
		LigneDeCommande l = new LigneDeCommande(p1 , c);
		f.ajouterLigneDeCommande(tableauAchat, l);
		
		Scanner clavier1 = new Scanner(System.in);
		System.out.println("La reference du produit 2 !? .... = ");
		String a1 = clavier1.nextLine();
		System.out.println("Le prix du produit  !? .... = ");
		Double b1 = clavier1.nextDouble();
		Produit p2 = new Produit(a1,b1);
		p2.afficherProduit();
		System.out.println("La quantite du produit  !? .... = ");
		int c1 = clavier1.nextInt();
		LigneDeCommande l1 = new LigneDeCommande(p2 , c1);
		f.ajouterLigneDeCommande(tableauAchat, l1);
		
		
		
		f.afficherFacture(tableauAchat);
		double total = f.calculerTotalPrix(tableauAchat);
		System.out.println("le total prix de la facture = "+f.getIdFacture()+" est = "+total) ;
		
	*/
	  }
	 

}
