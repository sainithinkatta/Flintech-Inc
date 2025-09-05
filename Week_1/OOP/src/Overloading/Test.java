package Overloading;

public class Test {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("Add ints: " + c.add(5, 10));
        System.out.println("Add doubles: " + c.add(5.5, 10.5));
        System.out.println("Add 3 ints: " + c.add(1, 2, 3));
    }
}