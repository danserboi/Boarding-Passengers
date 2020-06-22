/**
 * Pasager are 2 atribute : entitatea pe care o reprezinta si prioritatea.
 * @author Serboi Florea-Dan 325CB
 */
public class Pasager {
	/**
	 * id-ul entitatii
	 */
	public String entitate;
	/**
	 * prioritatea entitatii
	 */
	public int priority;
	/**constructor fara parametri**/
	public Pasager() {
		entitate = null;
		priority = 0;
	}
	/**
	 * constructor doar cu atributul entitate
	 * @param entitate String id entitate
	 */
	public Pasager(String entitate){
		this.entitate = entitate;
		priority = 0;
	}
	/**
	 * constructor cu ambele atribute
     * @param entitate String id entitate
     * @param priority int prioritatea entitatii
     */
    public Pasager(String entitate, int priority){
        this.entitate = entitate;
        this.priority = priority; 
    }
    /**
     * functia adauga puncte de prioritate
	 * @param priority int prioritatea adaugata
	 */
	public void addPriority(int priority){
		this.priority += priority;
	}
}