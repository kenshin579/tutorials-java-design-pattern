package youngjin.chainofresponsibility;

/**
 * support 메서드는 추상 메서드 resolve를 이용한 Template Method 패턴을 사용했음
 */
public abstract class Support {
    private String name;                    // 이 트러블 해결자의 이름
    private Support next;                   // 떠넘기는 곳

    public Support(String name) {           // 트러블 해결자의 생성
        this.name = name;
    }

    public Support setNext(Support next) {  // 떠넘기는 곳을 설정
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {   // 트러블 해결의 수순
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    public String toString() {              // 문자열 표현
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble); // 해결용 메소드

    protected void done(Trouble trouble) {             // 해결
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {               // 미해결
        System.out.println(trouble + " cannot be resolved.");
    }
}
