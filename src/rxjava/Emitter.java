package rxjava;

// 事件分发器接口
public interface Emitter<T> {
    void onUpdate(T t);
}