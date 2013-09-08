package freelec.composite.employee;

/**
 * 일반 평사언에 대한 클래스
 * - 불하 직원을 가질 수 없는 경우를 표현함
 */
public class Employee {

    private String name;
    private String ssn;
    private String position;
    private int age;

    public Employee(String name, String ssn, String position, int age) {
        this.name = name;
        this.ssn = ssn;
        this.position = position;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.name = name;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
