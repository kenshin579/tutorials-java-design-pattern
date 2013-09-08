package others.nocomposite;

import java.util.ArrayList;

public class Directory {
    public Directory(String name) {
        m_name = name;
    }

    public void add(Object obj) {
        m_files.add(obj);
    }

    public void ls() {
        System.out.println(CompositeTestDrive.g_indent + m_name);
        CompositeTestDrive.g_indent.append("   ");
        for (int i = 0; i < m_files.size(); ++i) {
            Object obj = m_files.get(i);
            // Recover the type of this object
            if (obj instanceof Directory)
                ((Directory) obj).ls();
            else
                ((File) obj).ls();
//            if (obj.getClass().getName().equals("Directory"))
//                ((Directory) obj).ls();
//            else
//                ((File) obj).ls();
        }
        CompositeTestDrive.g_indent.setLength(CompositeTestDrive.g_indent.length() - 3);
    }

    private String m_name;
    private ArrayList m_files = new ArrayList();
}
