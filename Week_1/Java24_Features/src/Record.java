public class Record {
    public static void main(String[] args) {
        Person p = new Person("Nithin", 24);
        System.out.println("Name: " + p.name());
        System.out.println("Age: " + p.age());
        System.out.println("Person: " + p); // auto toString()
    }
}