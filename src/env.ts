// Variables d'environnement
if (process.env.NODE_ENV !== 'production') require('dotenv').config();

export default {
  /** Le token du bot Discord */
  token: process.env.BOT_TOKEN,
};
