## Arkitektur
Applikasjonen implementerer en **Model-View-ViewModel (MVVM)** arkitektur som er anerkjent som en best practice for å skape robuste og vedlikeholdbare applikasjoner. 
Denne arkitekturen benytter seg av datasources, repositories, og viewmodels, som sammen støtter prinsipper som lav kobling og høy kohesjon.
- **Datasources**: Tjener som primære kontaktpunkter for eksterne eller interne datastrømmer, og isolerer nettverks- eller databaselogikk fra resten av appen.
- **Repositories**: Håndterer alle dataoperasjoner og fungerer som et bindeledd mellom datamodellene og viewmodellene, sikrer dataintegritet og abstraherer datakildene.
- **Viewmodels**: Håndterer presentasjonslogikken og kommuniserer med lagringsenheter for å hente og oppdatere data som vises til brukeren.

## Teknologier, Vedlikehold og Videreutvikling
- API-nivå: Appen støtter minstekravet til API-nivå 28 (Android Pie), som er valgt basert på nødvendigheten av å integrere bestemte funksjoner og biblioteker. 
Disse funksjonene krever et høyere API-nivå, men tilfører betydelige forbedringer i brukeropplevelsen og appens kapabiliteter. 
Ifølge [statcounter](https://gs.statcounter.com/android-version-market-share/mobile-tablet/norway) så er det mindre enn 3% av android enheter på eldre versjoner enn Android Pie i Norge, så API-nivået vil i svært liten gråd utelukke potensielle brukere.


https://apilevels.com
https://gs.statcounter.com/os-version-market-share/android