package fr.p2bot

import dev.kord.core.Kord
import io.github.cdimascio.dotenv.Dotenv

suspend fun main() {
    val client = Kord(Dotenv.load()["BOT_TOKEN"])

    // Initialize command handler
    CommandHandler.init("fr.p2bot.commands", client)

    client.login()
}
