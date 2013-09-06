package others.flyweight;

class Worker implements Person {
    private int pid;

    public Worker(int pid) {
        System.out.println(pid + " 일꾼을 생성 합니다.");
        this.pid = pid;
    }

    public void work() {
        System.out.println(pid + " 일꾼이 일을 합니다.");
    }
}