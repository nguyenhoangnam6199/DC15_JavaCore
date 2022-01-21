package Excercise_4;

public class Frog extends Animal implements ISound{
    public Frog() {
        super();
    }

    public Frog(String name, int age, Gender sex) {
        super(name, age, sex);
    }

    @Override
    public void Sound() {
        System.out.println("Op Op");
    }
}
