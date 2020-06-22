/**
 * Familia mosteneste Pasager si are 10 puncte de prioritate in plus.
 * @author Serboi Florea-Dan 325CB
 */
public class Familie extends Pasager{
	/**constructor familie fara parametri**/
	public Familie() {
		super();
		priority = priority + 10;
	}
	/**
	 * constructor familie doar cu parametrul entitate
	 * @param entitate id entitate
	 */
	public Familie(String entitate){
		super(entitate);
		priority = priority + 10;
	}

}
