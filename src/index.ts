import { Client } from 'discord.js';
import { commands, loadCommands } from './command';
import env from './env';

// Initialiser le bot
const bot = new Client({
  intents: ['GUILD_MESSAGES', 'GUILD_MEMBERS', 'GUILDS'],
  presence: {
    status: 'online',
  },
});

bot.on('ready', () => {
  console.log('Bot ready');

  // Charger les commandes
  loadCommands('commands');
});
bot.on('messageCreate', message => {
  // Si l'auteur du message est un bot, ne rien faire
  if (message.author.bot) return;

  if (message.content.startsWith('!')) {
    const cmd = message.content.substring(1).split(' ')[0];
    const command = commands.find(c => c.name === cmd);
    if (command) command.run(message, bot);
  }
});

// Connecter le bot au gateway
bot.login(env.token);
