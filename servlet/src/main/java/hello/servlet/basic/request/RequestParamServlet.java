package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


/*
* 1. 파라미터 전송기능
* http://localhost:8080/request-param?username=hello&age=20
*
* */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - 시작");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - 끝");
        System.out.println();
        System.out.println("[단일 파라미터 조회]");

        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");

        for (String name : usernames) {
            System.out.println("usernames = " + name);

        }
        response.getWriter().write("ok");
    }
}
