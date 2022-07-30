package edu.bjjt.statemachine.config;

import edu.bjjt.statemachine.constant.Events;
import edu.bjjt.statemachine.constant.States;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.data.StateMachineRepository;
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.state.State;

import javax.annotation.Resource;

@Configuration
public class StateMachineConfig {
    @Resource
    private StateMachineRepository stateMachineRepository;

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }

    @Bean
    public StateMachinePersist stateMachinePersist(){
        return new StateJpaRepositoryStateMachinePersist((JpaStateMachineRepository)stateMachineRepository);
    }

    @Bean
    public StateMachinePersister<String, String, String> stateMachinePersister(StateMachinePersist stateMachinePersist){
        return new DefaultStateMachinePersister<String, String, String>(stateMachinePersist);
    }
}