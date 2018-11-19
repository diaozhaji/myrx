package rxjava;

import rxjava.interfaces.Action;
import rxjava.interfaces.Consumer;

// Functions.java
public class Functions {
    public static final Action EMPTY_ACTION = () -> {
    };

    public static <T> Consumer<T> emptyConsumer() {
        return t -> {
        };
    }
}
