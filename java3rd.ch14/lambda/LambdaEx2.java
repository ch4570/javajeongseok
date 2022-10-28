package java3rd.ch14.lambda;

@FunctionalInterface
interface MyFunction1 {
    void myMethod(); // public abstract void myMethod();
}

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction1 f = () -> {}; // MyFunction f = (MyFunction) ( () -> {} );
        Object obj = (MyFunction1) ( () -> {}); // Object 타입으로 형변환이 생략됨
        String str = ((Object)(MyFunction1) (() -> {})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

//        System.out.println(() -> {}); // 에러. 람다식은 Object 타입으로 형변환 안됨
        System.out.println((MyFunction1) () -> {});
//        System.out.println((MyFunction1) () -> {}).toSTring()); // 에러
        System.out.println(((Object)(MyFunction1)(() -> {})).toString());
    }
}
