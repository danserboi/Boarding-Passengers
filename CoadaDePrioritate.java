import java.io.PrintWriter;

/**
 * Se ocupa de operatiile cozii de prioritate si are ca atribute: printWriter-ul, dimHeap - numarul de elemente curent, nrMaxElemente - numarul maxim de elemente, heap-ul. 
 * @author Serboi Florea-Dan 325CB
 */
public class CoadaDePrioritate {
	/**
	 * Cu ajutorul printWriter-ului scriem in fisierul de output.
	 */
	PrintWriter printWriter;
	/**
	 * numarul actual de elemente introduse in coada de prioritate
	 */
	int dimHeap;
	/**
	 * numarul maxim de elemente
	 */
	int nrMaxElemente;
	/**
	 * coada de prioritate
	 */
	Pasager[] heap;
	/** constructor fara parametri**/
	public CoadaDePrioritate(){
	}
    /**
     * constructor de coada de prioritate cu toti parametri
     * @param nr int numarul maxim de elemente
     * @param printWriter PrintWriter unde scriem rezultatul
     */
    public CoadaDePrioritate(int nr, PrintWriter printWriter){    
        this.printWriter = printWriter;
    	dimHeap = 0;
    	nrMaxElemente = nr + 1;
        heap = new Pasager[nrMaxElemente];
    }
    /** 
     * functia insereaza Pasager in coada de prioritate
     * @param p Pasager pasagerul de inserat
     * @param priority int prioritatea pasagerului
     */
    public void insert(Pasager p, int priority){
    	/**crestem dimensiunea heap-ului**/
    	dimHeap++;
    	/**initial introducem elementul pe ultimul rand cat mai in dreapta**/
        int curent = dimHeap;
    	heap[curent] = p;
    	/**cat timp nu suntem la radacina si cat timp prioritatea copilului e mai mica decat a elementului de inserat, interschimbam elementele si urcam in arbore*/
        while (curent != 1 && heap[curent/2].priority < heap[curent].priority){
        	Pasager aux = heap[curent];
            heap[curent] = heap[curent/2];
            heap[curent/2] = aux;
            curent = curent/2;
        }  
    }
    /** 
     * functia imbarcheaza Pasager
     */
    public void embark(){
    	if(dimHeap > 0){
	    	/**pornim de la radacina**/
	    	int parinte = 1, copil = 2;
	        /**ultimul element va ajunge initial in radacina dupa care prelucram arbore ca sa respecte regula**/
	    	heap[parinte] = heap[dimHeap];
	        /**elementul din radacina iese, astfel scadem dimensiunea heap-ului**/
	    	dimHeap--;
	    	/**cat timp nu iesim din arbore**/
	        while (dimHeap >= copil){
	        	/**comparatia o fac cu copilul care are valoarea mai mare**/
	            if (dimHeap > copil && heap[copil + 1].priority > heap[copil].priority)
	                copil++;
	            /**daca copii au valoarea mai mica decat a elementului curent, inseamna ca i-am gasit pozitia si ma opresc**/
	            if (heap[copil].priority <= heap[parinte].priority)
	                break;
	            /**interschimbam valorile si coboram in arbore**/
	            Pasager aux = heap[parinte];
	            heap[parinte] = heap[copil];
	            heap[copil] = aux;
	            parinte = copil;
	            copil = copil * 2;
	        }
    	}
    }
    /**functia afiseaza coada de prioritate**/
    public void list(){
    	list_recursiv(1);
    }
    /**
     * functie recursiva auxiliara pentru a afisa coada de prioritate
     * @param idx int index-ul in heap
     */
    public void list_recursiv(int idx){
    	//**ma opresc cand depasesc dimensiunea heap-ului**/
    	if(idx > dimHeap)
    		return;
    	if(idx != 1)
    		printWriter.print(" ");
    	printWriter.print(heap[idx].entitate);
    	list_recursiv(2*idx);
    	list_recursiv(2*idx + 1);
    }
    /**
     * functia sterge o entitate sau repozitioneaza entitatea in coada de prioritate in cazul unei persoane sterse, in functie de punctele de prioritate aferente
     * @param p Pasager elimina/repozitioneaza Pasager
     */
    public void delete(Pasager p){
    	/**daca prioritatea este 0, inseamna ca trebuie eliminata complet entitatea**/
    	if(p.priority == 0){
    		/**cautam pozitia pasagerului in coada de prioritate**/
	    	int parinte = 1;
	        while(!(heap[parinte].entitate.equals(p.entitate)) && parinte <= dimHeap)
	        	parinte++;
	        /**construim pozitia copilului**/
	        int copil = parinte * 2;
	        /**ultimul element va ajunge in pozitia elementului eliminat**/
	        heap[parinte] = heap[dimHeap];
	        /**dimensiunea scade deoarece eliminam elementul**/
	        dimHeap--;
	        while (dimHeap >= copil){
	        	/**comparatia o fac cu copilul care are valoarea mai mare**/
	            if (dimHeap > copil && heap[copil].priority < heap[copil + 1].priority)
	                copil++;
	            /**daca copiii au valoarea mai mica decat a elementului curent, inseamna ca i-am gasit pozitia si ma opresc**/
	            if (heap[copil].priority <= heap[parinte].priority)
	                break;
	            /**interschimbam valorile si coboram in arbore**/
	            Pasager aux = heap[parinte];
	            heap[parinte] = heap[copil];
	            heap[copil] = aux;
	            parinte = copil;
	            copil = copil * 2;
	        }
    	}
    	/**in acest caz, este eliminat doar o persoana dintr-un pasager si i se modifica astfel prioritatea si, posibil, implicit, si pozitia**/
    	else{
    		/**cautam pozitia pasagerului in coada de prioritate**/
	    	int parinte = 1;
	        while(!(heap[parinte].entitate.equals(p.entitate)) && parinte <= dimHeap)
	        	parinte++;
	        int copil = parinte * 2;
	        while (dimHeap >= copil){
	        	/**comparatia o fac cu copilul care are valoarea mai mare**/
	            if (dimHeap > copil && heap[copil].priority < heap[copil + 1].priority)
	                copil++;
	            /**daca copiii au valoarea mai mica decat a parintelui, inseamna ca i-am gasit pozitia si ma opresc**/
	            if (heap[copil].priority <= heap[parinte].priority)
	                break;
	            /**interschimbam valorile si coboram in arbore**/
	            Pasager aux = heap[parinte];
	            heap[parinte] = heap[copil];
	            heap[copil] = aux;
	            parinte = copil;
	            copil = copil * 2;
	        }
    	}
    }
}