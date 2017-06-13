package com.patail.sfsm

import org.springframework.statemachine.annotation.OnTransition
import org.springframework.statemachine.annotation.WithStateMachine

/**
 * Created by spatail on 6/13/17.
 */
@WithStateMachine
class MyBean {

    @OnTransition(target = arrayOf("STATE1"))
    fun toState1() = println("Back to State1")

    @OnTransition(target = arrayOf("STATE2"))
    fun toState2() = println("On to State2")
}