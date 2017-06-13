package com.patail.sfsm

import org.springframework.boot.SpringApplication

/**
 * Created by spatail on 6/9/17.
 */
fun main(args: Array<String>) {

    println("Saad :: Getting context")
    val ctx = SpringApplication.run(Main::class.java, *args)
    println("Saad :: Getting app")
    val app = ctx.getBean(MyApp::class.java)
    println("Saad :: Invoking state machine")
    app.doSignals()
}