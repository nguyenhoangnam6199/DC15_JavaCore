package Excercise_4;

import java.util.ArrayList;

public class Animal {
    private String name;
    private int age;
    private Gender sex;

    public Animal() {
    }

    public Animal(String name, int age, Gender sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static double calculateAverageAge(ArrayList<Animal> list){
        int result = 0;
        for(Animal animal: list){
            result+= animal.getAge();
        }
        return result/list.size();
    }
}
