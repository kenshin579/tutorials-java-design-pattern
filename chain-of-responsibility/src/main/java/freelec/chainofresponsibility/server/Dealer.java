package freelec.chainofresponsibility.server;

// Chain Responsiblity pattern 에서의 최상의 추상 클래스

import freelec.chainofresponsiblity.client.Exchange;
import freelec.chainofresponsiblity.client.Fund;
import freelec.chainofresponsiblity.client.Stock;

public abstract class Dealer {

    // 발생한 이벤트를 처리하지 못할 경우, 이벤트에 처리를 위임 받을 Dealer 객체
    private Dealer nextdealer;

    // 발생한 이벤트에 대한 정보를 클라이언트 통보할 수 있는 객체
    protected Market market;

    // 금융 상품들에 대한 배열
    protected static Stock stocks[];
    protected static Fund funds[];
    protected static Exchange exchanges[];

    // 테이타 베이스에 대한 Wrapper 클래스
    protected static Wrapper wrap = Wrapper.getInstance();

    public Dealer() {
    }


    // 이벤트 처리를 위임 받을 Dealer 객체 명시하는 메소드
    public void setNextDealer(Dealer nextdealer) {
        this.nextdealer = nextdealer;
    }

    // 이벤트 처리를 위임 받은 객체를 호출하는 메소드
    public Dealer getNextDealer() {
        return nextdealer;
    }

    // 이벤트 처리가 명시될 추상 메소드
    // 하위 클래스에서 이를 재정의함
    public abstract boolean getSolution(Notice notice);

    // 클라이언트 측에 이벤트를 통보하는 메소드
    // 역시 하위 클래스에서 이를 재정의함
    public abstract void sendMessageToClient();

    // 이벤트 처리를 총괄하는 메소드

    public void sendMessage(Notice notice) {

        // Notice 객체를 처리할 수 있는지 여부를 확인함
        if (getSolution(notice)) {

            // 처리할 수 있다면, 발생된 이벤트를 클라이언트에게 통보
            sendMessageToClient();

            // 처리할 수 없는 이벤트는 이를 위임 받은 dealer 객체에 위임함
        } else if (getNextDealer() == null) {

            // 위임 받는 클래스가 존재하지 않을 경우 예외 사항이 발생됨
            try {
                throw new DealerNotFoundException();
            } catch (DealerNotFoundException e) {
                System.out.println(e);
            }
        } else {

            // 이벤트 처리를 위임 받은 객체가 있다면 이를 처리하도록 함
            nextdealer.sendMessage(notice);
        }
    }

}
