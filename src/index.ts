import { Client } from 'discord.js'
import env from './env'

// Initialiser le bot
const bot = new Client({
  intents: ['GUILD_MESSAGES', 'GUILD_MEMBERS']
});

bot.on('ready', () => console.log('Bot ready'))

// Connecter le bot au gateway
bot.login(env.token)
