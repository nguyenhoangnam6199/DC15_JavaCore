package Excercise_4;

public class Cat extends Animal implements ISound{
    public Cat() {
        super();
    }

    public Cat(String name, int age, Gender sex) {
        super(name, age, sex);
    }

    @Override
    public void Sound() {
        System.out.println("meo meo");
    }
}
