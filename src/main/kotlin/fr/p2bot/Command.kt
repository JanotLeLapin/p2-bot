package fr.p2bot

import dev.kord.core.Kord
import dev.kord.core.entity.Message

interface Command {
    val name: String
    val description: String

    suspend fun run(client: Kord, message: Message, args: Array<String>)
}
