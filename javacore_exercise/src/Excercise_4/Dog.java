package Excercise_4;

public class Dog extends Animal implements ISound{
    public Dog() {
        super();
    }

    public Dog(String name, int age, Gender sex) {
        super(name, age, sex);
    }

    @Override
    public void Sound() {
        System.out.println("Gau Gau");
    }
}
