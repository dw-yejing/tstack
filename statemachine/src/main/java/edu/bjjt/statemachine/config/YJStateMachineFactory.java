package edu.bjjt.statemachine.config;

import edu.bjjt.statemachine.constant.Events;
import edu.bjjt.statemachine.constant.States;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;

import javax.annotation.Resource;
import java.util.EnumSet;

@EnableStateMachineFactory
public class YJStateMachineFactory extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Resource
    private StateMachineListener stateMachineListener;

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(stateMachineListener)
        ;
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.SI)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.SI).target(States.S1).event(Events.E1).action(Events.E1.getAction())
                .and()
                .withExternal()
                .source(States.S1).target(States.S2).event(Events.E2).action(Events.E2.getAction());
    }

}

