package youngjin.chainofresponsibilityQ4;

/**
 * Handler(처리자)의 역할 담당:
 * - '다음 사람'을 준비해 두고 자신이 처리할 수 없는 요구가 나오면 그 사람에게 떠넘기기를 함
 * - 요구처리를 담당 -> support 메서드
 * <p/>
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
        Support current = this;

        while (current != null) {
            if (current.resolve(trouble)) {
                current.done(trouble);
                break;
            } else if (current.next == null) {
                current.fail(trouble);
            }
            current = current.next;
        }

    }

    public String toString() {              // 문자열 표현
        return "[" + name + "]";
    }

    /**
     * Q: 여기에서 protected로 정의한 이유는 (설계자의 의도는)?
     * - 설계자의 의도: Support 클래스의 인스턴스에 대해서 다른 클래스에서 '트러블 해결'을 의뢰할 때에는
     * resolve 메서드가 아닌 support 메서드를 사용하고 싶다는 의도가 표현되어 있음
     * <p/>
     * - resolve 메서드를 public으로 하면 다른 곳에서 직접 resolve 메서드를 호출하여 의도하지 않은 방법으로
     * 사용될 수 있는 위험성이 있음
     * <p/>
     * - 주의: 이 추상 클래스를 상속한 하위 클래스에서 보일고 동일한 패키지의 클래스에서도 보인다.
     *
     * @param trouble
     * @return
     */
    protected abstract boolean resolve(Trouble trouble); // 해결용 메소드

    protected void done(Trouble trouble) {             // 해결
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {               // 미해결
        System.out.println(trouble + " cannot be resolved.");
    }
}
