import static java.lang.StringTemplate.STR;
import static java.lang.StringTemplate.FMT;

public class StringTemplates {
    public static void main(String[] args) {
        // Record in action
        Person person = new Person("Nithin", 24);

        System.out.println(person.greeting());   // custom method
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
        System.out.println("Record toString(): " + person);

        // Simple interpolation with STR
        String hello = STR."Hello, \{person.name()}! You are \{person.age()}.";

        // Expressions can be interpolated too
        String nextYear = STR."\{person.name()} turns \{person.age() + 1} next year.";

        // Using FMT: printf-style formatting
        String formatted1 = FMT."User=%s, Age=%02d".formatted(person.name(), person.age());

        // Directly embedded formatting in template
        String formatted2 = FMT."User=\{person.name()} Age=\{%02d:person.age()}";

        // Multiline template
        String multiline = STR."""
                Person Details:
                  Name = \{person.name()}
                  Age  = \{person.age()}
                """;

        // Outputs
        System.out.println(hello);
        System.out.println(nextYear);
        System.out.println(formatted1);
        System.out.println(formatted2);
        System.out.println(multiline);
    }
}
