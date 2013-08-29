package freelec.clonetest;

public class Person implements Cloneable {

    private String ssn;
    private String name;
    private int age;

    public Person(String ssn, String name, int age) {
        this.ssn = ssn;
        this.name = name;
        this.age = age;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Object myClone() throws CloneNotSupportedException {
        Object obj = super.clone();
        return obj;
    }

}
