package youngjin.factorymethod.idcard;

import youngjin.factorymethod.framework.Product;

public class HealthCard extends Product {
    private String owner;

    HealthCard(String owner) {
        System.out.println(owner + "의 헬스 카드를 만듭니다.");
        this.owner = owner;
    }

    public void use() {
        System.out.println(owner + "의 헬스 카드를 사용합니다.");
    }

    public String getOwner() {
        return owner;
    }
}
