package rxjava;

// Observable的事件分发接口
public interface ObservableOnSubscribe<T> {
    void subscribe(Emitter<T> emitter) throws Exception;
}