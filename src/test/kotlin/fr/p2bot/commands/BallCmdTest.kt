package fr.p2bot.commands

import dev.kord.core.entity.Message
import dev.kord.core.entity.channel.TextChannel
import fr.p2bot.MainTest
import org.junit.*
import org.mockito.MockedStatic
import org.mockito.Mockito.mockStatic
import org.mockito.kotlin.*
import java.util.concurrent.ThreadLocalRandom

class BallCmdTest : MainTest() {
    lateinit var c: TextChannel
    lateinit var m: Message
    lateinit var cmd: BallCmd

    lateinit var current: ThreadLocalRandom
    lateinit var tlr: MockedStatic<ThreadLocalRandom>

    @Before
    fun setUp() {
        c = mock()
        m = mock()
        whenever(m.channel).thenReturn(c)
        cmd = BallCmd()

        current = mock()
        tlr = mockStatic(ThreadLocalRandom::class.java)
        tlr.`when`<ThreadLocalRandom> { ThreadLocalRandom.current() }.thenReturn(current)
    }

    @Test
    fun answerYes() {
        whenever(current.nextInt(any(), any())).thenReturn(0)

        suspend {
            cmd.run(k, m, emptyArray())
            verify(c).createMessage("Oui")
        }
    }

    @Test
    fun answerNo() {
        whenever(current.nextInt(any(), any())).thenReturn(2)

        suspend {
            cmd.run(k, m, emptyArray())
            verify(c).createMessage("Non")
        }
    }

    @After
    fun tearDown() {
        tlr.close()
    }
}
