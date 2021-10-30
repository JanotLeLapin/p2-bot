package fr.p2bot

import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import org.reflections.Reflections
import org.reflections.scanners.Scanners

class CommandHandler {
    companion object {
        val commands = ArrayList<Command>()

        fun init(pack: String, client: Kord) {
            // Fetch each class extending the Command interface
            commands.addAll(
                Reflections(pack, Scanners.SubTypes)
                    .getSubTypesOf(Command::class.java)
                    .map { cmd -> cmd.getDeclaredConstructor().newInstance() }
            )

            client.on<MessageCreateEvent> {
                val author = message.author ?: return@on
                if (author.isBot || !message.content.startsWith("!")) return@on

                val args = message.content.substring(1).split(" ")
                val cmdName = args[0]

                val command = commands.find { cmd -> cmd.name == cmdName } ?: return@on
                command.run(kord, message, args.drop(1).toTypedArray())
            }
        }
    }
}
