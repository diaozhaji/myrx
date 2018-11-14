package rxjava;

// Observable的一个适配器,用于快速创建一个可以发送事件的Observable
class ObservableCreate<T> extends Observable<T> {
    // 事件分发接口
    private final ObservableOnSubscribe<T> source;

    ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
        // 分发逻辑的具体代码
    void subscribeActual(Observer<? super T> observer) throws Exception {
        CreateEmitter<T> emitter = new CreateEmitter<>(observer);
        source.subscribe(emitter);
    }

    // 内部分发器
    static class CreateEmitter<T> implements Emitter<T> {
        private final Observer<? super T> observer;

        CreateEmitter(Observer<? super T> observer) {
            this.observer = observer;
        }

        @Override // 这里只是简单的将observer观察者的事件直接分发出去
        public void onUpdate(T t) {
            observer.onUpdate(t);
        }
    }
}