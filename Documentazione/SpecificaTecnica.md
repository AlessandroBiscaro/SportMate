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
    1.1. [Diagramma dei casi d'uso](#Diagramma-dei-casi-d'uso)<br/>
    1.2. [Diagramma delle classi](#Diagramma-delle-classi)<br/>
    1.3. [Diagramma della macchina a stati Change Request](#Diagramma-della-macchina-a-stati-Change-Request)<br/>
    1.4. [Diagramma della macchina a stati Gestore](#Diagramma-della-macchina-a-stati-Gestore)<br/>
    1.5. [Diagramma di sequenza](#Diagramma-di-sequenza)<br/>
    1.6. [Diagramma delle attività](Diagramma-delle-attività)<br/>
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
      <img src="../Diagrammi UML/Immagini/UseCaseDiagram2.png" />
 </p> 

#### Diagramma delle classi

<p align="center"  >
      <img src="../Diagrammi UML/Immagini/ClassDiagram2.png" />
 </p>  

#### Diagramma della macchina a stati
Il seguendo diagramma della macchina a stati modella i possibili stati in cui si può trovare il gestore nel corso della sua interazione con SportMate.
<p align="center"  >
      <img src="../Diagrammi UML/Immagini/MacchinaStatiGestore.png" />
 </p> 

#### Diagramma di sequenza
Il seguente diagramma di sequenza modella dettagliatamente il processo di login a SportMate eseguito dall'utente finale. Il processo è totalmente analogo anche per gli utenti organizzatori o i gestori dei centri sportivi.

<p align="center"  >
      <img src="../Diagrammi UML/Immagini/SequenceDiagramLogin.png" />
 </p> 

#### Diagramma delle attività
Il seguente diagramma delle attività modella il processo di unione ad una partita pubblica (ancora aperta) da parte di un utente finale, scegliendo come modalità di pagamento l'utilizzo del credito associato al profilo su SportMate.
<p align="center"  >
      <img src="../Diagrammi UML/Immagini/ActivityDiagramPrenotazione.png" />
 </p> 
 
### Viste architettoniche
---
I punti di vista utili all'interno dell' architettura software sono:
- **Punti di vista del modulo**: fondamentali per fornire una vista statica del sistema
    - **Punto di vista a strati**: utile per visualizzare il sistema come una serie di livelli, in cui gli elementi di un livello possono utilizzare elementi dei livelli immediatamente inferiori. All'interno del progetto software, ad esempio, ***Presentation Layer*** usa ***Business Layer***, che a sua volta utilizza ***DB Layer***.
    - **Punto di vista *Use***: importante per valutare la modificabilità del sistema. Se un elemento viene modificato, devono essere modificati anche tutti gli elementi da cui è utilizzato.
- **Punti di vista dei componenti e connettori**: fondamentali per descrivere la struttura dinamica del sistema, focalizzandosi sul sistema in esecuzione, dal punto di vista dei componenti e connettori.
    - **Punto di vista dei dati condivisi**: descrive come vengono prodotti e consumati i dati persistenti.
- **Punti di vista dell'allocazione**: descrivono la relazione tra il sistema e il suo ambiente.
    - **Punto di vista dell'incarico di lavoro**: utile per una migliore definizione riguardo chi ha fatto cosa e per determinare quale conoscenza è necessaria e dove. Tutti i membri del gruppo sono stati coinvolti attivamente in tutte le fasi del progetto. In particolare Biscaro Alessandro si è dedicato maggiormente allo sviluppo della logica del programma e a quello dell'interfaccia grafica, Gambirasio Lorenzo si è dedicato alla modellazione del sistema, mentre Fabbris Thomas si è dedicato alla fase di testing.
Le fasi di codifica e gestione di documentazione verranno condivise tra tutti i partecipanti.
<br/>

### Architettura del software
---

Lo stile architettonico usato durante l'implementazione del progetto software è stato uno stile architettonico a strati, articolato in 3 livelli: *Presentation Layer*, *Business Layer* e *DB Layer*.
- **SportMateDBLayer**: corrisponde al livello dati in cui vengono archiviate e gestite su un database le informazioni elaborate dall'applicazione;
- **SporMateBusinessLayer**: corrispondente al *layer* di business e persistenza, si occupa dell'elaborazione delle informazioni raccolte nel livello di presentazione attraverso la logica di business; inoltre, può anche manipolare i dati presenti nel *layer* dati;
- **SportMatePresentationLayer**: corrispondente al layer di presentazione, rappresenta l'interfaccia utente ed il livello di comunicazione dell'applicazione con cui interagisce direttamente l'utente finale.

La visibilità tra gli strati è limitata, in quanto ogni livello può accedere alle primitive e ai servizi offerti dal livello immediatamente precedente.

Il ***Presentation Layer*** può essere inteso come un modulo di livello superiore, responsabile di visualizzare e raccogliere informazioni dall'utente nonchè di governare la sequenza temporale degli eventi all'interno del sistema. A titolo di esempio, le classi del livello raccolgono gli eventi generati dall'interazione tra utente e interfaccia grafica e li passano a ***listener***, precedentemente registrati presso i componenti della UI, in modo da reagire alle azioni dell'utente o aggiornare l'interfaccia quando necessario, secondo un approccio tipico della programmazione ***event-driven***.
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

- **Singleton Pattern**: impiegato per fornire un'utile astrazione per gestire la connessione al database ***embedded*** usato in SportMate, denominato ***SportMateDB***. <br/> Questa scelta progettuale ha permesso di evitare la creazione di istanze duplicate migliorando la stabilità del programma e l'efficienza nella gestione della memoria e delle risorse. <br/> Il ***Singleton pattern*** non è stato utilizzato negli altri livelli del progetto in quanto non si è evidenziato il bisogno per uno sviluppo migliore e più efficiente.
- **Delegation Pattern**: quando un utente interagisce con un bottone, l'oggetto ***Button*** di Vaadin delega la gestione dell'evento associato ad un ***listener***, implementando in questo modo il ***Delegation Pattern***, secondo un approccio comune nella gestione degli eventi in applicazioni grafiche. <br/> L'utilizzo di questo pattern aumenta la flessibilità del sistema e incoraggia il riutilizzo del codice, ma comporta un incremento nel numero di livelli di comunicazione, che potrebbe avere un impatto sulle prestazioni complessive e determinare un aumento della complessità del sistema.
<br/>

#### Metriche di complessità
Per valutare la qualità del sistema software, sono state calcolate le seguenti metriche di complessità con l'ausilio del tool **Stan4j**, suddivise per pacchetto.

:::warning
Work in progress!!!
:::
<br/>

