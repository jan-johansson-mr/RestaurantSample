package org.tempuri.pizza.functional;

public interface Action {
    void invoke();

    default Action andThen(Action after){
        return () -> {
            this.invoke();
            after.invoke();
        };
    }

    default Action compose(Action before){
        return () -> {
            before.invoke();
            this.invoke();
        };
    }
}
