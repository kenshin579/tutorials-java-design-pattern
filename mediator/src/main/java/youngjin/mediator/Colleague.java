package youngjin.mediator;

/**
 * setMediator:내가 중개인이니까 기억해 두십시오
 * setColleagueEnabled: 중개인이 내리는 '지시'에 해당함
 */
public interface Colleague {
    public abstract void setMediator(Mediator mediator); // Mediator을 저장

    public abstract void setColleagueEnabled(boolean enabled); // Mediator에서 유효/무효를 지시
}
