package youngjin.mediator;

/**
 * Mediator 구현제(LoginFrame)와 Colleague 구성요소(ColleagueCheckbox, etc)간에
 * 인터페이스(정의된 메서드)를 통해서 서로 통신을 함
 * <p/>
 * 통신하는 방법:
 * - LoginFrame (Mediator 인터페이스)
 * ㅁ. textUser.setColleagueEnabled(false) 메서드로 구성요소에게 지시를 함
 * <p/>
 * - ColleagueCheckbox/Button/TextField (Colleague 인터페이스)
 * ㅁ. 저장된 mediator.collegeChanged() 메서드를 호출함
 */
public class Main {
    static public void main(String args[]) {
        new LoginFrame("Mediator Sample");
    }
}
