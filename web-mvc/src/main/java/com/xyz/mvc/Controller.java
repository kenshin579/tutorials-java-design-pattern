package com.xyz.mvc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private String name;
    private String ssn;
    private String phone;
    private String email;
    private String cmd;
    private String mode;

    private Student student;
    private Student studnets[];

    private Database db;

    private ServletContext context;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = config.getServletContext();
        // 오라클 사용자는 수정을 해야 한다.
        db = new Database("127.0.0.1");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // 매개 변수로 입력된 값들을 초기화 한다.
        setParameter(req);
        // 초기화 된 값을 이용해 해당 작업을 수행할 한다.
        executeQuery(cmd, res);
    }


    public void executeQuery(String cmd, HttpServletResponse res) throws IOException {

        int command = Integer.parseInt(cmd);
        student = getStudent(mode);
        // 새로운 학생을 입력할 때
        if (command == Constants.INSERT) {
            db.insert(student);
            Student[] students = db.selectAll(student, mode);
            // 서블릿 컨텍스트에 필요한 값을 저장한다.
            setAttribute("students", students);
            // 입력이 완료되면 전체 학생 리스트를 볼 수 있게 한다.
            res.sendRedirect("/member.jsp?mode=" + mode);

            // 선택된 특정 학생에대한 정보를 볼 때,
        } else if (command == Constants.VIEW) {
            setAttribute("student", student);
            res.sendRedirect("/student.jsp?mode=" + mode);

            // 선택된 특정 학생에 대한 정보를 생략할 때
        } else if (command == Constants.DELETE) {
            db.delete(student);
            Student[] students = db.selectAll(student, mode);
            setAttribute("students", students);
            res.sendRedirect("/member.jsp?mode=" + mode);

            // 검색 할 때
        } else if (command == Constants.SELECT) {
            student = db.select(student, mode);
            setAttribute("student", student);
            res.sendRedirect("/student.jsp?mode=" + mode);//*/

            // 기존의 학생 정보에서 수정이 발생할 때
        } else if (command == Constants.UPDATE) {
            db.update(student);
            Student[] students = db.selectAll(student, mode);
            setAttribute("students", students);
            res.sendRedirect("/member.jsp?mode=" + mode);
        }
    }

    // 서블릿 컨텍스트를 초기화할 때 호출되는 메소드
    public void setAttribute(String name, Object o) {
        context.setAttribute(name, o);
    }

    // 매개변수를 초기화 하는 메소드
    public void setParameter(HttpServletRequest req) {
        name = req.getParameter("name");
        ssn = req.getParameter("ssn");
        phone = req.getParameter("phone");
        email = req.getParameter("email");
        cmd = req.getParameter("cmd");
        mode = req.getParameter("mode");
    }

    // 매개 변수의 값들을 이용해 학생 객체를 생성
    public Student getStudent(String mode) {
        Student student = null;
        // 매개변수 'mode'로서 학생 상태를 분류
        if (mode.equals(Constants.FULL)) {
            student = new FullTimeStudent(name, ssn, phone, email);
        } else if (mode.equals(Constants.PART)) {
            student = new PartTimeStudent(name, ssn, phone, email);
        }
        return student;
    }
}

