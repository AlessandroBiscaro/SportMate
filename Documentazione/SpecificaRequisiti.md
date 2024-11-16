
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

## Specifica dei Requisiti

<br/>

### Indice

1. [Introduzione](#1---Introduzione)<br/>
1.1 [Obiettivi e scopo](#1.1---Obiettivi-e-scopo)<br/>
1.2 [Definizioni, acronimi e termini](#1.2---Definizioni-acronimi-e-termini)
2. [Descrizione generale](#2---Descrizione-generale)<br/>
2.1 [Funzioni del prodotto](#2.1---Funzioni-del-prodotto)<br/>
2.2 [Tecniche di elicitazione dei requisiti](#2.2---Tecniche-di-elicitazione-dei-requisiti)<br/>
2.3 [Caratteristiche dell'utente](#2.3---Caratteristiche-dell'utente)<br/>
2.4 [Vincoli](#2.4---Vincoli) <br/>
3. [Requisiti specifici](#3---Requisiti-specifici)<br/>
3.1 [Requisiti funzionali](#3.1---Requisiti-funzionali)<br/>
3.2 [Classificazione MoSCoW](#3.2---Classificazione-MoSCoW)<br/>
3.3 [Requisiti di prestazione](#3.3---Requisiti-di-prestazione)<br/>
3.4 [Attributi del sistema software](#3.4---Attributi-del-sistema-software)<br/>
3.5 [Altri requisiti](#3.5---Altri-requisiti)<br/>


### 1 - Introduzione
---

#### 1.1 - Obiettivi e scopo
SportMate ha come obiettivo la realizzazione di un sistema innovativo di prenotazione campi per calcio a 5, calcio a 7 e basket 3v3, che permetta agli utenti di consultare la disponibilità delle strutture sportive e organizzare partite pubbliche o private. Questo sistema di gestione delle prenotazioni elimina i tradizionali problemi relativi all'organizzazione di partite, tra cui la necessità di trovare giocatori per una partita dell'ultimo minuto.

#### 1.2 - Definizioni, acronimi e termini
##### Termini e definizioni:
- **Partita pubblica**: incontro sportivo organizzato attraverso l'applicazione aperto a tutti gli utenti della piattaforma, fino ad esaurimento posti
- **Partita privata**: incontro sportivo organizzato attraverso l'applicazione, basato sull' invito da parte dell'utente organizzatore
- **Utente organizzatore**: utente dell'applicazione proprietario di una partita pubblica o privata
<br/>
- **Utente finale**: rappresenta l'insieme di utenti che usufruiscono direttamente dei servizi forniti dall'applicazone, quali la prenotazione e l'organizzazione di partite private e pubbliche.
- **Gestore**: rappresenta l'insieme di utenti che identificano i proprietari dei centri sportivi o campi disponibili alla prenotazione attraverso l'applicazione.<br/>

##### Acronimi:
- **GUI**: *Graphical User Interface*
- **DBMS**: *DataBase Management System*

### 2 - Descrizione generale
---

#### 2.1 - Funzioni del prodotto
Questo software innovativo fornisce due differenti categorie di funzionalità: 
- funzionalità attraverso cui l'utente può creare, ricercare e prenotare partite private o pubbliche
- funzionalità che consentono ai proprietari dei centri sportivi di gestire la disponibilità dei campi e le prenotazioni effettuate dagli utenti.<br/>

Gli utenti del sistema possono selezionare una delle funzionalità elencate nella sezione [Requisiti funzionali](#Requisiti-funzionali) attraverso il menù laterale dell'interfaccia utente (GUI).

#### 2.2 - Tecniche di elicitazione dei requisiti
La principale fonte di informazione per il processo di elicitazione dei requisiti sono gli utenti finali dell'applicazione. Pertanto abbiamo coinvolto amici e colleghi, che identificano un campione rappresentativo dell'insieme degli utenti finali, grazie ai quali ci è stato possibile raccogliere requisiti realistici e concreti su ciò che vorrebbero trovare in un'applicazione come SportMate. <br/> Un'altra fonte di informazione per la fase di ingegneria dei requisiti sono i gestori, tramite i quali abbiamo potuto identificare funzionalità chiave per ottimizzare le prenotazioni e l'occupazione dei campi.
La principale tecnica di elicitazione dei requisiti utilizzata con gli utenti finali è l'*intervista aperta*. <br/> Abbiamo invece preferito un'analisi basata su scenari creati artificialmente e discussi con i gestori.


#### 2.3 - Caratteristiche dell'utente

I gestori saranno formati riguardo al funzionamento del sistema software, come riportato nella sezione [Requisiti funzionali](#3.1---Requisiti-funzionali).<br/> Gli utenti finali useranno occasionalmente SportMate, non necessitando di alcuna conoscenza specifica sul sistema.

#### 2.4 - Vincoli

Gli utenti finali potranno solo organizzare, ricercare e prenotare una partita pubblica o privata, senza poter interferire con la gestione delle strutture sportive. <br/> Le funzionalità di amministrazione riservate ai gestori saranno offerte solo attraverso un'interfaccia dedicata e protetta da password.<br/>
SportMate, in questa sua prima versione, sarà disponibile e utilizzabile senza funzionalità di rete, implementando quindi un *embedded DBMS* come richiesto all'interno dei requisiti di questo progetto.


### 3 - Requisiti specifici

#### 3.1 - Requisiti funzionali


| ID    | REQUISITO                         |
| ----- | --------------------------------- |
| FUN.1 | L'utente organizzatore avrà la possibilità di organizzare una partita pubblica, specificando la tipologia di incontro, l'orario, il centro sportivo, il numero di giocatori già presenti e la modalità di pagamento|
|FUN.2| L'utente organizzatore avrà la possibilità di organizzare una partita privata, specificando la tipologia di incontro, l'orario, il centro sportivo e la modalità di pagamento|
|FUN.3.1| L'utente finale avrà la possibilità di ricercare i campi disponibili, consultando l'elenco presente nell'applicazione |
|FUN.3.2|L'utente finale avrà la possibilità di ricercare i campi disponibili, consultando la mappa dei centri affiliati|
|FUN.4|L'utente finale avrà la possibilità di unirsi ad una partita pubblica organizzata da un altro utente, tramite l'interfaccia dedicata|
|FUN.5|L'utente organizzatore avrà la possibilità di selezionare la modalità di pagamento desiderata al momento della prenotazione, scegliendo tra il pagamento presso la struttura e l'utilizzo del credito ricaricabile collegato al profilo personale|
|FUN.6|L'utente avrà la possibilità di monitorare e ricaricare il credito associato al profilo personale|
|FUN.7|L'utente avrà la possibilità di esprimere il proprio *feedback* riguardo la sua esperienza d'uso di SportMate|
|FUN.8| Il gestore avrà la possibilità di registrare il proprio centro sportivo su SportMate, indicando nome commerciale, indirizzo, dati di contatto, servizi disponibili, orari di apertura e credenziali di accesso|
|FUN.9| Il gestore avrà la possibilità di inserire le disponibilità della propria struttura, indicando fascia oraria, tipologia di campo, prezzo ed eventuali servizi aggiuntivi |
|FUN.10| Il gestore avrà la possibilità di visualizzare l'elenco delle fasce orarie prenotate e ancora disponibili del suo centro sportivo |
|FUN.11|L'utente avrà la possibilità di registrarsi alla piattaforma, indicando dati personali, mail e password |
|FUN.12|L'utente avrà la possibilità di interagire con gli altri partecipanti di una partita pubblica a cui si è unito tramite una chat in tempo reale|
|FUN.13|L'utente organizzatore avrà la possibilità di interagire con il gestore del centro sportivo tramite una chat privata in tempo reale|
|FUN.14|L'utente organizzatore avrà la possibilità di generare le squadre per l'incontro, in maniera casuale o scegliendo autonomamente sulla base del livello dei giocatori, specificando colori della divisa e caricando poi il risultato finale|
|FUN.15|L'utente avrà la possibilità di confrontarsi con i membri della sua squadra per la partita attraverso una chat di gruppo in tempo reale|


#### 3.2 - Classificazione MoSCoW


| Must Have | Should Have  |  Could Have | Won't Have |
| :--------: | :--------: | :--: | :--------: | 
| FUN.1     | FUN.3.2 | FUN.6 |   FUN.12   |
|FUN.2|FUN.5|FUN.7|FUN.13|
|FUN.3.1|FUN.10||FUN.14|
|FUN.4|||FUN.15|
|FUN.8|
|FUN.9|
|FUN.11|


#### 3.3 - Requisiti di prestazione

Il sistema software necessita, per la sua corretta esecuzione, dei seguenti requisiti minimi:
- Sistema operativo: Windows 10 o versioni successive; OS X 10.8.3 o versioni successive
- RAM: almeno 1 GB per 32 bit; 2 GB per 64 bit
- Spazio di archiviazione: almeno 128 MB 
:::danger
Aggiornare dopo creazione DBMS!!
:::
- Processore: almeno 1 GHz come frequenza di clock
- Browser Internet: Microsoft Edge, Google Chrome, Mozilla Firefox, Safari


#### 3.4 - Attributi del sistema software

I seguenti fattori di qualità, definiti all'interno della tassonomia di McCall, faranno da base per l'intero processo di sviluppo software:
- Correttezza: misura in cui il programma soddisfa i suoi requisiti e soddisfa gli obiettivi della missione dell'utente.
- Affidabilità: misura in cui ci si può aspettare che il programma svolga la funzione prevista con la precisione richiesta.
- Integrità: misura in cui è possibile controllare l'accesso al software o ai dati da parte di persone non autorizzare.
- Usabilità: sforzo richiesto per apprendere e utilizzare il programma.
- Manutenibilità: sforzo necessario per individuare e correggere gli errori presenti nel sistema una volta operativo.
- Flessibilità: sforzo necessario per modificare il sistema una volta operativo.
