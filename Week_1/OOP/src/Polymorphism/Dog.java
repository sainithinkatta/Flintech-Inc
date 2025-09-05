package Polymorphism;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog says: Woof woof!");
    }
}