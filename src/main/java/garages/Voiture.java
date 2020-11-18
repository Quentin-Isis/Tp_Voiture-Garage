package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final List<Stationnement> myStationnements = new LinkedList<>();
        private final List<Garage> garageVisités = new LinkedList<>();
        private Date date_entrée;
        private final List<Date> Entree = new LinkedList<>();
        private Date date_sortie;
        private final List<Date> Sortie = new LinkedList<>();
        

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage 
         * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) {
            if (Entree.size() == Sortie.size()){  
		throw new IllegalArgumentException("Voiture déjà dans un garage");
            }
            Stationnement s = new Stationnement(this, g);
            myStationnements.add(s);
            date_entrée = new Date(); 
            Entree.add(date_entrée);
	}

	/**
	 * Fait sortir la voiture du garage 
         * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
		if (myStationnements.size()!=0) {
                    throw new IllegalArgumentException("La voiture n'est pas dans un garage");
                }
                myStationnements.remove(0);     // Terminer ce stationnement
                date_sortie = new Date();
                Sortie.add(date_sortie);
        }

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
            
            if (myStationnements.size()!=0) {
               Garage g = new Garage("myStationnements.get(0)");
                garageVisités.add(g);
            }
            return (Set<Garage>) garageVisités;
	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		if (myStationnements.isEmpty()) {
                    return false;
                }
                return true;
        }

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des dates d'entrée / sortie dans ce
	 * garage
	 * <br>Exemple :
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
            
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket ");
            
            int nombre =1;
            
            Garage g = garageVisités.get(0);
            System.out.println ("# g ");
            
            if (myStationnements.isEmpty()) {
            while (nombre<= garageVisités.size()) {       
                if (g==garageVisités.get(nombre)) {
                    System.out.println("# Statinnoment {"+Entree.get(nombre)+","+Sortie.get(nombre)+"}");
                    nombre+=1;
                }
                System.out.println ("# garageVisités.get(nombre)");
                System.out.println("# Statinnoment {"+Entree.get(nombre)+","+Sortie.get(nombre)+"}");
            }
            }
            while (nombre<= garageVisités.size()-1) {       
                if (g==garageVisités.get(nombre)) {
                    System.out.println("# Statinnoment {"+Entree.get(nombre)+","+Sortie.get(nombre)+"}");
                    nombre+=1;
                }
                System.out.println ("# garageVisités.get(nombre)");
                System.out.println("# Statinnoment {"+Entree.get(nombre)+","+Sortie.get(nombre)+"}");
                nombre+=1;
            }
                System.out.println ("# garageVisités.get(nombre+1)");
                System.out.println("# Statinnoment {"+Entree.get(nombre)+"en cours}");
                System.out.println();
            }
	

}
