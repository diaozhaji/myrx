package rxjava;

// 观察者
public interface Observer<T> {
    void onUpdate(T t);
}
