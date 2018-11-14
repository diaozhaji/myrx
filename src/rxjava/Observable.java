package rxjava;

// 具体的被观察者(主题)
public class Observable<T> implements ObservableSource<T> {
    private T t;

    public Observable(T t) {
        this.t = t;
    }

    @Override
    public void subscribe(Observer<? super T> observer) {
        // 调用订阅时,触发观察者更新
        observer.onUpdate(t);
    }
}