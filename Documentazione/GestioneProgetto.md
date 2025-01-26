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

## Gestione del Progetto

<br/>

### Indice

1. [Introduzione](#Introduzione)
2. [Modello di processo](#Modello-di-processo)
3. [Gestione della configurazione](#Gestione-della-configurazione)
4. [Organizzazione del team](#Organizzazione-del-team)

<br/>

### Introduzione
---

Il seguente documento ha come obiettivo spiegare in modo approfondito la gestione di *SportMate*, esplicitando tutte le scelte di progettazione che hanno guidato lo sviluppo del sistema software.
<br/>

### Modello di processo
--- 

La *vision* comune del team, ovvero l'offerta di un sistema software di qualità che possieda valore per gli utenti finali, unita alla mancanza di esperienza dei membri coinvolti nel progetto, hanno fatto convergere verso la scelta di un metodo agile. <br/> Il metodo adottato è stato *eXtreme Programming* (XP), un metodo agile puro il cui obiettivo principale è ottenere sempre un sistema in esecuzione, coerentemente con la nostra *vision*. <br/> In particolare, le *best practices* di XP rivelatesi maggiormente utili sono state: 
- la programmazione in coppia, 
- la proprietà colletiva del codice
- l'adozione di un ritmo sostenibile
- l'adozione di comuni standard di codifica.

L'adozione delle convenzioni per la programmazione Java come definite da Oracle si è rivelata utile per ottenere codice scritto in modo uniforme. La scelta di un modello iterativo ha consentito di ottenere un feedback immediato sullo stato di avanzamento del progetto e di adattare i requisiti del sistema ai bisogni sorti nel corso del processo di sviluppo.
Particolare rilevanza hanno assunto i test unitari eseguiti sia all'aggiunta di nuovo codice alla repository sia prima dell'archiviazione del codice. 

<br/>


### Gestione della configurazione
---

Per questo progetto, la gestione della configurazione è stata affidata al sistema di *versioning* Git, utilizzando GitHub come servizio di *hosting*. <br/> Il codice all'interno del main branch è stato tenuto sempre attivo e funzionante tramite frequenti test unitari e una continua integrazione. <br/> Le piccole modifiche sono state gestite semplicemente attraverso commit sul main branch del repository, mentre per adattamenti  più importanti sono stati utilizzati branch secondari su cui poter lavorare separatamente senza modificare il branch principale implementando cambiamenti nel codice, e verificando attraverso i test la correttezza del sistema software, prima  di procedure con il *merge* con il main branch.<br/> 
Le *Change Request* (CR) sono state gestite come segue:
- **Individuazione** delle modifiche da eseguire, come introduzione di nuove funzionalità o correzione di bug esistenti.
- **Apertura di issue**, con relativa assegnazione.
- **Creazione di un branch locale** a partire dal main branch.
- **Implementazione delle modifiche** sul branch locale.
- **Esecuzione di una *Pull Request***.
- **Revisione** delle modifiche da parte degli altri membri del team, con eventuale approvazione della *Pull Request*; in caso negativo, si ritorna alla fase di implementazione delle modifiche.
- **Chiusura del branch locale** e conseguente chiusura dell'issue.

<p align="center"  >
      <img src="../Diagrammi UML/Immagini/StateMachineGestioneCR.png" width="700" />   
    
 </p> 

In particolare, durante l'implementazione dell'architettura a tre livelli del sistema, sono stati creati principalmente due nuovi branch, denominati rispettivamente *SportMateBusinessLayer* e *SportMatePresentationLayer*, a partire dal branch *main* così da apportare le modifiche più sostanziali senza timore di intaccare la *codebase* del progetto funzionante e mantenere la versione stabile del progetto sul branch principale.

Si può notare che tra i contributori della *repository* vengano elencati, oltre ai componenti del gruppo, anche due autori "sconosciuti":
- **DependaBot**: uno strumento offerto gratuitamente da Github per la gestione delle dipendenze del progetto, che si occupa di aprire una *pull request* sul branch principale quando si accorge che dipendenze non sicure (ad esempio non aggiornate) vengono usate dal progetto, al fine di aggiornare i riferimenti ad esse presenti all'interno del codice
- **HackMD**:  un editor real-time e collaborativo, utile per la stesura di file markdown 

La repository del progetto è stata organizzata nel seguente modo:

- **Codice**: contiene il codice del sistema software.
- **Diagrammi UML**: contiene i diagrammi UML creati, tra cui *Use Case Diagram*, *Class Diagram*, *State Machine Diagram*, *Sequence Diagram*, *Communication Diagram*, *Activity Diagram*, *Component Diagram* e *Package Diagram*.
- **Documentazione**: contiene tutta la documentazione relativa al progetto, sotto forma di file markdown. Comprende *Project Plan*, *Gestione del Progetto*, *Specifica dei Requisiti*, *Specifica Tecnica*, *Piano di Test* e *SportMateManteinance*.
- **Immagini**: contiene le immagini utilizzate per i documenti.

Inoltre, è stata utilizzata una Kanban Board per una visualizzazione immediata del *workflow*, al fine di rispettare il principio di limitazione del lavoro in corso e ottenere aggiornamenti tempestivi sullo stato di avanzamento del progetto e sul progresso generale.
<br/>


### Organizzazione del team
---
Il team è composto da 3 persone, di pari competenze e conoscenze, senza gerarchie interne, basandosi su un modello di team *eXtreme Programming (XP)* come specificato nella sezione [Modello di Processo](#Modello-di-processo). Indipendentemente dalla modalità di lavoro, i membri sono sempre rimasti a stretto contatto e il confronto tra loro é stato continuo.

Tutti i membri del team sono stati coinvolti attivamente in tutte le fasi del progetto. 
Nello specifico:

- **Biscaro Alessandro** si è dedicato prioritariamente allo *sviluppo della logica del programma* ed allo *sviluppo dell'interfaccia grafica GUI*
- **Gambirasio Lorenzo** si è dedicato maggiormente alla *fase di modellazione*
- **Fabbris Thomas** si è dedicato principalmente alla *fase di testing*

Le **fasi di codifica** e **gestione della documentazione** sono state sviluppate cooperativamente da tutti i membri del team.

Sono stati  coinvolti all'interno del progetto anche **collaboratori esterni**, nello specifico figure come *tester* del software e gestori di impianti sportivi per la raccolta dei requisiti funzionali.

<br/>
