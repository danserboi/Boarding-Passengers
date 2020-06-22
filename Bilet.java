/**
 * Biletul are ca atribute tipul de bilet si daca are sau nu mentiunile imbarcare prioritara si nevoi speciale.
 * @author Serboi Florea-Dan 325CB
 */
public class Bilet {
	/**
	 * tipul biletului : business, premium, economic
	 */
	public char tipBilet;
	/**
	 * are sau nu imbarcare prioritara
	 */
	public boolean imbarcarePrioritara;
	/**
	 * are sau nu nevoi speciale
	 */
	public boolean nevoiSpeciale;
	/**constructor fara parametri**/
	public Bilet() {
	}
	/**
	 * constructor cu toate atributele
	 * @param tipBilet char tipul biletului : business, premium, economic
	 * @param imbarcarePrioritara boolean are sau nu imbarcare prioritara
	 * @param nevoiSpeciale boolean are sau nu nevoi speciale
	 */
	public Bilet(char tipBilet, boolean imbarcarePrioritara, boolean nevoiSpeciale) {
		this.tipBilet = tipBilet;
		this.imbarcarePrioritara = imbarcarePrioritara;
		this.nevoiSpeciale = nevoiSpeciale;
	}
}
