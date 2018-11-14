import rxjava.Observable;
import rxjava.Observer;

public class hellorx {

    public static void main(String[] args) {
        try {
            Observable.create(emitter -> {
                emitter.onUpdate("hello");
                emitter.onUpdate("world");
            })
                    .subscribe(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
