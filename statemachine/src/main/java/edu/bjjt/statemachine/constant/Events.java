package edu.bjjt.statemachine.constant;

import edu.bjjt.statemachine.config.StateMachineActionConfig;
import org.springframework.statemachine.action.Action;

public enum Events {
    E1{ @Override public Action<States, Events> getAction(){return new StateMachineActionConfig().action(); } },
    E2{ @Override public  Action<States, Events> getAction(){return new StateMachineActionConfig().action2(); } };

    public abstract Action<States, Events> getAction();
}
