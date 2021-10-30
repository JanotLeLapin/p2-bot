package fr.p2bot

import dev.kord.core.Kord
import org.junit.Before
import org.mockito.kotlin.mock

open class MainTest {
    lateinit var k: Kord

    @Before
    fun init() {
        k = mock()
    }
}
