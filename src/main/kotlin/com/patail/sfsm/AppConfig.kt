package com.patail.sfsm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.config.EnableStateMachine
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer
import java.util.*

/**
 * Created by spatail on 6/13/17.
 */
@Configuration
@EnableStateMachine
@SpringBootApplication
class AppConfig(val ctx: ApplicationContext) : EnumStateMachineConfigurerAdapter<States, Events>() {

    override fun configure(states: StateMachineStateConfigurer<States, Events>) {
        states.withStates()
                .initial(States.STATE1)
                .states(EnumSet.allOf(States::class.java))
    }

    override fun configure(transitions: StateMachineTransitionConfigurer<States, Events>) {
        transitions
                .withExternal()
                    .source(States.STATE1)
                    .target(States.STATE2)
                    .event(Events.EVENT1)
                    .and()
                .withExternal()
                    .source(States.STATE2)
                    .target(States.STATE1)
                    .event(Events.EVENT2)
    }

    override fun configure(configuration: StateMachineConfigurationConfigurer<States, Events>) {
        configuration.withConfiguration().beanFactory(ctx.autowireCapableBeanFactory)
    }

}