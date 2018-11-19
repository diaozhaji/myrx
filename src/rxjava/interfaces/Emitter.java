package rxjava.interfaces;

// 事件分发器接口
public interface Emitter<T> {
    void onNext(T t);

    void onError(Throwable e);

    void onComplete();
}