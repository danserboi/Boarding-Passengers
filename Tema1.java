import java.io.*;

/**
 * Clasa Tema1 este clasa principala, care contine metoda main. Aici se prelucreaza input-ul si se obtine rezultatul final. 
 * @author Serboi Florea-Dan 325CB
 */
public class Tema1 {
	
	/**
	 * In metoda main se efectuaza citirea din fisier, efectuarea operatiilor si scrierea in noul fisier.
	 * @param args argumentul functiei main
	 * @throws Exception arunc exceptiile.
	 */
	public static void main(String[] args) throws Exception{
		/**deschidem fisierul si citim linie cu linie**/
		File input = new File("queue.in");
	    File output = new File("queue.out");
	    PrintWriter printWriter = new PrintWriter(output);
		BufferedReader buffer = new BufferedReader(new FileReader(input));   
		/**citim prima linie si extragem numarul de persoane**/
		String linie = buffer.readLine();
		int numarPersoane = Integer.parseInt(linie), numarFam = 0, numarGrup = 0, numarSing = 0, i;
		/**cream vectorul de persoane**/
		Persoana[] persoane = new Persoana[numarPersoane];
		/**citim detaliile despre persoane**/
		for(i = 0; i < numarPersoane; i++){
			linie = buffer.readLine();
			/**extragem campurile persoanei**/
			String[] campuri = linie.split(" ");
			/**introducem persoana in vectorul de persoane**/
			persoane[i] = new Persoana(campuri[0], campuri[1], Integer.parseInt(campuri[2]), campuri[3].charAt(0), Boolean.parseBoolean(campuri[4]), Boolean.parseBoolean(campuri[5]));
			/**extragem index-ul si calculam numar de familii, grupuri si de singuri**/
			int index = Integer.parseInt(persoane[i].apartenenta.substring(1));
			if(campuri[0].charAt(0) == 'f' && index > numarFam)
				numarFam = index;
	        if(campuri[0].charAt(0) == 'g' && index > numarGrup)
	        	numarGrup = index;
	        if(campuri[0].charAt(0) == 's' && index > numarSing)
	        	numarSing = index;
		}
		/**cream vectorii de familii, grupuri si de singuri**/
		Pasager[] fam = new Familie[numarFam], grup = new Grup[numarGrup], sing = new Singur[numarSing];
		/**parcurgem persoanele, cream entitatea din care fac parte si adaugam punctele de prioritate aferente**/
		for(i = 0; i < numarPersoane; i++){
			int index = Integer.parseInt(persoane[i].apartenenta.substring(1)) - 1;			
			if(persoane[i].apartenenta.charAt(0) == 'f'){
				if(fam[index] instanceof Familie)
					fam[index].addPriority(persoane[i].punctePersoana());
				else{
					fam[index] = new Familie(persoane[i].apartenenta);
					fam[index].addPriority(persoane[i].punctePersoana());
				}
			}
			if(persoane[i].apartenenta.charAt(0) == 'g'){
				if(grup[index] instanceof Grup)
					grup[index].addPriority(persoane[i].punctePersoana());
				else{
					grup[index] = new Grup(persoane[i].apartenenta);
					grup[index].addPriority(persoane[i].punctePersoana());
				}
			}
			if(persoane[i].apartenenta.charAt(0) == 's'){
				if(sing[index] instanceof Singur)
					sing[index].addPriority(persoane[i].punctePersoana());
				else{
					sing[index] = new Singur(persoane[i].apartenenta);
					sing[index].addPriority(persoane[i].punctePersoana());
				}
			}
		}
		/**cream coada de prioritate**/
		CoadaDePrioritate coada = new CoadaDePrioritate(numarFam + numarGrup + numarSing, printWriter);
		int amIntalnitList = 0;
		/** citim linie cu linie operatiile**/
		while ((linie = buffer.readLine()) != null) {
			/**extragem campurile unei operatii dupa care efectuam operatia**/
			String[] campuri = linie.split(" ");
			if(campuri[0].equals("insert")){
				int index = Integer.parseInt(campuri[1].substring(1)) - 1;	 
				if(campuri[1].charAt(0) == 'f')
					coada.insert(fam[index], fam[index].priority);
				if(campuri[1].charAt(0) == 'g')
					coada.insert(grup[index], grup[index].priority);
				if(campuri[1].charAt(0) == 's')
					coada.insert(sing[index], sing[index].priority);
			}
			if(campuri[0].equals("list")){
				if(amIntalnitList == 1)
					printWriter.print("\r\n");
				coada.list();
				amIntalnitList = 1;
			}
			if(campuri[0].equals("embark")){
				coada.embark();
			}
			if(campuri[0].equals("delete")){
				int prioritatePierduta = 0, indexPas = 0;
				Pasager p_elim = null;
				/**cautam in coada de prioritate elementul pt care se efectueaza delete si il retinem in p_elim**/
				for(i = 1; i <= coada.dimHeap; i++){
					if(coada.heap[i].entitate.equals(campuri[1])){
						indexPas = i;
						p_elim = coada.heap[i];
						break;
					}
				}
				/**daca se sterge doar o persoana din entitate doar scadem prioritatea aferenta**/
				if(campuri.length == 3){
					for(int j = 0; j < numarPersoane; j++)
						if(persoane[j].apartenenta.equals(campuri[1]) && persoane[j].nume.equals(campuri[2]))
							prioritatePierduta = persoane[j].punctePersoana();
					coada.heap[indexPas].priority -= prioritatePierduta;
				}
				/**altfel, daca stergem tot grupul prioritatea devine 0**/
				else
					coada.heap[indexPas].priority = 0;
				coada.delete(p_elim);
			}
		}
		printWriter.close();
	}	
}