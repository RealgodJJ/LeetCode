package com.company.interview;

public class ClassA {

    static {
        System.out.println("HelloA");
    }

    {
        System.out.println("Welcome ClassA");
    }

    public ClassA() {
        System.out.println("Create ClassA");
    }

    public static class ClassB extends ClassA {
        static {
            System.out.println("HelloB");
        }

        {
            System.out.println("Welcome ClassB");
        }

        public ClassB() {
            System.out.println("Create ClassB");
        }
    }

    public static void main(String[] args) {
        ClassB classB = new ClassB();
    }
}
