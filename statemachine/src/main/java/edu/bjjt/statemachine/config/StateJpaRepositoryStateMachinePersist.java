package edu.bjjt.statemachine.config;

import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.data.jpa.JpaRepositoryStateMachine;
import org.springframework.statemachine.data.jpa.JpaRepositoryStateMachinePersist;
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository;
import org.springframework.statemachine.kryo.KryoStateMachineSerialisationService;
import org.springframework.statemachine.service.StateMachineSerialisationService;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.ArrayList;
import java.util.List;

public class StateJpaRepositoryStateMachinePersist<S, E> extends JpaRepositoryStateMachinePersist<S, E> {

    private final StateMachineSerialisationService<S, E> serialisationService;

    StateJpaRepositoryStateMachinePersist(JpaStateMachineRepository jpaStateMachineRepository) {
        super(jpaStateMachineRepository);
        this.serialisationService = new KryoStateMachineSerialisationService();
    }


    @Override
    public void write(StateMachineContext<S, E> context, Object contextObj) throws Exception {
        JpaRepositoryStateMachine build = build(context, contextObj, serialisationService.serialiseStateMachineContext(context));
        getRepository().save(build);
    }

    @Override
    public StateMachineContext<S, E> read(Object contextObj) throws Exception {
        JpaRepositoryStateMachine repositoryStateMachine = getRepository().findById(contextObj.toString()).orElse(null);
        if (repositoryStateMachine != null) {
            StateMachineContext<S, E> context = serialisationService
                    .deserialiseStateMachineContext(repositoryStateMachine.getStateMachineContext());
            if (context != null && context.getChilds() != null && context.getChilds().isEmpty()
                    && context.getChildReferences() != null) {
                List<StateMachineContext<S, E>> contexts = new ArrayList<>();
                for (String childRef : context.getChildReferences()) {
                    repositoryStateMachine = getRepository().findById(childRef).orElse(new JpaRepositoryStateMachine());
                    contexts.add(serialisationService
                            .deserialiseStateMachineContext(repositoryStateMachine.getStateMachineContext()));
                }
                return new DefaultStateMachineContext(contexts, repositoryStateMachine.getState(), context.getEvent(),
                        context.getEventHeaders(), context.getExtendedState(), context.getHistoryStates(),
                        context.getId());
            } else {
                return context;
            }

        }
        return null;
    }
}

