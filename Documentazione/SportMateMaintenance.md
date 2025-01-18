<p>
       <h1 align="center">SportMate </h1> 
</p>

  <p align="center"  >
      <img src="../Immagini/SportMate3MottoSmall.PNG" width="250" />   
 </p> 
 <p align="center"> <em> Università degli Studi di Bergamo <br/>
Ingegneria Informatica <br/>
Biscaro Alessandro 1087892 <br/>
Fabbris Thomas 1086063 <br/>
Gambirasio Lorenzo Umberto 1087441 </em>
</p >

## Software Maintenance


### Indice

1. [Introduzione](#Introduzione)
2. [Categorie di manutenzione](#Categorie-di-manutenzione)
3. [Refactoring](#Refactoring)

<br/>

### Introduzione
---

Avendo adottato un metodo di sviluppo agile, le attività di manutenzione e di adattamento del software sono risultate implicite e integrate durante tutta la durata dello sviluppo.

<br/>

### Categorie di manutenzione
---

La quasi totalità dello sforzo di manutenzione eseguito ha riguardato la manutenzione correttiva e la manutenzione perfettiva: spesso, abbiamo dovuto correggere una funzionalità precedentemente implementata al fine di renderla coerente con quanto dichiarato in sede di specifica dei requisiti oppure al fine di correggere comportamenti anomali.
Per quanto riguarda la manutenzione preventiva, abbiamo corredato il codice di commenti *JavaDoc*, in modo da avere una documentazione sempre aggiornata riguardo il progetto, e abbiamo costantemente migliorato i documenti e i diagrammi UML prodotti con l'obiettivo di eliminare contraddizioni, riferimenti in avanti o parti specificate in modo ambiguo. 
Al contrario, sono state totalmente assenti attività di manutenzione adattiva.

<br/>

### Refactoring 
---

L'attività di manutenzione che ha occupato la maggior parte del tempo è stato il *Refactoring*, una tecnica disciplinata di ristrutturazione del codice esistente, che altera la struttura interna del sistema senza modificare il comportamento esterno. 
Le principali tecniche di refactoring utilizzate sono: 
- Rinomina di variabili e metodi per una maggiore comprensione del codice e una maggiore facilità nella correzione di errori
- Rimozione di *dead code* e codice duplicato
- Estrazione di variabili per una migliore facilità di lettura e comprensione del codice sorgente
- Estrazione di metodi con il compito di raggruppare blocchi di codice correlati tra di loro in nuovi metodi
- Semplificazione di espressioni condizionali complesse

Inoltre, parte del codice generato dal web framework *Vaadin* per la creazione dell'interfaccia grafica è stato ristrutturato, passando così da *spaghetti-code* a codice strutturato, facilitando la lettura e comprensione delle classi generate e semplificando le correzioni effettuate sul codice.

Infine, per le attività di manutenzioni relative al codice, abbiamo proceduto come segue:
- Isolamento della parte del sistema (componenti e classi) oggetto della modifica
- Adattamento dei componenti precedentemente selezionati per accogliere la modifica
- Esecuzione dell'intera *suite* di test sul progetto una volta apportata la modifica

<br/>