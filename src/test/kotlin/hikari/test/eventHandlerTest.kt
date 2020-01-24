package hikari.test

import hikari.Hikari
import hikari.annotations.EventHandler
import hikari.events.Event

@ExperimentalStdlibApi
suspend fun main() {
    val hi = Hikari()

    hi.eventBus.addEventHandler(test())

    hi.eventBus.fireEvent(Event.MESSAGE_CREATE, "abc")
}

class test {
    @EventHandler(Event.MESSAGE_CREATE)
    suspend fun test(test: String) {
        println("event handler called $test")
    }

    @EventHandler(Event.MESSAGE_CREATE)
    suspend fun test2() {
        println("event handler 2 called")
    }
}