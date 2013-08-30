package youngjin.drawer;

import command.*;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    // �׸� �׸��� ��
    private Color color = Color.red;
    // �׸� �׸��� ���� �ݰ�
    private int radius = 6;
    // �̷�
    private MacroCommand history;

    // ����
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // �̷� ��ü�� �ٽ� �׸���
    public void paint(Graphics g) {
        history.execute();
    }

    // �׸� �׸���
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
