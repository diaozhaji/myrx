package rxjava.interfaces;

// 接收一个类型的参数,返回一个类型
public interface Function<T, R> {
    R apply(T t) throws Exception;
}