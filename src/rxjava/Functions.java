package rxjava;

// Functions.java
public class Functions {
    public static final Action EMPTY_ACTION = () -> {
    };

    public static <T> Consumer<T> emptyConsumer() {
        return t -> {
        };
    }
}
