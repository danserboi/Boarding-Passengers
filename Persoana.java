/**
 * Persoana are ca atribute entitatea de care apartine, numele, varsta si biletul.
 * @author Serboi Florea-Dan 325CB
 */
public class Persoana {
	/**
	 * se refera la id-ul entitatii din care face parte persoana
	 */
	public String apartenenta;
	/**
	 * numele persoanei
	 */
	public String nume;
	/**
	 * varsta persoanei
	 */
	public int varsta;
	/**
	 * biletul care mentioneaza tipul, imbarcare prioritara, nevoile speciale
	 */
	public Bilet bilet;
	
	/**constructor fara parametri**/
	public Persoana() {	
		apartenenta = null;
		nume = null;
		varsta = 0;
		bilet = null;
	}
	/**
	 * constructor cu toate atributele dar fara instantiere pt bilet
	 * @param apartenenta String se refera la id-ul entitatii din care face parte persoana
	 * @param nume String numele persoanei
	 * @param varsta int varsta persoanei
	 * @param bilet Bilet bilet fara instantiere
	 */
	public Persoana(String apartenenta, String nume, int varsta, Bilet bilet) {
		super();
		this.apartenenta = apartenenta;
		this.nume = nume;
		this.varsta = varsta;
		this.bilet = bilet;
	}

	/**
	 * constructor cu toate atributele si cu instantiere pt bilet
	 * @param apartenenta String se refera la id-ul entitatii din care face parte persoana
	 * @param nume String numele persoanei
	 * @param varsta int varsta persoanei
	 * @param tipBilet char tipul biletului : business, premium, economic
	 * @param imbarcarePrioritara boolean are sau nu imbarcare prioritara
	 * @param nevoiSpeciale boolean are sau nu nevoi speciale
	 */
	public Persoana(String apartenenta, String nume, int varsta, char tipBilet, boolean imbarcarePrioritara,
			boolean nevoiSpeciale) {
		this.apartenenta = apartenenta;
		this.nume = nume;
		this.varsta = varsta;
		bilet = new Bilet(tipBilet, imbarcarePrioritara, nevoiSpeciale);
	}
	
	/**
	 * verifica daca un numar se afla intre 2 margini
	 * @param x int numarul de verificat
	 * @param lower int marginea inferioara
	 * @param upper int marginea superioara
	 * @return boolean returneaza adevarat sau fals
	 */
	public static boolean isBetween(int x, int lower, int upper) {
		  return lower <= x && x < upper;
	}
	
	/**
	 * @return int functia calculeaza punctajul de persoana
	 */
	public int punctePersoana(){
		int puncte = 0;
		if(isBetween(varsta, 0, 2))
			puncte += 20;
		else
			if(isBetween(varsta, 2, 5))
				puncte += 10;
			else
				if(isBetween(varsta, 5, 10))
					puncte += 5;
				else
					if(isBetween(varsta, 10, 60))
						puncte += 0;
					else
						puncte += 15;
		switch(bilet.tipBilet) {
		  case 'e':
		    break;
		  case 'p':
		    puncte += 20;
		    break;
		  case 'b':
		    puncte += 35;
		}
		if(bilet.imbarcarePrioritara)
			puncte += 30;
		if(bilet.nevoiSpeciale)
			puncte += 100;
		return puncte;
	}
}