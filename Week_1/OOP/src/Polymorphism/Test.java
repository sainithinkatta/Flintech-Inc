package Polymorphism;

public class Test {
    public static void main(String[] args) {
        // Polymorphism: reference of type Animal points to different objects
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = new Animal();

        a1.makeSound(); // Dog's version
        a2.makeSound(); // Cat's version
        a3.makeSound(); // Animal's version
    }
}