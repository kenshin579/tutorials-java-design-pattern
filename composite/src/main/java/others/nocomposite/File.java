package others.nocomposite;

public class File {
    public File(String name) {
        m_name = name;
    }

    public void ls() {
        System.out.println(CompositeTestDrive.g_indent + m_name);
    }

    private String m_name;
}
