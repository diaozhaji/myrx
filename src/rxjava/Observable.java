package rxjava;

// 具体的被观察者(主题)
public abstract class Observable<T> implements ObservableSource<T> {
    // 工厂方法,生产出一个Observable实例
    public static <T> Observable<T> create(ObservableOnSubscribe<T> source) {
        return new ObservableCreate<>(source);
    }

    // 真正进行事件分发处理的方法
    abstract void subscribeActual(Observer<? super T> observer) throws Exception;

    @Override // 交给subscribeActual实现,需要子类实现
    public void subscribe(Observer<? super T> observer) throws Exception {
        subscribeActual(observer);
    }
}
