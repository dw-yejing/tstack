package edu.bjjt.statemachine.config;

import edu.bjjt.statemachine.constant.Events;
import edu.bjjt.statemachine.constant.States;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class StateMachineActionConfig {

    public Action<States, Events> action() {
        return new StateMachineAction(){
            public void deal(StateContext context){
                System.out.println("e1");
            }
        };
    }

    public Action<States, Events> action2() {
        return new StateMachineAction(){
            public void deal(StateContext context){
                System.out.println("e2");
            }
        };
    }

    public Action<States, Events> action3() {
        return new StateMachineAction(){
            public void deal(StateContext context){
                System.out.println("e3");
            }
        };
    }
}
