# P2 Bot

Le bot Discord de la P2

## Contribuer

Installez les packages suivants :

- [NodeJS](https://nodejs.org/fr/)
- [npm](https://www.npmjs.com/)

Clonez le dépôt Github :

```sh
git clone https://github.com/JanotLeLapin/p2-bot
```

Dans le dossier `p2-bot` créer le fichier `.env` qui contient :

```sh
BOT_TOKEN=<token du bot>
```

(Le token du bot Discord est indiqué sur le serveur Discord de la P2).\
Build le code source puis lancer le bot :

```sh
npm run build
npm run start
```

Vous pouvez maintenant modifier le code source.

### Commandes

Pour créer une commande, ajoutez un fichier dans le dossier `src/commands` qui exporte :

Une fonction `run` qui décrit ce que la commande doit faire lorsqu'elle est utilisée :

```ts
import { RunCommand } from '../command';

export const run: RunCommand = (message, args, client) => {
  // Exemple
  message.channel.send('Test!');
};
```

Une constante `meta` qui décrit les propriétés de la commande

```ts
import { CommandMeta } from '../command';

export const meta: CommandMeta = {
  // Exemple
  name: 'test',
  description: 'Une commande de test',
};
```
