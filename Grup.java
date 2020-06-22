/**
 * Grup mosteneste Pasager si are 5 puncte de prioritate in plus.
 * @author Serboi Florea-Dan 325CB
 */
public class Grup extends Pasager{
	/**constructor grup fara parametri**/
	public Grup(){
		super();
		priority = priority + 5;
	}
	/**
	 * constructor grup doar cu parametrul entitate
	 * @param entitate id entitate
	 */
	public Grup(String entitate){
		super(entitate);
		priority = priority + 5;
	}
}
