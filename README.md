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

## Créer une commande

Ouvrez le projet dans [Intellij Idea](https://www.jetbrains.com/idea/) (un IDE optimisé pour le Kotlin), puis localisez le package `commands` situé dans `src/main/kotlin/fr/p2bot`\
Créez une classe en Kotlin héritant de l’interface `Command` dans le package `commands` (commands clic droit > new > Kotlin Class)\
Implémentez maintenant les membres `name`, `description` et `run` de l’interface dans votre classe :
```kotlin
class CoolCommand : Command {
    override val name = "cool"
    override val description = "Une commande super cool"

    override suspend fun run(client: Kord, message: Message, args: Array<String>) {}
}
```
Vous avez maintenant une commande qui a un nom et une description. Pour lui faire faire quelque chose quand elle est appelée, remplissez la fonction `run` avec ce que vous voulez.\
La fonction `run` prend trois paramètres :

- client : Le bot qui a reçu la commande
- message : Le message qui a déclenché la commande
- args : Les arguments de la commande (un tableau de tous les mots du message hormis celui de la commande)

Exemple
```kotlin
override suspend fun run(client: Kord, message: Message, args: Array<String>) {
    // L'utilisateur qui a écrit le message
    val author = message.author ?: return

    // Envoyer un message dans le channel
    message.channel.createMessage("Bonjour ${author.username}#${author.discriminator}, comment allez vous ?")
}
```
```text
!cool
> Bonjour JanotLeLapin#4989, comment allez vous ?
```

Voilà comment créer une commande très simple.\
Code de la commande en entier :
```kotlin
class CoolCommand : Command {
    override val name = "cool"
    override val description = "Une commande super cool"

    override suspend fun run(client: Kord, message: Message, args: Array<String>) {
        // L'utilisateur qui a écrit le message
        val author = message.author ?: return

        // Envoyer un message dans le channel
        message.channel.createMessage("Bonjour ${author.username}#${author.discriminator}, comment allez vous ?")
    }
}
```
