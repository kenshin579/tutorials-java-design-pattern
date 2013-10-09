package freelec.chainofresponsibility.server;

// 발생된 이벤트에 wrapper 클래스

import java.io.Serializable;

public class Notice implements Serializable {

    // 발생된 이벤트를 구분하기 위한 code 값
    private String code;

    public Notice(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

