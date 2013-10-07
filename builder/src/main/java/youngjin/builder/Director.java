package youngjin.builder;

/**
 * 한 개의 문서를 만드는 클래스
 * - Director는 실제로 HTMLBuilder, TextBuilder인지 구분없이 그냥 Builder의 메서드만을 이용해서 문서를 작성하고 있다.
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {        // Builder의 Subclass의 인스턴스가 주어지므로
        this.builder = builder;               // builder 필드에 저장해 둔다.
    }

    public void construct() {                    // 문서구축
        builder.makeTitle("Greeting");           // 타이틀
        builder.makeString("아침과 낮에");          // 문자열
        builder.makeItems(new String[]{          // 개별항목
                "좋은 아침입니다",
                "안녕하세요",
        });
        builder.makeString("밤에");                // 별도의 문자열
        builder.makeItems(new String[]{           // 별도의 개별항목
                "안녕하세요",
                "안녕히 주무세요",
                "안녕히 계세요",
        });
        builder.close();                           // 문서를 완성시킨다
    }
}
