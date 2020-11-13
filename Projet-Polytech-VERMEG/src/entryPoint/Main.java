package entryPoint;

import java.sql.Date;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import model.Administrator;
import model.Bill;
import model.Book;
import model.LineCommand;
import model.Person;
import model.Product;
import model.User;

public class Main {

	public static void main(String[] args) throws java.lang.NullPointerException, SQLException {

		System.out.println(".............. " + Administrator.getDateNow() + " ...........");
		System.out.println(" ............. Book Store ........... ");

		int adminOuUtilisateur;
		int ajoutOuSupprimerOuModiferUtilisateurProduit;
		boolean sortirAdmin = false;
		boolean sortirUtilisateur = false;
		Administrator admin = new Administrator("soumer", "ahmed", 14264365, 20154927);
		System.out.println("Si vous etes administrateur taper 1 !!!");
		System.out.println("Si vous etes un utilisateur taper 2 !!!");

		try {
			do {
				Scanner clavierAdminOuUtilisateur = new Scanner(System.in);
				adminOuUtilisateur = clavierAdminOuUtilisateur.nextInt();

				if (adminOuUtilisateur == 1) {
					System.out.println("Bienvenue ADMIN !");
					System.out.println("Si Voulez vous Ajouter utilisateur taper........1 !!!");
					System.out.println("Si Voulez vous Ajouter Produit taper............2 !!!");
					System.out.println("Si Voulez vous Supprimer utilisateur taper......3 !!!");
					System.out.println("Si Voulez vous Supprimer Produit taper..........4 !!!");
					System.out.println("Si Voulez vous modifier utilisateur taper.......5 !!!");
					System.out.println("Si Voulez vous modifier Produit taper...........6 !!!");
					System.out.println("Si Voulez vous consulter les factures taper.....7 !!!");
					System.out.println("Si Voulez vous consulter les utilisateurs taper.8 !!!");

					do {
						Scanner clavierAjoutOuSupprimerUtilisateurOuProduit = new Scanner(System.in);
						ajoutOuSupprimerOuModiferUtilisateurProduit = clavierAjoutOuSupprimerUtilisateurOuProduit
								.nextInt();
						if (ajoutOuSupprimerOuModiferUtilisateurProduit == 1) {
							Scanner clavierAjoutUtilisateur = new Scanner(System.in);
							System.out.println("saisir le nom de l'utilisateur......!!");
							String nom = clavierAjoutUtilisateur.next();
							System.out.println("saisir le prenom de l'utilisateur...!!");
							String prenom = clavierAjoutUtilisateur.next();
							System.out.println("saisir le cin de l'utilisateur......!!");
							int cin = clavierAjoutUtilisateur.nextInt();
							System.out.println("saisir le num tel de l'utilisateur..!!");
							int tel = clavierAjoutUtilisateur.nextInt();
							User u = new User(nom, prenom, cin, tel);
							u.addUser();
							System.out.println("Utilisateur ajouter avec succes !");
							System.out.println("Si Voulez vous Ajouter utilisateur taper...1 !!!");
							System.out.println("Si Voulez vous Ajouter Produit taper.......2 !!!");
							System.out.println("Si Voulez vous Supprimer utilisateur taper.3 !!!");
							System.out.println("Si Voulez vous Supprimer Produit taper.....4 !!!");
							System.out.println("Si Voulez vous modifier utilisateur taper..5 !!!");
							System.out.println("Si Voulez vous modifier Produit taper......6 !!!");
							System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
							System.out.println("autre nombre pour quitter !!!");

						} else if (ajoutOuSupprimerOuModiferUtilisateurProduit == 2) {

							Scanner clavierAjoutProduit = new Scanner(System.in);
							System.out.println("saisir la disignation du produit !!");
							String disignation = clavierAjoutProduit.next();
							System.out.println("saisir la reference du produit !!");
							String reference = clavierAjoutProduit.next();
							System.out.println("saisir la quantite du produit dans le stock !!");
							int quantiteStock = clavierAjoutProduit.nextInt();
							System.out.println("saisir le prix du produit !!");
							double prix = clavierAjoutProduit.nextDouble();
							System.out.println("saisir le titre du produit !!");
							String titre = clavierAjoutProduit.next();
							System.out.println("saisir l'autheur du produit !!");
							String autheur = clavierAjoutProduit.next();
							Book lv = new Book(disignation, reference, quantiteStock, prix, titre, autheur,
									new Date(1, 1, 2020));
							lv.addBook();
							System.out.println("produit ajouter avec succes !");
							Book.findAllBook();
							System.out.println("Si Voulez vous Ajouter utilisateur taper...1 !!!");
							System.out.println("Si Voulez vous Ajouter Produit taper.......2 !!!");
							System.out.println("Si Voulez vous Supprimer utilisateur taper.3 !!!");
							System.out.println("Si Voulez vous Supprimer Produit taper.....4 !!!");
							System.out.println("Si Voulez vous modifier utilisateur taper..5 !!!");
							System.out.println("Si Voulez vous modifier Produit taper......6 !!!");
							System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
							System.out.println("autre nombre pour retour au menu !!!");
						} else if (ajoutOuSupprimerOuModiferUtilisateurProduit == 3) {
							User.findAllUser();
							Scanner clavierSupprimerUtilisateur = new Scanner(System.in);
							System.out.println("saisir l'id du utilisateur a supprimer !!");
							int idUtilisateurSupp = clavierSupprimerUtilisateur.nextInt();
							User.DeleteUser(idUtilisateurSupp);
							System.out.println("l'utilisateur est supprimer !!");
							System.out.println("Si Voulez vous Ajouter utilisateur taper...1 !!!");
							System.out.println("Si Voulez vous Ajouter Produit taper.......2 !!!");
							System.out.println("Si Voulez vous Supprimer utilisateur taper.3 !!!");
							System.out.println("Si Voulez vous Supprimer Produit taper.....4 !!!");
							System.out.println("Si Voulez vous modifier utilisateur taper..5 !!!");
							System.out.println("Si Voulez vous modifier Produit taper......6 !!!");
							System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
							System.out.println("Taper autre nombre pour retour au menu !!!");

						} else if (ajoutOuSupprimerOuModiferUtilisateurProduit == 4) {
							Book.findAllBook();
							Scanner clavierSupprimerProduit = new Scanner(System.in);
							System.out.println("saisir l'id du produit a supprimer !!");
							int idProduitSupp = clavierSupprimerProduit.nextInt();
							Product.DeleteProduct(idProduitSupp);
							System.out.println("le produit est supprimé !!");
							System.out.println("Si Voulez vous Ajouter utilisateur taper...1 !!!");
							System.out.println("Si Voulez vous Ajouter Produit taper.......2 !!!");
							System.out.println("Si Voulez vous Supprimer utilisateur taper.3 !!!");
							System.out.println("Si Voulez vous Supprimer Produit taper.....4 !!!");
							System.out.println("Si Voulez vous modifier utilisateur taper..5 !!!");
							System.out.println("Si Voulez vous modifier Produit taper......6 !!!");
							System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
							System.out.println("Taper autre nombre pour retour au menu !!!");

						} else if (ajoutOuSupprimerOuModiferUtilisateurProduit == 5) {
							User.findAllUser();
							Scanner clavierModifierUtilisateur = new Scanner(System.in);
							System.out.println("saisir l'id du l'utilisateur a modifier !!");
							int idUtilisateurModif = clavierModifierUtilisateur.nextInt();
							if (User.findUserById(idUtilisateurModif) != null) {
								System.out.println("saisir le nom de l'utilisateur......!!");
								String nom2 = clavierModifierUtilisateur.next();
								System.out.println("saisir le prenom de l'utilisateur...!!");
								String prenom2 = clavierModifierUtilisateur.next();
								System.out.println("saisir le cin de l'utilisateur......!!");
								int cin2 = clavierModifierUtilisateur.nextInt();
								System.out.println("saisir le num tel de l'utilisateur..!!");
								int tel2 = clavierModifierUtilisateur.nextInt();
								User.updateUser(idUtilisateurModif, nom2, prenom2, cin2, tel2);
								System.out.println("l'utilisateur est modifié !!");
								System.out.println("Si Voulez vous Ajouter utilisateur taper...1 !!!");
								System.out.println("Si Voulez vous Ajouter Produit taper.......2 !!!");
								System.out.println("Si Voulez vous Supprimer utilisateur taper.3 !!!");
								System.out.println("Si Voulez vous Supprimer Produit taper.....4 !!!");
								System.out.println("Si Voulez vous modifier utilisateur taper..5 !!!");
								System.out.println("Si Voulez vous modifier Produit taper......6 !!!");
								System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
								System.out.println("Taper autre nombre pour retour au menu !!!");
							}

							else {
								System.out.println("l'utilisateur n'existe pas !!");
								System.out.println("Si Voulez vous Ajouter utilisateur taper...1 !!!");
								System.out.println("Si Voulez vous Ajouter Produit taper.......2 !!!");
								System.out.println("Si Voulez vous Supprimer utilisateur taper.3 !!!");
								System.out.println("Si Voulez vous Supprimer Produit taper.....4 !!!");
								System.out.println("Si Voulez vous modifier utilisateur taper..5 !!!");
								System.out.println("Si Voulez vous modifier Produit taper......6 !!!");
								System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
								System.out.println("Taper autre nombre pour retour au menu !!!");
							}
						} else if (ajoutOuSupprimerOuModiferUtilisateurProduit == 6) {
							Book.findAllBook();
							Scanner clavierModifierProduit = new Scanner(System.in);
							System.out.println("saisir l'id du produit a modifier !!");
							int idProduitModif = clavierModifierProduit.nextInt();
							System.out.println("saisir la quantite du produit dans le stock !!");
							int quantiteStock1 = clavierModifierProduit.nextInt();
							System.out.println("saisir le prix du produit !!");
							double prix1 = clavierModifierProduit.nextDouble();
							Book.updatePriceAndQuantiteStockOfBook(idProduitModif, prix1, quantiteStock1);
							System.out.println("le produit est modifié !!");
							System.out.println("Si Voulez vous Ajouter utilisateur taper....1 !!!");
							System.out.println("Si Voulez vous Ajouter Produit taper........2 !!!");
							System.out.println("Si Voulez vous Supprimer utilisateur taper..3 !!!");
							System.out.println("Si Voulez vous Supprimer Produit taper......4 !!!");
							System.out.println("Si Voulez vous modifier utilisateur taper...5 !!!");
							System.out.println("Si Voulez vous modifier Produit taper.......6 !!!");
							System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
							System.out.println("Taper autre nombre pour retour au menu !!!");

						} else if (ajoutOuSupprimerOuModiferUtilisateurProduit == 7) {
							Bill.findAllBill();
							Scanner clavierSupprimerFacture = new Scanner(System.in);
							System.out.println("saisir l'id du facture a supprimer !!");
							System.out.println("saisir autre pour retour au menu   !!");
							int idFactureSupp = clavierSupprimerFacture.nextInt();

							if (Bill.findBillById(idFactureSupp) != null) {
								Bill.DeleteBill(idFactureSupp);
								System.out.println("........... la facture est supprimer......");
								System.out.println("Si Voulez vous Ajouter utilisateur taper....1 !!!");
								System.out.println("Si Voulez vous Ajouter Produit taper........2 !!!");
								System.out.println("Si Voulez vous Supprimer utilisateur taper..3 !!!");
								System.out.println("Si Voulez vous Supprimer Produit taper......4 !!!");
								System.out.println("Si Voulez vous modifier utilisateur taper...5 !!!");
								System.out.println("Si Voulez vous modifier Produit taper.......6 !!!");
								System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
								System.out.println("Taper autre nombre pour retour au menu !!!");
							} else {
								System.out.println("Si Voulez vous Ajouter utilisateur taper....1 !!!");
								System.out.println("Si Voulez vous Ajouter Produit taper........2 !!!");
								System.out.println("Si Voulez vous Supprimer utilisateur taper..3 !!!");
								System.out.println("Si Voulez vous Supprimer Produit taper......4 !!!");
								System.out.println("Si Voulez vous modifier utilisateur taper...5 !!!");
								System.out.println("Si Voulez vous modifier Produit taper.......6 !!!");
								System.out.println("Si Voulez vous consulter les factures taper.7 !!!");
								System.out.println("Taper autre nombre pour retour au menu !!!");
							}
						}

						else if (ajoutOuSupprimerOuModiferUtilisateurProduit == 8) {
							User.findAllUser();

							Scanner clavierUserFacture = new Scanner(System.in);
							System.out.println("saisir l'id de l'utilisateur pour consulter ces factures.!!");
							System.out.println("saisir autre pour retour au menu ........................!!");
							int idUserFacture = clavierUserFacture.nextInt();
							Bill.findBillByIdUser(idUserFacture);
							System.out.println("Taper autre nombre pour retour au menu !!!");
						}

						else if (ajoutOuSupprimerOuModiferUtilisateurProduit == 9) {
							Product.findAllProduit();
							Scanner clavierUserFacture = new Scanner(System.in);
							System.out.println("saisir autre pour retour au menu ........................!!");

						}

						else {
							System.out.println("Taper 1 pour continuer en tant que admin s'il vous plait");
							System.out.println("Taper 2 pour ouvrir en tant que utilisateur s'il vous plait  !");
							sortirAdmin = true;
						}

					} while ((ajoutOuSupprimerOuModiferUtilisateurProduit != 1
							|| ajoutOuSupprimerOuModiferUtilisateurProduit != 2
							|| ajoutOuSupprimerOuModiferUtilisateurProduit != 3
							|| ajoutOuSupprimerOuModiferUtilisateurProduit != 4
							|| ajoutOuSupprimerOuModiferUtilisateurProduit != 5
							|| ajoutOuSupprimerOuModiferUtilisateurProduit != 6
							|| ajoutOuSupprimerOuModiferUtilisateurProduit != 7
							|| ajoutOuSupprimerOuModiferUtilisateurProduit != 8
							|| ajoutOuSupprimerOuModiferUtilisateurProduit != 9) && !sortirAdmin);
				}

				else if (adminOuUtilisateur == 2) {
					System.out.println("Bienvenue cher utilisateur !");
					User.findAllUser();
					System.out.println("Saisir l'idUtilisateur pour se connecter !!");
					Scanner clavierIdUtilisateur = new Scanner(System.in);
					int idUtilisateurChoisit = clavierIdUtilisateur.nextInt();

					if (User.findUserById(idUtilisateurChoisit) != null) {
						Bill f = new Bill(idUtilisateurChoisit, Administrator.getDateNow());
						Book.findAllBook();
						do {
							System.out.println("Donner l'id du produit que voulez vous acheté.....! ");
							System.out.println("Taper autre nombre pour quitter...................!");
							Scanner clavierIdProduit = new Scanner(System.in);
							int idProduitChoisit = clavierIdProduit.nextInt();
							Vector<LineCommand> v = new Vector<LineCommand>();

							boolean continuer = true;

							if (Book.findBookById(idProduitChoisit) != null && continuer) {
								System.out.println("Donner quantite que tu veut l'acheter !!!");
								int quantiteProduitChoisit = clavierIdProduit.nextInt();
								LineCommand l = new LineCommand(f.getLastID() + 1, idProduitChoisit,
										quantiteProduitChoisit);
								l.addLineCommand();
								v = f.findLineCommandByBill(f.getLastID() + 1);
								f.setTotal(Bill.calculerTotalPrix(v));
								System.out.println("Le prix totale = " + Bill.calculerTotalPrix(v));

								System.out.println("saisir 1 pour continuer !!!");
								System.out.println("saisir 2 pour supprimer une lineCommand !!!");
								Scanner clavierContinuer = new Scanner(System.in);
								int continuerOrNot = clavierContinuer.nextInt();
								if (continuerOrNot == 1) {

								} else {
									System.out.println("saisir l'id du lineCommand a supprimer !!!");
									Scanner clavierSuppLineCommande = new Scanner(System.in);
									int idLineCommandeSupp = clavierSuppLineCommande.nextInt();
									LineCommand.DeleteLineCommand(idLineCommandeSupp);
									continuer = true;
								}

							}

							else {
								f.addBill();
								System.out.println("Le prix totale = " + f.getTotal());
								System.out.println("Si vous etes administrateur taper 1 si un utilisateur taper 2 !!!");
								sortirUtilisateur = true;
							}

						} while (!sortirUtilisateur);
					}

					else {
						System.out.println(
								"Taper 1 pour connecter en tant que administrateur et 2 pour utilisateur ou autre nombre pour retour au menu !");
					}

				}

				else
					System.out.println(
							"Taper 1 pour connecter en tant que administrateur et 2 pour utilisateur ou autre nombre pour retour au menu !");

			} while (adminOuUtilisateur != 1 || adminOuUtilisateur != 2);

		} catch (InputMismatchException e) {
			System.out.println("Respecter les types de donneé saisie et notre messages d'indication !!!!");
			System.out.println("redemarrer le programme !!");
		}

	}

}
