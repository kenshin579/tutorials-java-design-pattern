package youngjin.mediator;

public interface Mediator {
    public abstract void createColleagues(); // Colleague들을 생성한다

    public abstract void colleagueChanged(); // Colleage에서의 통지로 Colleage의 유효/무효를 판정한다
}
