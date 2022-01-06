import { Client, Message } from 'discord.js';
import { readdirSync } from 'fs';
import { join } from 'path';

export type RunCommand = (
  message: Message,
  args: string[],
  client: Client
) => any;

export type CommandMeta = {
  name: string;
  description: string;
};

export class Command {
  private _name: string;
  private _description: string;
  private _run: RunCommand;

  get name() {
    return this._name;
  }
  get description() {
    return this._description;
  }
  run(message: Message, client: Client) {
    const args = message.content.split(' ');
    args.shift();
    this._run(message, args, client);
  }

  constructor(meta: CommandMeta, run: RunCommand) {
    this._name = meta.name;
    this._description = meta.description;
    this._run = run;
  }
}

export const commands: Command[] = [];
export const loadCommands = (path: string) =>
  readdirSync(join(__dirname, path)).forEach(fname => {
    const name = fname.split('.')[0];
    const cmd: {
      run: RunCommand;
      meta: CommandMeta;
    } = require(`./${path}/${name}`);

    commands.push(new Command(cmd.meta, cmd.run));
  });
