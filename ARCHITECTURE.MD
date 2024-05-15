## Arkitektur
Applikasjonen er sammensatt av en arkitektur som tar i bruk design-prinsipper som **Model-View-ViewModel (MVVM)** og **UDF**, som er anerkjent som en best practice for å skape robuste og vedlikeholdbare applikasjoner.
MVVM benytter seg av datasources, repositories, og viewmodels, som sammen støtter prinsipper som lav kobling og høy kohesjon.
- **Datasources**: Tjener som primære kontaktpunkter for eksterne eller interne datastrømmer, og isolerer nettverks- eller databaselogikk fra resten av appen.
- **Repositories**: Håndterer alle dataoperasjoner og fungerer som et bindeledd mellom datamodellene og viewmodellene, sikrer dataintegritet og abstraherer datakildene.
- **Viewmodels**: Håndterer presentasjonslogikken og kommuniserer med lagringsenheter for å hente og oppdatere data som vises til brukeren.
  UDF-prinsippene er integrert i MVVM strukturen for å optimalisere dataflyten.

### Integrasjon av MVVM og UDF
* **Data Flow:** I MVVM sendes data fra modellen til en ViewModel, og deretter til View. I en UDF-integrert MVVM, initieres endringer i data flyten gjennom definerte handlinger i View, som oppdaterer ViewModel, og videre oppdaterer Model om nødvendig. Etter at Model har behandlet data, oppdateres tilstanden, og tilstanden kommuniseres tilbake til View gjennom ViewModel.
* **Tilstandsforvaltning:** ViewModel fungerer som tilstandsbehandleren i UDF. De tar imot handlinger fra View, henter eller oppdaterer data fra Model basert på disse handlingene, og oppdaterer View med nye data. Denne strømmen sikrer at data flyter i én retning og reduserer risikoen for synkroniseringsfeil mellom brukergrensesnittet og datamodellen.
* **Isolasjon og modularitet:** UDF støtter lav kobling og høy kohesjon ved å isolere tilstandsforvaltning i ViewModel. Dette gjør det enklere å teste og vedlikeholde hver del av applikasjonen uavhengig de andre. DataSources og Repositories i MVVM sikrer at datakildene er godt abstraherte, noe som passer godt med UDFs krav om en klar forutsigbar flyt.

## Teknologier, Vedlikehold og Videreutvikling
- API-nivå: Appen støtter minstekravet til API-nivå 26 (Android Oreo), som er valgt basert på nødvendigheten av å integrere bestemte funksjonaliteter og biblioteker.
  Disse funksjonene krever et høyere API-nivå, men tilfører betydelige forbedringer i brukeropplevelsen og appens egenskaper.
  Ifølge [statcounter](https://gs.statcounter.com/android-version-market-share/mobile-tablet/norway) så er det mindre enn 2% av android enheter på eldre versjoner enn Android Oreo i Norge, så API-nivået vil i svært liten grad utelukke potensielle brukere grunnet gammel OS.