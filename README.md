# Team-21
# Gruppemedlemmer
1. Victor Uhnger (victou)
2. Sebastian Hareide (sebassha) 
3. Kaja Stenen (kajasten)
4. Mari Stenbrenden (mastenb)
5. Joachim Haasted (joachah)
6. Jonas William Røed Holmboe (jwholmbo)
___
# Github Desktop
## For deg som ikke er kjent med Git, eller Github fra før så anbefaler vi å ta i bruk [Github Desktop](https://desktop.github.com/).
___
# Git & GitHub Tutorial for Team 21
## Innholdsfortegnelse

- [Installasjons Guide](#installasjons-guide-for-å-kunne-få-tilgang-til-github-mappene)
  - [Kloning](#kloning)
- [Før Du Endrer i Repository](#ting-å-gjøre-før-du-endrer-i-repository)
  - [Oppdatere Lokalfiler](#oppdatere-lokalfiler)
- [Laste Opp/Endre Filer](#hvordan-laste-opp-nye-fileroppdatere-eksisterende-filer)
  - [Status Oversikt](#status-oversikt)
  - [Legge Til Filer](#legg-til-filer)
  - [Commit](#commit)
  - [Laste Opp Endringer](#laste-opp-endringene-din)
- [Branching](#branching)
  - [Bytte Branch](#bytte-fra-en-branch-til-en-annen)
  - [Branch-struktur](#hvordan-bygge-en-branch)
- [Slå Sammen Endringer](#hvordan-slå-sammen-endringer)
  - [Merge med Main](#slå-sammen-kode-med-main)

Vennligst husk å spørre på Slack hvis du er usikker på noe i prosessen! :)
___
## Installasjons guide for å kunne få tilgang til Github mappene
### Kloning
Hvis dette er første gangen du gjør endringer i prosjektet er det nødvendig å klone repository. Dette gjøres ved å trykke på "Code" knappen i GitHub, kopiere lenken, og taste inn denne kommandoen i terminalen:
```git
git clone [url]
```
*url* : https://github.uio.no/ditt-repository/dine-underbransjer
___
## Ting å gjøre FØR du endrer i repository
### Oppdatere lokalfiler
For at `git pull` skal fungere forventes det at du er inne i Git repository *[team-21]* mappen når kommandoene kjøres. Hvis du ikke er i et Git repository vil  du få en feilmelding **fatal: not a git repository** som betyr at du må navigere deg til Git mappen ved bruk av ```cd // cd..``` Hvis alt går som forventet vil kommandoen `git pull` oppdatere eksisterende filer, og legge til nye filer fra GitHub til din lokale mappe.
```git
git pull
```
___
## Hvordan laste opp nye filer/oppdatere eksisterende filer
*Disse bør følges i kronologisk rekkefølge*
### Status oversikt
`git status` Denne kommandoen sørger for at ditt lokale repository (din lokale mappe av prosjektet) er up to date med hva som ligger i Github. Da får du de nyeste filene, og kan gjøre de nødvendige endringene uten at det blir noe kollisjoner.
```git
git status
```
### Legg til filer
Denne kommandoen gir deg en oversikt over redigerte filer, samt hvorvidt de er lagt til, og klar for å committes.
```git
git add .
```
`git add .` legger til ALLE filer du har endret i mappen du befinner deg i. 
### Legg til fil
Hvis du ønsker å tilføye èn spesifikk fil til committen din så bruker du:
 ```git
git add *filename*
```
*Da er det nødvendig å bytte ut *filename* med filnavnet til den spesifikke filen du ønsker å tilføye.*
### Commit
```git
git commit -m "commit message"
```
Denne kommandoen snapshotter alle filene som ble lagt til fra "git add" til version history. Denne fungerer ofte som siste steget før man pusher endringene sine til GitHub.
### Laste opp endringene din
`git push` Etter å ha brukt `git add [filer]` og deretter `git commit -m "melding"`, kan du bruke `git push` for å laste opp koden din til GitHub, slik at den er tilgjengelig for nedlasting.
```git
git push
```
___
## Branching
Branch-kommandoen lager en ny gren ut fra den grenen du befinner deg i.
`git branch [branch-navn]` 
Grener er "versjoner" av koden som er uavhengige av hverandre, men vi bruker de for å kunne jobbe på nye endringer mens vi beholder eksisterende versjoner av koden vår. `git branch -d [branch-navn]` Denne kommandoen sletter branchen du oppgir, bruk den forsiktig! Flagget -d står for "delete". `git branch --no-merged` Gir deg en liste over alle branches som ikke har blitt merget inn i HEAD-branchen. `git branch -v -a` Gir deg informasjon om _alle_ branchene dine, lokale og remote. Du kan skrive kun `git branch` for å få navnet på lokale brancher.
### Bytte fra en branch til en annen
`git checkout [branch-navn]` Skifter hvilken gren du er i.

### Hvordan bygge en branch

`main` - Dette er production-koden, kode skal *aldri* pushes til main, main er alltid en fungerende versjon av applikasjonen.

`dev` - Dette er development-koden, vi brancher hovedsaklig ut herfra når vi skal jobbe med noe nytt, med mindre problemet bygger videre på en eksisterende branch.

`feat` - Dette er en feature-branch, disse kan vi ha mange av! Når du skal implementere en ny funksjon kaller du branchen din f.eks `dev/feat/feat-name`, slik at vi vet hvor branchen grener ut fra.

`fix` - Dersom du skal fikse noe i en eksisterende branch uten å ødelegge koden du allerede har, brancher du ut og suffikser branch-navnet med `/fix`, dersom jeg ønsker å fikse noe i `dev/feat/feat-name`, kaller jeg fix-branchen for `dev/feat/feat-name/fix`.
___
## Hvordan slå sammen endringer

*VIKTIG: Pull Requests **må** godtas i kronologisk rekkefølge!*

### Slå sammen kode med main
1. Rydd opp i branchen du jobber på (Fjern utdaterte kommentarer, formatter koden, gjør nødvendig testing)
2. Checkout `main` og skriv `git pull` for å hente eventuelle nylige endringer i main.
3. Checkout din egen branch igjen og skriv `git merge main` - her merger du main inn i branchen du jobber på.
4. Skriv `git push` for å oppdatere endringene i branchen din på GitHub.
5. Lag en Pull Request i GitHub og forespør et review med en i teamet, avgjør her om branchen kan slettes eller burde beholdes.
7. Er du usikker på noe i prosessen, spør på Slack før du foretar deg noe! :) 

Ved sammenslåing fra en branch til f.eks `dev` gjøres benyttes samme metode som med `main`.
