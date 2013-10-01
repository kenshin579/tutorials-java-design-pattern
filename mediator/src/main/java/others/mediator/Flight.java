package others.mediator;

public class Flight implements Command {
    private IATCMediator atcMediator;

    public Flight(IATCMediator atcMediator) { //중개자를 저장함
        this.atcMediator = atcMediator;
    }

    public void land() {
        if (atcMediator.isLandingOk()) {
            System.out.println("Landing done....");
            atcMediator.setLandingStatus(true);         //중개자에게 통지를 해줌 (landing했다고)
        } else
            System.out.println("Will wait to land....");
    }

    public void getReady() {
        System.out.println("Getting ready...");
    }

}