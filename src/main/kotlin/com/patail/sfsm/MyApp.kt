package com.patail.sfsm

import org.springframework.statemachine.StateMachine
import org.springframework.stereotype.Component

/**
 * Created by spatail on 6/13/17.
 */
@Component
class MyApp(val stateMachine: StateMachine<States, Events>) {

    fun doSignals() {
        stateMachine.start()
        stateMachine.sendEvent(Events.EVENT1)
        stateMachine.sendEvent(Events.EVENT2)
    }
}