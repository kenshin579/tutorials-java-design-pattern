package freelec.chainofresponsibility.server;// Ŭ���̾�Ʈ �� GUI�� �����ϱ� ���� �߻� Ŭ����

import javax.swing.*;

public abstract class Builder {

    // ���� ���� �̺�Ʈ �߻� �Ϸ� ��ȣ
    protected static int count = 0;

    // ���̺��� colomns �� ���ϴ� �޼ҵ�
    public abstract void buildColumns();

    // ���̺? ǥ���� ������ �����ϴ� �޼ҵ�
    public abstract void buildContents();

    // ������ �㺸�ϰ� �ִ� ���̺��� �����ϴ�
    // JScrollPane�� ��ȯ�ϴ� �޼ҵ�

    public abstract JScrollPane getTable();

    // �߻�� �̺�Ʈ Ÿ��Ʋ�� ��ȯ�ϴ� �޼ҵ�
    public abstract String getTitle();

}

