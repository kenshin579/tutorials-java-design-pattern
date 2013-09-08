package freelec.composite.employee;

import java.util.Vector;

/**
 * 중역은 경우에 따라서 부하직원이 될 수도 있고 간부사원이 될 수도 있다.
 */
public class Executive {

    private String name;
    private String ssn;
    private String position;
    private int age;

    // 간부사원으로서 수하의 부하직원들에 대한 정보를 저장하는 Vector
    private Vector employees;
    // 간부 사원 밑에 있는 간부 사원에 대한 정보를 저장하는 Vector
    private Vector executives;

    public Executive(String name, String ssn, String position, int age) {
        this.name = name;
        this.ssn = ssn;
        this.position = position;
        this.age = age;
        employees = new Vector();
        executives = new Vector();
    }

    public Employee getEmployee(String ssn) {

        Employee emp = null;

        for (int i = 0; i < employees.size(); i++) {
            Employee _emp = (Employee) employees.elementAt(i);
            String _ssn = _emp.getSSN();
            if (_ssn.equals(ssn)) {
                emp = _emp;
            }
        }

        return emp;

    }

    public Executive getExecutive(String ssn) {

        Executive executive = null;

        for (int i = 0; i < executives.size(); i++) {
            Executive _executive = (Executive) executives.elementAt(i);
            String _ssn = _executive.getName();
            if (_ssn.equals(ssn)) {
                executive = _executive;
            }
        }

        return executive;

    }

    // 부하 간부 사원을 추가하는 메소드
    public void addExecutive(Executive executive) {
        executives.addElement(executive);
    }

    // 부하 직원을 추가하는 메소드
    public void addEmployee(Employee employee) {
        employees.addElement(employee);
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

