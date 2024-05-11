
# Vannplaning

![Logo av appen](https://github.uio.no/IN2000-V24/team-21/blob/main/Images/Vannplaning-logo.png?raw=true)
## Innholdsfortegnelse
- [[#Hva er dette prosjektet?|Hva er dette prosjektet?]]
- [[#Oppsett og nedlasting|Oppsett og nedlasting]]
	- [[#Oppsett og nedlasting#Forutsetninger|Forutsetninger]]
	- [[#Oppsett og nedlasting#Kom i gang|Kom i gang]]
		- [[#Kom i gang#Alternativ 1 - Last ned APK-fil|Alternativ 1 - Last ned APK-fil]]
		- [[#Kom i gang#Alternativ 2 - Emuler appen med Android Studio|Alternativ 2 - Emuler appen med Android Studio]]
	- [[#Oppsett og nedlasting#Ved problemer|Ved problemer]]
- [[#Teknologier og biblioteker|Teknologier og biblioteker]]
	- [[#Teknologier og biblioteker#App og UI|App og UI]]
	- [[#Teknologier og biblioteker#Nettverk og API-er|Nettverk og API-er]]
	- [[#Teknologier og biblioteker#Lokal database|Lokal database]]
	- [[#Teknologier og biblioteker#Kartfunksjonalitet|Kartfunksjonalitet]]
- [[#Bilder|Bilder]]
- [[#Om utviklerene|Om utviklerene]]
## Hva er dette prosjektet?

Vannplaning ble utviklet som et prosjekt i emnet [IN2000 (Software Engineering med prosjektarbeid)](https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/) ved institutt for informatikk hos Universitetet i Oslo våren 2024. Emnet gir studenter praktisk erfaring med Software Engineering gjennom prosjektarbeid. Prosjektet gikk ut på å lage en applikasjon for Android-enheter som løser en problemstilling knyttet til Havvarsler. Vi brukte tre API-er fra Metrologisk institutt for å utvikle en app som gir brukere anbefalte fritidsaktiviteter på eller ved vannet. 

Dette repoet inneholder kildekode og dokumentasjon av team 21 sin løsning på prosjektet.

## Oppsett og nedlasting

### Forutsetninger
[Android-emulator i Android Studio med API-nivå 26 eller høyere](https://www.google.com/search?q=android+studio&oq=android+studio&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDIzMzhqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8), eller tilsvarende Android-enhet.
### Kom i gang
#### Alternativ 1 - Last ned APK-fil

Last ned APK-fil [Herfra (finnes ikke ennå)](). Krever Android versjon 8.3.2 eller nyere.
#### Alternativ 2 - Emuler appen med Android Studio

1. Åpne en terminal
2. Hvis du ikke har git,[ last ned git](https://git-scm.com/downloads) eller `sudo apt-get install git`
3. Hvis du ikke har Gradle, installer med for eksempel brew: `brew install gradle`
4. Skriv `git clone https://github.uio.no/IN2000-V24/team-21 && cd team-21`
5. Kompiler prosjektet med ``./gradlew build``
6. Kjør appen med Android Studio eller se [kompileringsressurser](https://developer.android.com/build/building-cmdline) ved behov.
### Ved problemer
- Invalidate caches i Android Studio
- Trykk "clean build" og "rebuild project" i Android Studio.
- Slett og opprett ny Emulator i Android Studio.
## Teknologier og biblioteker
### App og UI
[Jetpack Compose](https://developer.android.com/develop/ui/compose) brukes for komponenter i appen. Dette er et bibliotek som lar deg programmere applikasjoner deklarativt.
[Material3 Design Kit](https://m3-material-io.translate.goog/?_x_tr_sl=en&_x_tr_tl=no&_x_tr_hl=no&_x_tr_pto=sc&_x_tr_hist=true) brukes til komponenter i appen.
### Nettverk og API-er
[Ktor](https://ktor.io/docs/welcome.html) brukes for å opprette en klient som kan sende forespørsler mot Metrologisk institutt sine API-er.
[Coil](https://coil-kt.github.io/coil/compose/) brukes for å hente bilder asynkront fra endepunkter på internett.
### Lokal database
- [SQLite (Room Database)](https://developer.android.com/training/data-storage/room)
### Kartfunksjonalitet
Leveres av biblioteket [MapBox](https://developer.android.com/training/data-storage/room) versjon 11. 

## Bilder
![Hjemskjerm](https://raw.github.uio.no/IN2000-V24/team-21/d19b2798003b397f2e2a81114b98f0eba3a10458/Images/Screenshot%202024-05-11%20at%2012.36.23.png?token=AAACJCYUS5SS2O5E7AWWYE3GH5G6G)
![Kartskjerm](https://raw.github.uio.no/IN2000-V24/team-21/d19b2798003b397f2e2a81114b98f0eba3a10458/Images/Screenshot%202024-05-11%20at%2012.37.44.png?token=AAACJC5TAJQHQ7YCPCMKVM3GH5G6G)
![Innstillinger](https://raw.github.uio.no/IN2000-V24/team-21/d19b2798003b397f2e2a81114b98f0eba3a10458/Images/Screenshot%202024-05-11%20at%2012.38.11.png?token=AAACJC6YHQMPVE6CQ6W2WADGH5G6G)

## Om utviklerene

Utviklerteamet består av:
1. Victor Uhnger (victou)
2. Sebastian Hareide (sebassha) 
3. Kaja Stenen (kajasten)
4. Mari Stenbrenden (mastenb)
5. Joachim Haasted (joachah)
6. Jonas William Røed Holmboe (jwholmbo)
