package rxjava.interfaces;

// 接受一个参数,无返回的接口
public interface Consumer<T> {
    void apply(T t) throws Exception;
}