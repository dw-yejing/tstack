package edu.bjjt.statemachine.config;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public abstract class StateMachineAction implements Action {
    @Override
    public void execute(StateContext context) {
        System.out.println("--------------------事件发生前--------------------");
        deal(context);
        System.out.println("--------------------事件发生后--------------------");

    }

    public abstract void deal(StateContext context);

}
