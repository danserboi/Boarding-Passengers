SERBOI FLOREA-DAN 325CB
Pentru simplitate si pentru a avea acces de oriunde, am ales ca modificatorul public sa fie folosit in toate clasele.
Tema este compusa din 8 clase dupa cum urmeaza:
- Clasa Tema1 este clasa principala, care contine metoda main. Aici se prelucreaza input-ul si se obtine rezultatul final.In metoda main se efectuaza citirea din fisier, efectuarea operatiilor si scrierea in noul fisier. Se creeaza vectorul de persoane, iar apoi vectorii de familii, grupuri si singuri. In final se fac operatii cu coada de prioritate.
- Clasa Bilet care are ca atribute tipul de bilet si daca are sau nu mentiunile imbarcare prioritara si nevoi speciale. 
- Clasa Persoana are ca atribute entitatea de care apartine, numele, varsta si biletul. Aici este prezenta metoda care calculeaza punctele de prioritate aferente persoanei.
- Clasa Pasager are 2 atribute : entitatea pe care o reprezinta si prioritatea. Aici este prezenta metoda care adauga la prioritatea totala prioritatea unei persoane din entitate.
- Clasa Familie mosteneste Pasager si are 10 puncte de prioritate in plus.
- Clasa Grup mosteneste Pasager si are 5 puncte de prioritate in plus.
- Clasa Singur mosteneste Pasager si nu are niciun punct de prioritate in plus.
- Clasa CoadaDePrioritate Se ocupa de operatiile cozii de prioritate si are ca atribute: printWriter-ul, dimHeap - numarul de elemente curent, nrMaxElemente - numarul maxim de elemente, heap-ul(a fost implementat cu vector pentru eficienta si parcurgerea mai usoara). Aici sunt prezente metodele : cea care insereaza un Pasager in coada de prioritate, cea care imbarcheaza un Pasager, cea care afiseaza in preordine coada de prioritate si cea care sterge/repozitioneaza Pasager.
