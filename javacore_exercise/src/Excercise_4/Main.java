package Excercise_4;

import java.util.ArrayList;

public class Main {
    public static double calculateAverageAge(ArrayList<Animal> list){
        int result = 0;
        for(Animal animal: list){
            result+= animal.getAge();
        }
        return result/list.size();
    }
    public static void main(String[] args) {
        ArrayList<Animal> dogArrayList = new ArrayList<>();
        ArrayList<Animal> catArrayList = new ArrayList<>();
        ArrayList<Animal> frogArrayList = new ArrayList<>();
        ArrayList<Animal> kittenArrayList = new ArrayList<>();
        ArrayList<Animal> tomcatArrayList = new ArrayList<>();

        dogArrayList.add(new Dog("dog",15,Gender.Male));
        dogArrayList.add(new Dog("dog1",16,Gender.Male));
        dogArrayList.add(new Dog("dog2",17,Gender.Male));
        System.out.println("Dog's Age Average: "+calculateAverageAge(dogArrayList));

        catArrayList.add(new Cat("cat",15,Gender.Female));
        catArrayList.add(new Cat("cat1",16,Gender.Female));
        catArrayList.add(new Cat("cat2",15,Gender.Female));
        System.out.println("Cat's Age Average: "+calculateAverageAge(catArrayList));

        frogArrayList.add(new Frog("frog",3,Gender.Male));
        frogArrayList.add(new Frog("frog",6,Gender.Male));
        frogArrayList.add(new Frog("frog",9,Gender.Male));
        System.out.println("Frog's Age Average: "+calculateAverageAge(frogArrayList));

        kittenArrayList.add(new Kitten("kt1",2));
        kittenArrayList.add(new Kitten("k21",4));
        kittenArrayList.add(new Kitten("kt31",6));
        System.out.println("Kitten's Age Average: "+calculateAverageAge(kittenArrayList));

        tomcatArrayList.add(new Kitten("tc1",2));
        tomcatArrayList.add(new Kitten("tc21",4));
        tomcatArrayList.add(new Kitten("tc31",6));
        System.out.println("Tomcat's Age Average: "+calculateAverageAge(tomcatArrayList));
    }
}
