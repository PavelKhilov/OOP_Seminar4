import java.util.ArrayList;

public class HomeWork {
/**
 a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 c. Для хранения фруктов внутри коробки можно использовать ArrayList;
 d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
 подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 Можно сравнивать коробки с яблоками и апельсинами;
 f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 g. Не забываем про метод добавления фрукта в коробку.
*/
    public static void main(String[] args) {

        Box<Apple> apples = new Box<>();

        Apple apple1 = new Apple();
        apples.addFruit(apple1);

        System.out.println(apples.weightBox());

        Box<Orange> oranges = new Box<>();

        Orange orange1 = new Orange();
        oranges.addFruit(orange1);

        System.out.println(oranges.weightBox());

        System.out.println(apples.compareBox(oranges));

        System.out.println(apples.getClass());

//        Box<Apple> apples2 = new Box<>();
//        apples2.addFruit(new Apple());
//        System.out.println(apples2.weightBox());
//
//        apples2.replaceBox(oranges);
//        apples2.replaceBox(apples);
//
//        System.out.println(apples.weightBox());
//        System.out.println(oranges.weightBox());
//        System.out.println(apples2.weightBox());
    }
}

abstract class Fruit{
    private final float weight;

    public float getWeight() {
        return weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Apple extends Fruit{

    public Apple() {
        super(1.0f);
    }

    @Override
    public String toString() {
        return "Apple";
    }
}

class Orange extends Fruit{

    public Orange() {
        super(1.5f);
    }

    @Override
    public String toString() {
        return "Orange";
    }
}

class Box<T extends Fruit>{
    private ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public float weightBox(){
        float weightBox = 0;
        for (T fruit: fruits) {
            weightBox += fruit.getWeight();
        }
        return weightBox;
    }

    public boolean compareBox(Box box2){
        return weightBox() == box2.weightBox();
    }

//    public void replaceBox(Box box2){
//        if (fruits.getClass() == box2.getClass()){
//            for (T fruit: fruits) {
//                box2.addFruit(fruit);
//                fruits.remove(fruit);
//            }
//        } else{
//            System.out.println("В коробках лежат разные фрукты.");
//        }
//    }

    @Override
    public String toString() {
        return String.format("В коробке лежат фрукты общим весом %.2f", weightBox());
    }
}