package freelec.encapsulation;

/**
 * 은닉성(Encapsulation)에 대한 예제
 * - 은닉성은 클래스의 맴버 변수에 대한 외부의 클래스에서의 직접적인 접근을 통제하고 오로지 메서드를 통해
 * 접근만을 허용하는 것을 의미함
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public void setYear(int year) throws NonDateFormatException {
        if (year < 0) {
            throw new NonDateFormatException("invalid year format");
        } else {
            this.year = year;
        }
    }

    public void setMonth(int month) throws NonDateFormatException {
        if (0 > month || month > 13) {
            throw new NonDateFormatException("invalid month format");
        } else {
            this.month = month;
        }
    }

    public void setDay(int day) throws NonDateFormatException {
        if (0 > month || month > 31) {
            throw new NonDateFormatException("invalid day format");
        } else {
            this.day = day;
        }
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public static void main(String[] args) throws NonDateFormatException {
        MyDate mydate = new MyDate();

        mydate.setYear(1996);
        mydate.setMonth(12);
        mydate.setDay(25);
        System.out.println(mydate);
    }
}
