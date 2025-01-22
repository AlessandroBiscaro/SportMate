<p>
       <h1 align="center">SportMate </h1> 
</p>

  <p align="center"  >
      <img src="Immagini/SportMate3MottoSmall.PNG" width="250" />   
 </p> 
 <p align="center"> <em> Università degli Studi di Bergamo <br/>
Ingegneria Informatica <br/>
Biscaro Alessandro [1087892] <br/>
Fabbris Thomas [1086063] <br/>
Gambirasio Lorenzo Umberto [1087441] </em>
</p >

<p align="center">
       <img src="https://github.com/AlessandroBiscaro/SportMate/actions/workflows/Workflow.yml/badge.svg" />
       <br/>
</p>

## Installare ed eseguire SportMate

### Requisiti

SportMate necessita, per la sua corretta esecuzione, dei seguenti requisiti minimi:
- Sistema operativo: Windows 10 o versioni successive; OS X 10.8.3 o versioni successive
- RAM: almeno 1 GB per SO a 32 bit; 2 GB per SO a 64 bit
- Spazio di archiviazione: almeno 128 MB 
- Processore: almeno 1 GHz di frequenza di clock
- Browser Internet: Microsoft Edge, Google Chrome, Mozilla Firefox, Safari

### Esecuzione di SportMate tramite Eclipse (consigliato)

Per prima cosa è necessario clonare la repository da Github

```shell
git clone https://github.com/AlessandroBiscaro/SportMate.git
```
Successivamente eseguire questi passaggi nell'ordine indicato per avviare correttamente SportMate nel web browser di default.

1. **Esegui il progetto SportMateDBLayer:**
   - Importa il progetto SportMateDBLayer in Eclipse:
     1. Apri Eclipse e seleziona `File` > `Import...`;
     2. Seleziona `Existing Maven Projects` e premi `Next`;
     3. Naviga nella directory del progetto e premi `Finish`.
   - Esegui l'installazione del progetto SportMateDBLayer:
     1. Fai clic destro sul progetto nel project explorer;
     2. Seleziona `Run As` > `Maven clean`;
     3. Seleziona `Run As` > `Maven install`.

2. **Esegui il progetto SportMateBusinessLayer:**
   - Importa il progetto SportMateBusinessLayer in Eclipse seguendo gli stessi passaggi di cui sopra;
   - Esegui l'installazione del progetto SportMateBusinessLayer come hai fatto per SportMateDBLayer.

3. **Esegui il progetto SportPresentationLayer:**
   - Importa il progetto SportMatePresentationLayer in Eclipse seguendo gli stessi passaggi di cui sopra.
   - Esegui il progetto SportMatePresentationaLayer:
     1. Fai clic destro sul progetto nel project explorer;
     2. Seleziona `Run As` > `Maven build`.

La repository clonata dovrebbe essere pronta all'uso con i progetti SportMateDBLayer e SportMatePresentationLayer precompilati, ma si consiglia di eseguire in ogni caso i passi sopra indicati per essere certi di usare la versione più recente dell'applicazione.
