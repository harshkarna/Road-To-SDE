package com.Collections.List;

import com.OOPS_part1.Student;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetClass {

    public static void main(String[] args) {

       /*
        1.Set only contains unique elements
        2.There is no order defined
        */

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("Anuj", 2));
        studentSet.add(new Student("Ramesh", 4));
        studentSet.add(new Student("Shivam", 3));

        studentSet.add(new Student("Rohit", 2));

        Student s1 = new Student("Anuj", 2);
        Student s2 = new Student("Rohit", 2);

        System.out.println(s1.equals(s2));
        System.out.println(studentSet);

        Set<Integer> set = new HashSet<>();// O(1)
        Set<Integer> set1 = new LinkedHashSet<>(); // maintains the order in which they are inserted

        Set<Integer> set2 = new TreeSet<>(); //sorted order O(logn)

        set.add(32);
        set.add(2);
        set.add(54);
        set.add(21);
        set.add(65);

        System.out.println(set);

        set.remove(54);

        System.out.println(set);

        System.out.println(set.contains(21));

        System.out.println(set.isEmpty());

        System.out.println(set.size());

        set.clear();

        System.out.println(set);

    }
}
