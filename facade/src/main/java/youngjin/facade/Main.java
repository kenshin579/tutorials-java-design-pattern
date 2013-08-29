package youngjin.facade;

import youngjin.facade.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        PageMaker.makeWelcomePage("youngjin@youngjin.com", "welcome.html");
    }
}
