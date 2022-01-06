import { Client } from 'discord.js';
import env from './env';

// Initialiser le bot
const bot = new Client({
  intents: ['GUILD_MESSAGES', 'GUILD_MEMBERS', 'GUILDS'],
  presence: {
    status: 'online',
  },
});

bot.on('ready', () => console.log('Bot ready'));
bot.on('messageCreate', message => {
  // Si l'auteur du message est un bot, ne rien faire
  if (message.author.bot) return;

  message.channel.send('Bonjour :wave:');
});

// Connecter le bot au gateway
bot.login(env.token);
