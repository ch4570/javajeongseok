package java3rd.ch12;

import java.util.Collections;
import java.util.Comparator;

class Fruit4 {
    String name;
    int weight;

    Fruit4(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "(" + weight + ")";
    }
}

class Apple4 extends Fruit4 {
    Apple4(String name, int weight) {
        super(name, weight);
    }
}

class Grape4 extends Fruit4 {
    Grape4(String name, int weight) {
        super(name, weight);
    }
}

class AppleComp implements Comparator<Apple4> {

    @Override
    public int compare(Apple4 o1, Apple4 o2) {
        return o2.weight - o1.weight;
    }
}

class GrapeComp implements Comparator<Grape4> {

    @Override
    public int compare(Grape4 o1, Grape4 o2) {
        return o2.weight - o1.weight;
    }
}

class FruitComp implements Comparator<Fruit4> {

    @Override
    public int compare(Fruit4 o1, Fruit4 o2) {
        return o2.weight - o1.weight;
    }
}
public class FruitBoxEx4 {
    public static void main(String[] args) {
        FruitBox4<Apple4> appleBox = new FruitBox4<Apple4>();
        FruitBox4<Grape4> grapeBox = new FruitBox4<Grape4>();

        appleBox.add(new Apple4("GreenApple", 300));
        appleBox.add(new Apple4("GreenApple", 100));
        appleBox.add(new Apple4("GreenApple", 200));

        grapeBox.add(new Grape4("GreenGrape", 400));
        grapeBox.add(new Grape4("GreenGrape", 300));
        grapeBox.add(new Grape4("GreenGrape", 200));

        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());
        System.out.println(appleBox);
        System.out.println(grapeBox);
        System.out.println();
        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());
        System.out.println(appleBox);
        System.out.println(grapeBox);

    }       // main
}

class FruitBox4<T extends Fruit4> extends Box2<T> {}
