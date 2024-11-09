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

  
## ProjectPlan

<br/>

### Indice

1. [Introduzione](#Introduzione)
2. [Modello di processo](#Modello-di-processo)
3. [Organizzazione del progetto](#Organizzazione-del-progetto)
4. [Standard, linee guida e procedure](<#Standard,-linee-guida-e-procedure>)
5. [Attività di gestione](#Attività-di-gestione)
6. [Rischi](#Rischi)
7. [Personale](#Personale)
8. [Metodi e tecniche](#Metodi-e-tecniche)
9. [Garanzia di qualità](#Garanzia-di-qualità)
10. [Workpackages](#Workpackages)
11. [Risorse](#Risorse)
12. [Budget e programma](#Budget-e-programma)
13. [Cambiamenti](#Cambiamenti)
14. [Consegna](#Consegna)

<br/>

### Introduzione
---

SportMate ha come obiettivo la realizzazione di un sistema innovativo di prenotazione campi per calcio a 5, calcio a 7 e basket 3v3, che permetta agli utenti di consultare la disponibilità delle strutture sportive e organizzare partite pubbliche o private. Questo sistema di gestione delle prenotazioni elimina la necessità di effettuare chiamate telefoniche per le prenotazioni o il problema di trovare i giocatori per una partita dell'ultimo minuto.

<br/>


### Modello di processo
---

Il progetto userà come ciclo di vita del software *Extreme Programming* (XP), un metodo agile puro basato su una serie di *best practices* consolidate nel tempo, che mirano a ottenere un sistema sempre in esecuzione attraverso un approccio incrementale e un processo di integrazione continua del codice. Durante lo sviluppo del sistema software, saranno seguite tutte le linee guida di XP, in particolare la proprietà collettiva del codice, l'adozione di un ritmo sostenibile e la programmazione in coppia. 

<br/>

### Organizzazione del progetto
---

L'organizzazione del team di sviluppo scelta corrisponde ad un team agile di piccole dimensioni, orientato alla persona. Abbiamo prediletto brevi canali di comunicazione, senza ricorrere a riunioni formali, e incontri in presenza, durante i quali abbiamo avuto l'occasione di lavorare insieme nella stessa stanza. All'interno del team, non sono stati definiti ruoli o gerarchie di qualsiasi tipo, in quanto riteniamo che la qualità sia un *must* e che siamo tutti equamente responsabili di offrire un progetto software di qualità. 
Come discusso nella sezione [Personale](#Personale), abbiamo optato per un semplice assegnamento delle attività, seguendo un principio di decomposizione funzionale.

<br/>

### Standard, linee guida e procedure
---
- **Standard**: Il progetto segue le convenzioni per la programmazione Java come definite da *Oracle*.<br/> La documentazione verrà realizzata seguendo gli standard UML (*Unified Modeling Language*), per garantire una rappresentazione chiara e strutturata del sistema software.  <br/> Saranno adottate le linee guida definite da *IEEE 830* per la stesura della specifica dei requisiti.<br/>
- **Procedure**: le procedure seguite all'interno del team saranno:
    * Individuazione dei requisiti e stima delle tempistiche.
    * Realizzazione dei diagrammi UML a cui si ispirerà la stesura del codice.
    * Implementazione del codice.
    * Testing del sistema e verifica della qualità.
- **Linee guida**: le priorità dei requisiti saranno gestite secondo le regole MoSCoW.<br/> Come già specificato nella sezione [Modello di processo](#Modello-di-processo), verranno seguite le *best practices* di XP.

<br/>

### Attività di gestione
---
Le seguenti attività di gestione saranno definite per avere un controllo efficiente sull'intero progetto di sviluppo software e saranno guidate da obiettivi e priorità fissate:
- **Incontri di aggiornamento**: verranno fissati circa tre incontri alla settimana, durante i quali verrà discusso lo stato di avanzamento del progetto, il lavoro svolto con relativi risultati e questioni problematiche e le nuove sfide da affrontare, al fine di valutare il progresso e priorizzare i futuri obiettivi.
- **Utilizzo di Git e *hosting* su GitHub**: al fine di garantire la tracciabilità, il controllo sullo sviluppo del software e la gestione di tutti gli artefatti prodotti nel corso del progetto, saranno utilizzati Git come SCM (*Software Configuration Management*) e GitHub come servizio di *hosting* per la repository. <br/> Queste attività di gestione saranno integrate con lo svolgimento degli incontri di aggiornamento per ottenere un quadro completo dello stato di avanzamento del progetto e per valutare le attività svolte da ciascun membro del team.
- **Utilizzo della Kanban Board**: per una visualizzazione chiara del flusso di lavoro (*workflow*) e per rispettare il principio di limitazione del lavoro in corso, utilizzeremo una Kanban Board, una lavagna digitale suddivisa in righe e colonne, con note che rappresentano le attività o le cose da fare. Le colonne sulla board rappresentano lo stato del lavoro, come *Backlog, In Progress, Ready, In Review, Done*. Le note verranno spostate tra le colonne per ottenere aggiornamenti in tempo reale sull'avanzamento del progetto e consentire al team di monitorare il progresso.

<br/>

### Rischi
---
Durante lo sviluppo del sistema software, i potenziali rischi possono essere:
- **Rischi di compatibilità del browser**: potrebbero sorgere problemi di compatibilità dell'applicazione con  versioni di browser non supportate, che potrebbero limitare l'utilizzo del servizio da parte degli utenti. Futuri aggiornamenti dei browser potrebbero causare ulteriori problemi di compatibilità.
- **Rischio di mancanza di informazioni critiche**: a seguito della raccolta dei requisiti del progetto tramite interviste/colloqui con vari gestori di centri sportivi, alcune informazioni critiche potrebbero non essere state colte e richiedere ulteriori iterazioni dello sviluppo. 
- **Rischio di non consegnare il sistema completo entro la scadenza**
- **Rischio di perdita accidentale dei dati**: in caso di guasto dell'hardware si potrebbe verificare la perdita dei dati salvati, in quanto residenti su un *database embedded*.



<br/>

### Personale
---
Tutti i membri che compongono il gruppo saranno coinvolti attivamente in tutte le fasi del progetto. In particolare:
- Biscaro Alessandro si dedicherà maggiormente allo sviluppo della logica del programma ed allo sviluppo dell'interfaccia grafica; 
- Gambirasio Lorenzo si dedicherà alla fase di modellazione; 
- Fabbris Thomas si dedicherà alla fase di testing.

Le fasi di codifica e gestione di documentazione verranno condivise tra tutti i partecipanti.<br/> Saranno coinvolti collaboratori esterni al progetto, come tester del software in fase di sviluppo e gestori di impianti sportivi per la raccolta dei requisiti funzionali.

<br/>

### Metodi e tecniche
---
I metodi e le tecniche utilizzate durante le fasi di ingegneria dei requisiti, progettazione, implementazione e testing saranno:
- **Controllo della versione e della configurazione**: per il *versioning* del software adotteremo Git come SCM distribuito e GitHub come servizio di *hosting* della repository.
- **Documentazione Tecnica**: la documentazione tecnica, fondamentale per la fase di manutenzione, sarà prodotta usando Javadoc, per la generazione automatica della documentazione a partire dal codice sorgente. Questa scelta permetterà una comprensione più approfondita del codice, sviluppando una visione comune sul funzionamento dell'applicazione.
- **Scrittura dei test e determinazione delle milestone**: i test di unità saranno scritti utilizzando JUnit, per verificare e validare le milestone del progetto.
- **Ambiente di prova e apparecchiature**: presteremo particolare attenzione alla definizione dell'ambiente di prova e delle apparecchiature necessarie, in quanto la correttezza dei test influirà positivamente sulla qualità del software finale.
- **Pianificazione di test e procedure di accettazione**: l'ordine di integrazione e di test verrà indicato chiaramente, in modo da valutare correttamente ogni componente. Le procedure di test di accettazione saranno definite al fine di garantire una valutazione soddifacente delle funzionalità implementate.

<br/>

### Garanzia di qualità
---
I criteri che verranno presi in considerazione per valutare la qualità del sistema software sono:
- **Correttezza**: il grado di soddisfacimento degli obiettivi della missione dell'utente e delle specifiche del sistema sarà assicurato da continui test di utilizzo.
- **Affidabilità**: si porrà continua attenzione agli aspetti relativi alla stbilità e robustezza del sistema, al fine di garantire alte prestazioni se utilizzato in condizioni standard.
- **Integrità**: al fine di controllare l'accesso al software o ai dati da parte di persone non autorizzate, verrà usato un meccanismo di accesso definito basandosi sui concetti di ruolo e permesso (*role-based access control*).
- **Usabilità**: l'interfaccia utente sarà sviluppata con particolare focus sulla semplicità di apprendimento del programma da parte dell'utente, utilizzando un design semplice ma sempre adeguato.
- **Manutenibilità**: l'architettura del sistema verrà sviluppata minimizzando il grado di dipendenza tra i componenti, in modo da rendere le attività di correzione degli errori e inserimento di nuove funzionalità il più agevole possibile.

<br/>

### Workpackages
---
Il lavoro richiesto nelle vari fasi del progetto verrà suddiviso in attività assegnabili ai singoli membri del team.


<br/>

### Risorse
---
**Risorse per la programmazione e lo sviluppo**: per la creazione del progetto saranno utilizzati i software e tools elencati di seguito. 
- **Eclipse IDE**: un ambiente di sviluppo integrato *multi-platform* con supporto al linguaggio Java, utilizzato per la stesura del codice.
- **Maven**: uno strumento di gestione dei progetti software basati su Java e build automation.
- **Papyrus**: un tool open source utile per la creazione dei vari diagrammi UML.
- **SQLite**: una libreria software per implementare un *database embedded*, utile per gestire in modo efficiente i dati dell'applicazione.
- **HackMD**: un editor real-time e collaborativo, utile per la stesura di file markdown.
- **Vaadin**: un framework open source per applicazioni web, utile per lo sviluppo iniziale dell'interfaccia utente.


**Risorse umane**: Il team, affidandosi alle pratiche di XP, si dividerà tra sviluppatori, analisti e tester, contribuendo sinergicamente all'intero processo di sviluppo. L'aggiunta di un *database embedded* ha l'obiettivo di gestire una efficiente manipolazione dei dati.
<br/>

### Budget e programma
---

Durante il progetto non è stato definito alcun budget in quanto non strettamente necessario per lo sviluppo del software. <br/> 
Il progetto è suddiviso in *Milestones*:<br/>
- **Inizio del progetto**: l'obiettivo è comprendere il problema da risolvere, individuare i suoi requisiti e descrivere i suoi obiettivi.<br/> Concluso in data: 06/11/2024
- **Stesura *Project Plan***: l'obiettivo è generare il *project plan* completo. <br/> Concluso in data: 09/11/2024
- **Stesura Gestione del Progetto**: l'obiettivo è generare il documento contenente la gestione del progetto, indicando il tipo di processo utilizzato e l'organizzazione del lavoro. Inoltre verranno indicati eventuali strumenti di gestione della configurazione. 
- **Stesura Specifica dei Requisiti**: l'obiettivo è generare il documento contenente i requisiti, la loro descrizione e le corrispondenti tecniche di specifica, oltre alla documentazione completa riguardo alla lista  dei fattori di qualità perseguiti. 
- **Stesura Specifica Tecnica**: l'obiettivo è generare il documento contenente la specifica tecnica del progetto, indicando l'architettura e la descrizione del design. 
- **Stesura Piano di Test**: l'obiettivo è generare il documento contenente i casi di test con la loro descrizione.
- **Stesura Piano di Manutenzione**: l'obiettivo è generare il documento contenente eventuali attività di *refactoring*.
- **Generazione dei modelli UML**: l'obiettivo è ottenere una descrizione dell'architetttura del software tramite diagrammi UML.
- **Generazione del codice**: l'obiettivo è sviluppare il codice partendo dai modelli UML, al fine di ottenere le prime versioni del sistema software.
- **Conclusione del progetto**: l'obiettivo è verificare e validare il software, consegnando la versione definitiva del progetto agli utenti finali.

<br/>

### Cambiamenti
---
Essendo XP un metodo di sviluppo agile, i cambiamenti,inevitabili all'interno di un processo di sviluppo software, verranno gestiti in modo leggero, accettandoli e apportando piccole modifiche ad ogni iterazione.

<br/>

### Consegna
---
Il codice sorgente e la documentazione completa verranno consegnati tramite un repository Git condiviso con il Prof. Gargantini e la Prof.ssa Bonfanti e verranno successivamente presentati in forma orale.

<br/>

