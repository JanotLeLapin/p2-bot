# P2 Bot

Le bot Discord de la P2 (branche Kotlin)

## Prérequis

Installez les packages suivants :

- [Java JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Git](https://git-scm.com/)

## Contribuer

Cloner le dépôt Github
```shell
git clone https://github.com/JanotLeLapin/p2-bot
```
Passer sur la branch `kotlin` du dépôt
```shell
git checkout kotlin
```
Dans le dossier `p2-bot` créer le fichier `.env` qui contient :
```text
BOT_TOKEN=<token du bot>
```
Le token du bot Discord est indiqué sur le serveur Discord de la P2.\
Build le code source et lancer le bot :
```shell
./gradlew run
```

Vous pouvez maintenant modifier le code source.
