package freelec.clonetest;

public class PatternInJava {

    public static void main(String[] args) {
        String ssn = "7411218";
        String name = "kimch";
        int age = 27;

        Person person = new Person(ssn, name, age);
        Person _person = null;

        try {
            _person = (Person) person.myClone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        boolean flag = person.equals(_person);

        System.out.println("person == _person ? " + flag);
//        System.out.println("person.getName() : " + person.getName());
//        System.out.println("_person.getName() : " + _person.getName());
        _person.setName("Frank");
        System.out.println(person);
        System.out.println(_person);
    }
}
