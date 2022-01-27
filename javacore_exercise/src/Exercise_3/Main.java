package Exercise_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("a", "b", 2);
        Student s2 = new Student("c", "d", 1);
        Student s3 = new Student("hoang", "nam", 5);
        Student s4 = new Student("huyen", "diu", 7);
        Student s5 = new Student("a1", "b1", 2);
        Student s6 = new Student("a2", "b2", 2);
        Student s7 = new Student("a3", "b3", 2);
        Student s8 = new Student("a4", "b4", 2);
        Student s9 = new Student("a5", "b5", 2);
        Student s10 =new Student("a6", "b6", 2);
        ArrayList<Student> listStudent = new ArrayList<Student>(10);
        listStudent.add(s1);
        listStudent.add(s2);
        listStudent.add(s3);
        listStudent.add(s4);
        listStudent.add(s5);
        listStudent.add(s6);
        listStudent.add(s7);
        listStudent.add(s8);
        listStudent.add(s9);
        listStudent.add(s10);

        Worker w1 = new Worker("hoang", "nam", 5215, 2);
        Worker w2 = new Worker("huyen", "diu", 1500, 8);
        Worker w3 = new Worker("hoang1", "nam1", 5102, 6);
        Worker w4 = new Worker("hoang2", "nam2", 1420, 4);
        Worker w5 = new Worker("hoang3", "nam3", 2356, 5);
        Worker w6 = new Worker("hoang4", "nam4", 7745, 7);
        Worker w7 = new Worker("hoang5", "nam5", 2305, 4);
        ArrayList<Worker> listWorker = new ArrayList(10);
        listWorker.add(w1);
        listWorker.add(w2);
        listWorker.add(w3);
        listWorker.add(w4);
        listWorker.add(w5);
        listWorker.add(w6);
        listWorker.add(w7);

        ArrayList<Human> listHuman = new ArrayList(listWorker.size() + listStudent.size());
        listHuman.addAll(listStudent);
        listHuman.addAll(listWorker);

        Collections.sort(listStudent,new Student());
        System.out.println("list of student order by grade ascending: ");
        for (Student student : listStudent) {
           System.out.println(student);
        }

        Collections.sort(listWorker, new Worker());
        System.out.println("list of worker order by salary descending: ");
        for(Worker worker: listWorker){
            System.out.println(worker);
        }

        System.out.println("list of human: ");
        Collections.sort(listHuman);
        for(Human human : listHuman){
            System.out.println(human);
        }
    }
}
