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

## Specifica Tecnica


### Indice

1. [Diagrammi UML](#Diagrammi-UML)<br/>
    1.1. [Diagramma dei casi d'uso](#Diagramma-dei-casi-duso)<br/>
    1.2. [Diagramma delle classi](#Diagramma-delle-classi)<br/>
    1.3. [Diagramma della macchina a stati Gestore](#Diagramma-della-macchina-a-stati-Gestore)<br/>
    1.4. [Diagramma di sequenza](#Diagramma-di-sequenza)<br/>
    1.5. [Diagramma delle attività](#Diagramma-delle-attività)<br/>
    1.6. [Diagramma di comunicazione](#Diagramma-di-comunicazione)<br/>
    1.7. [Diagramma dei pacchetti](#Diagramma-dei-pacchetti)<br/>
2. [Viste architettoniche](#Viste-architettoniche)<br/>
3. [Architettura del software](#Architettura-del-software)<br/>
4. [Software Design](#Software-Design)<br/>
    4.1. [Diagramma delle componenti](#Diagramma-delle-componenti)<br/>
    4.2. [Design pattern utilizzati](#Design-pattern-utilizzati)<br/>
    4.3. [Metriche di complessità](#Metriche-di-complessità)<br/>



### Diagrammi UML
---

#### Diagramma dei casi d'uso

<p align="center"  >
      <img src="../Diagrammi UML/Immagini/UseCaseDiagram.png" />
 </p> 

#### Diagramma delle classi

<p align="center"  >
      <img src="../Diagrammi UML/Immagini/ClassDiagram.png" />
 </p>  

#### Diagramma della macchina a stati Gestore
Il seguente diagramma della macchina a stati modella i possibili stati in cui si può trovare il gestore nel corso della sua interazione con SportMate.
<p align="center"  >
      <img src="../Diagrammi UML/Immagini/StateMachineGestore.png" />
 </p> 

#### Diagramma di sequenza
Il seguente diagramma di sequenza modella dettagliatamente il processo di login a SportMate eseguito dall'utente finale. Il processo è totalmente analogo anche per gli utenti organizzatori o i gestori dei centri sportivi.

<p align="center"  >
      <img src="../Diagrammi UML/Immagini/SequenceDiagram.png" />
 </p> 
 
#### Diagramma di comunicazione
Il seguente diagramma di comunicazione modella dettagliatamente il processo di login a SportMate eseguito dall'utente finale. Il processo è totalmente analogo anche per gli utenti organizzatori o i gestori dei centri sportivi.
<p align="center"  >
      <img src="../Diagrammi UML/Immagini/CommunicationDiagram.png" />
 </p> 
 
#### Diagramma delle attività
Il seguente diagramma delle attività modella il processo di unione ad una partita pubblica (con posti ancora disponbili) da parte di un utente finale, che ha scelto di utilizzare il credito associato al profilo SportMate come modalità di pagamento.
<p align="center"  >
      <img src="../Diagrammi UML/Immagini/ActivityDiagram.png" />
 </p> 

#### Diagramma dei pacchetti
<p align="center"  >
      <img src="../Diagrammi UML/Immagini/PackageDiagram.png" />
 </p> 
 
### Viste architettoniche
---
I punti di vista che si sono rivelati utili all'interno dell' architettura del progetto software sono:
- **Punti di vista del modulo**: fondamentali per fornire una vista statica del sistema
    - **Punto di vista a strati**: utile per visualizzare il sistema come una serie di livelli, in cui gli elementi di un livello possono utilizzare elementi dei livelli immediatamente inferiori. All'interno del progetto software, ad esempio, ***Presentation Layer*** usa ***Business Layer***, che a sua volta necessita di ***DB Layer***.
    - **Punto di vista *Use***: importante per valutare la modificabilità del sistema. Se un elemento viene modificato, devono essere modificati anche tutti gli elementi da cui viene utilizzato.
- **Punti di vista dei componenti e connettori**: fondamentali per descrivere la struttura dinamica del sistema, focalizzandosi sul sistema in esecuzione, dal punto di vista dei componenti e connettori.
    - **Punto di vista dei dati condivisi**: descrive come vengono prodotti e consumati i dati persistenti.
- **Punti di vista dell'allocazione**: descrivono la relazione tra il sistema e il suo ambiente.
    - **Punto di vista dell'incarico di lavoro**: utile per una migliore definizione riguardo chi ha fatto cosa e per determinare quale conoscenza è necessaria e dove. Questo punto di vista si è rivelato utile nell'assegnare le attività da svolgere per il progetto. Infatti, tutti i membri del gruppo sono stati coinvolti attivamente in tutte le fasi del progetto, ma in particolare, Biscaro Alessandro si è dedicato allo sviluppo della logica del programma e a quello dell'interfaccia grafica, Gambirasio Lorenzo si è dedicato alla modellazione del sistema, mentre Fabbris Thomas si è dedicato alla fase di testing. Invece, le fasi di codifica e gestione della documentazione sono state condivise tra tutti i partecipanti.
<br/>

### Architettura del software
---

Lo stile architettonico usato durante l'implementazione del progetto software è stato uno stile architettonico a strati, articolato in 3 livelli: *Presentation Layer*, *Business Layer* e *DB Layer*.
- **SportMateDBLayer**: corrisponde al livello dati in cui vengono archiviate e gestite su un database le informazioni elaborate dall'applicazione;
- **SporMateBusinessLayer**: corrispondente al *layer* di business e persistenza, si occupa dell'elaborazione delle informazioni raccolte nel livello di presentazione attraverso la logica di business; inoltre, può anche manipolare i dati presenti nel *layer* dati;
- **SportMatePresentationLayer**: corrispondente al layer di presentazione, rappresenta l'interfaccia utente ed il livello di comunicazione dell'applicazione con cui interagisce direttamente l'utente finale.

La visibilità tra gli strati è limitata, in quanto ogni livello può accedere alle primitive e ai servizi offerti dal livello immediatamente precedente.

Il ***Presentation Layer*** può essere inteso come un modulo di livello superiore, responsabile di visualizzare e raccogliere informazioni dall'utente nonchè di governare la sequenza temporale degli eventi all'interno del sistema. A titolo di esempio, le classi di questo livello raccolgono gli eventi generati dall'interazione tra utente e interfaccia grafica e li passano a ***listener***, precedentemente registrati presso i componenti della UI, in modo da reagire alle azioni dell'utente o aggiornare l'interfaccia quando necessario, secondo un approccio tipico della programmazione ***event-driven***.
I componenti presenti nel ***Business Layer***, corrispondenti alle classi inserite all'interno del package ***sportmateinc.sportmatebusinesslayer.services***, sono principalmente componenti computazionali, i quali si occupano dell'elaborazione dei dati ricevuti in input per restituire un output di qualche tipo,  validando l'input inserito dall'utente ed eseguendo delle query sul database sottostante.
Nel ***DB Layer***, spicca la presenza di un componente di memoria, un DB ***embedded*** che memorizza in modo persistente una raccolta di dati strutturati da condividere con gli altri componenti presenti all'interno del sistema.
Inoltre, la classe ***SportMateDB*** definisce una serie di operazioni associate al database sottostante e mantiene lo stato interno tra le chiamate successive delle operazioni; per questi si prefigura come un componente manager.

I componenti architetturali interagiscono tramite chiamate di procedura locale, mentre il sistema possiede un singolo thread di controllo.
<br/>

### Software Design
---

#### Diagramma delle componenti

<p align="center"  >
      <img src="../Diagrammi UML/Immagini/ComponentDiagram.png" />
 </p> 

#### Design pattern utilizzati

I design pattern utilizzati durante lo sviluppo del codice del progetto software sono i seguenti:

- **Singleton Pattern**: impiegato per fornire un'utile astrazione per gestire la connessione al database ***embedded*** usato in SportMate, denominato ***SportMateDB***. <br/> Questa scelta progettuale ha permesso di evitare la creazione di istanze duplicate migliorando la stabilità del programma e l'efficienza nella gestione della memoria e delle risorse. <br/> Il ***Singleton pattern*** non è stato utilizzato negli altri livelli del progetto in quanto non si è evidenziato il bisogno per uno sviluppo del codice migliore e più efficiente.
- **Delegation Pattern**: quando un utente interagisce con un bottone, l'oggetto ***Button*** di Vaadin delega la gestione dell'evento associato ad un ***listener***, implementando in questo modo il ***Delegation Pattern***, secondo un approccio comune nella gestione degli eventi in applicazioni grafiche. <br/> L'utilizzo di questo pattern aumenta la flessibilità del sistema e incoraggia il riutilizzo del codice, ma comporta un incremento nel numero di livelli di comunicazione, che potrebbe avere un impatto sulle prestazioni complessive e determinare un aumento della complessità del sistema. Tale pattern è stato anche applicato nelle classi ***HomePageView*** e ***FeedbackView*** in ***SportMatePresentationLayer*** per delegare la visualizzazione della lista dei feedback alla classe ***MessageListDelegator***, consentendo il riutilizzo del codice senza dover ricorrere alla relazione di ereditarietà (che sarebbe inappropriata in questo contesto in quanto le due classi non sono collegate da un'associazione ISA). 
<br/>

#### Metriche di complessità
Per valutare la qualità del sistema software, sono state calcolate le seguenti metriche di complessità con l'ausilio del tool **Stan4j**, suddivise per pacchetto.

:::warning
Work in progress!!!
:::
<br/>

