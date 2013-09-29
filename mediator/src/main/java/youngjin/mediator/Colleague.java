package youngjin.mediator;

/**
 *
 */
public interface Colleague {
    public abstract void setMediator(Mediator mediator); // Mediator을 저장

    public abstract void setColleagueEnabled(boolean enabled); // Mediator에서 유효/무효를 지시
}
