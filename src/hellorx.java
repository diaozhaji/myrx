import rxjava.*;
import rxjava.interfaces.Disposable;
import rxjava.interfaces.Emitter;
import rxjava.interfaces.ObservableOnSubscribe;
import rxjava.interfaces.Observer;

import java.util.Arrays;
import java.util.List;

public class hellorx {

    public static void main(String[] args) {


        try {
            Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(Emitter<String> emitter) throws Exception {
                    emitter.onNext("1");
                    emitter.onNext("2");
                    emitter.onComplete();
                }
            })
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onNext(String s) {
                            System.out.println(s);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            System.out.println("end...");
                        }

                        @Override
                        public void onSubscribe(Disposable d) {

                        }
                    });

            //支持lamada版
            Observable.create((ObservableOnSubscribe<String>) emitter -> {
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onComplete();
            }).subscribe(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

        disposableTest();
        disposableTest2();

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};

        List<String> players = Arrays.asList(atp);

        mapTest();

    }

    private static Disposable mDisposable = null;

    static void disposableTest() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        })
                .subscribe(integer -> {
                            System.out.println(integer);
                            // 3 事件将不再传递和接收
                            if (integer == 2 && mDisposable != null)
                                mDisposable.dispose();
                        },
                        Functions.emptyConsumer(),
                        Functions.EMPTY_ACTION,
                        d -> mDisposable = d);
    }
    // 1
    // 2

    // 这种方式只在,异步的情况下使用,由于示例中目前还不支持异步,因此以下代码起不了作用.
    static void disposableTest2() {
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Integer>) emitter -> {
                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onNext(3);
                    emitter.onComplete();
                })
                .subscribe(System.out::println);
        disposable.dispose();
    }

    static void mapTest() {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("1");
            emitter.onNext("2");
            emitter.onComplete();
        })
                .map(s -> Integer.parseInt(s) * 10)
                .subscribe(System.out::println);
    }


}
