package rxjava;

import rxjava.interfaces.Function;
import rxjava.interfaces.ObservableSource;
import rxjava.interfaces.Observer;

// ObservableMap.java
final class ObservableMap<T, U> extends Observable<U> {
    private final ObservableSource<T> source;
    private final Function<? super T, ? extends U> function;

    ObservableMap(ObservableSource<T> source, Function<? super T, ? extends U> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    void subscribeActual(Observer<? super U> observer) {
        try {
            source.subscribe(new MapObserver<T, U>(observer, function));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MapObserver<T, U> extends BasicObserver<T, U> {
        final Function<? super T, ? extends U> mapper;

        MapObserver(Observer<? super U> actual, Function<? super T, ? extends U> mapper) {
            super(actual);
            this.mapper = mapper;
        }

        @Override
        public void onNext(T t) {
            if (done) return;
            try {
                // 这里实现具体的转化,下游接收到转化后的类型变量
                downstream.onNext(mapper.apply(t));
            } catch (Exception e) {
                onError(e);
            }
        }
    }
}