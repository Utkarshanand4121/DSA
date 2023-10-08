public class OOPs {
    public static void main(String args[]) {
        // Pen p1 = new Pen();
        // p1.setColor("Blue");
        // System.out.println(p1.getcolor());
        // p1.setTip(5);
        // System.out.println(p1.getTip());
        // p1.setColor("Red");
        // System.out.println(p1.getcolor());
        // BankAccount myAcc = new BankAccount();
        // myAcc.setPassword("abcder0");
        // Student s1 = new Student();
        // s1.name = "Utkarsh";
        // s1.roll = 1234;
        // s1.password = "abcdefg";
        // s1.marks[0] = 98;
        // s1.marks[1] = 100;
        // s1.marks[2] = 100;
        // Student s2 = new Student(s1);
        // s2.password = "xyz";
        // s1.marks[2] = 97;
        // for(int i=0; i<3; i++) {
        // System.out.println(s2.marks[i]);
        // }
        Horses h1 = new Horses();
        Animals a1 = new Horses();
        
    }

}

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }
}

class Pen {
    private String color;
    private int tip;

    String getcolor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String Color) {
        this.color = Color;
    }

    void setTip(int tip) {
        this.tip = tip;
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    // Shalow Copy constructor
    // Student (Student s1) {
    // marks = new int[3];
    // this.name = s1.name;
    // this.roll = s1.roll;
    // this.marks = s1.marks;
    // }

    // Deep constructor

    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;

        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

    Student() {
        marks = new int[3];
        System.out.println("Constructor is empty");
    }

    Student(String name) {
        marks = new int[3];
        this.name = name;
    }

    Student(int roll) {
        marks = new int[3];
        this.roll = roll;
    }
}

abstract class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }

    abstract void walk();
}

// class Fish extends Animal {
// String fins;

// void swin() {
// System.out.println("swins");
// }
// }

class Mammal extends Animal {
    void walk() {
        System.out.println("walks");
    }
}

class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

class Horse extends Animal {
    void walk() {
        System.out.println("Walk on 4 legs");
    }
}

class Chicken extends Animal {
    void walk() {
        System.out.println("Walk on 2 legs");
    }
}

// Interfaces

interface chessPlayer {
    void moves();
}

class Queen implements chessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal(in all 4 direction)");
    }
}

class Rook implements chessPlayer {
    public void moves() {
        System.out.println("up, down, left, right");
    }
}

class King implements chessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal(by 1 step)");
    }
}

interface Herbivore {
    void eats();
}

interface Carnivore {
    void eats();
}

class Omnivore implements Herbivore, Carnivore {
    public void eats() {
        System.out.println("Eats plants and animals");
    }
}

class Students {
    String name;
    int roll;
    static String schoolname;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

class Animals {
    Animals() {
        System.out.println("Animal constructor is called...");
    }
}

class Horses extends Animals {
    Horses() {
        super();
        System.out.println("Horse constructor is called...."); 
    }
}

