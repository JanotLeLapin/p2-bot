package fr.p2bot.commands

import dev.kord.core.Kord
import dev.kord.core.entity.Message
import fr.p2bot.Command
import java.util.concurrent.ThreadLocalRandom

class BallCmd : Command {
    override val name = "8ball"
    override val description = "Posez moi une question !"

    private val answers = arrayOf("Oui", "Peut-être", "Non")
    override suspend fun run(client: Kord, message: Message, args: Array<String>) {
        message.channel.createMessage(answers[ThreadLocalRandom.current().nextInt(0, answers.size)])
    }
}
