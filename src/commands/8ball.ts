import { CommandMeta, RunCommand } from '../command';

const answers = ['Oui :+1:', 'Pas sûr :thinking:', 'Non :-1:'];
export const run: RunCommand = message => {
  message.channel.send(answers[Math.floor(Math.random() * answers.length)]);
};

export const meta: CommandMeta = {
  name: '8ball',
  description: 'Répond à votre question',
};
