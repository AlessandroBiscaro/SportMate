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

## Testing


### Indice

1. [Introduzione](#Introduzione)
2. [Test unitari](#Test-unitari)
3. [Copertura del flusso di controllo](#Copertura-del-flusso-di-controllo)

### Introduzione
---

Come prescritto dalle pratiche di *eXtreme Programming*, si è optato per uno sviluppo basato sui test (*Test Driven Development - TDD*), lavorando in brevi iterazioni di aggiunta di nuovi casi di test e vericando che vengano eseguiti correttamente ad ogni aggiunta di codice sulla repository. 
Inoltre, è stato scritto un *workflow* di *GitHub Actions* per automatizzare la compilazione del progetto e l'esecuzione dei test unitari sul codice ad ogni *pull request* o ad ogni écommit* sul *branch main* oppure ad ogni nuovo *commit* nella *repository*. 
In particolare, il *workflow* viene eseguito su una macchina virtuale *in-cloud* che monta i tre sistemi operativi più diffusi sul mercato (Linux Ubuntu 24.10, MacOs 14, Windows 11) e si occupa di:
- rimuovere eventuali file generati da *job* precedenti;
- compilare i progetti **SportMateDBLayer**, **SportMateBusinessLayer** e ***SportMatePresentationLayer***;
- compilare il codice sorgente dei casi di test unitari;
- eseguire i test unitari;
- impacchettare il codice compilato di **SportMateDBLayer** e **SportMateBusinessLayer** in formato JAR ed installarlo all'interno della *repository* locale, in modo che siano utilizzabili come dipendenze all'interno del progetto.
In questo modo, il progetto viene continuamente mantenuto integrato, così come prescritto dalle *best practices* di XP.
<br/>

### Test unitari
---
I casi di test scritti con *Junit4* sono stati inseriti all'interno delle cartelle *src/test/java/* dei progetti ***SportMateDBLayer*** e ***SportMateBusinessLayer*** e corrispondono essenzialmente alle classi presenti all'interno dei *package* dei progetti. 
Per ***SportMateDBLayer*** sono stati realizzati test unitari per verificare il corretto funzionamento dei metodi messi a disposizione dal livello, tra cui i metodi apriConnessione(), chiudiConnessione(), getConnectionDetails() e getContext() della classe *SportMateDB*, per verificare la corretta gestione del database da parte del progetto. <br/> Per ***SportMateBusinessLayer*** si è desiderato verificare la logica di business relativa e il corretto funzionamento delle primitive di visualizzazione, inserimento e modifica dei dati. Ad esempio per la classe *UtentiService*, si sono verificate:
- la creazione di un utente di prova;
- la modifica dei dati personali dell'utente
- la ricarica del credito SportMate associato al profilo personale dell'utente;
- il recupero delle informazioni personale dell'utente a partire dal suo *username*;
- la verifica dell'univocità del numero di telefono e della *mail* al momento della registrazione, come richiesto dai requisiti dell'applicazione;
- l'eliminazione dell'utente di test generato.
<br/>

Al contrario, per la classe *PartiteService*, i test hanno riguardato:
- la creazione di una nuova partita privata, utilizzando dati di prova riguardo il centro sportivo, il gestore e l'utente organizzatore;
- la creazione di una nuova partita pubblica, utilizzando dati di prova riguardo il centro sportivo, il gestore e l'utente organizzatore;
- la ricerca delle partite private organizzate con *SportMate*;
- la ricerca di partite pubbliche con posti ancora disponibili a cui un'utente finale potrebbe unirsi;
- l'eliminazione di partite pubbliche e private
<br/>
Invece, per ***SportMatePresentationLayer***, non si è trovata rilevante la valutazione del codice che genera l'interfaccia grafica.
<br/>

###Copertura del flusso di controllo
---
Per valutare l'adeguatezza dei test unitari in termini di copertura del prodotto da testare, è stato utilizzato il tool *Eclipse Eclemma*. Nonostante, le *best-practices* di XP prescrivano l'ottenimento di una copertura prossima al 100%, questa non è stata raggiunta in ***SportMateBusinessLayer*** a causa della presenza delle classi del package *sportmateinc.sportmatebusinesslayergenerated*. Di seguito sono riportati i risultati della copertura dei test JUnit. 
  <p align="center"  >
      <img src="../Immagini/SportMate3MottoSmall.PNG" width="250" />   
 </p> 
