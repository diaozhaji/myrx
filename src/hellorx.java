import rxjava.Observable;
import rxjava.Observer;

public class hellorx {

    public static void main(String[] args) {
        // 观察者
        Observer<String> observer = s -> System.out.println(s);
        // 被观察者(主题)
        Observable<String> observable = new Observable<>("hello");
        // 调用
        observable.subscribe(observer);
    }


}
