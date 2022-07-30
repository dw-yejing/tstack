package edu.bjjt.statemachine.controller;

import edu.bjjt.statemachine.constant.Events;
import edu.bjjt.statemachine.constant.States;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private StateMachineFactory<States, Events> factory;
    @Resource
    private StateMachinePersister stateMachinePersister;

    @GetMapping("/test")
    public void test(){
        StateMachine<States, Events> stateMachine = factory.getStateMachine("m1");
        Message<Events> message = MessageBuilder.withPayload(Events.E1).build();
        stateMachine.sendEvent(Mono.just(message)).subscribe();
        message = MessageBuilder.withPayload(Events.E2).build();
        stateMachine.sendEvent(Mono.just(message)).subscribe();
        try{
            stateMachinePersister.persist(stateMachine, "new");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
