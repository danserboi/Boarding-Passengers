/**
 * Singur mosteneste Pasager si nu are niciun punct de prioritate in plus.
 * @author Serboi Florea-Dan 325CB
 */
public class Singur extends Pasager{
	/**constructor singur fara parametri**/
	public Singur(){
		super();
	}
	/**
	 * constructor singur doar cu parametrul entitate
	 * @param entitate id entitate
	 */
	public Singur(String entitate){
		super(entitate);
	}
}
