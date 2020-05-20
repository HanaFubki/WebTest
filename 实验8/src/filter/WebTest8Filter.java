package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/WebTest8/*")
public class WebTest8Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        System.out.print("Filter : ");
        if(uri.contains("/sct_student.html")){
            int sid = 0;
            sid = (int)session.getAttribute("sid");
            System.out.println("sid : " + sid);
            System.out.println("jud : " + (sid == 0));
            if(sid != 0){
                chain.doFilter(req , resp);
            }else{
                request.getRequestDispatcher("./sct_login.html").forward(request , response);
            }
        }else if(uri.contains("/sct_teacher.html")){
            int tid = 0;
            tid = (int)session.getAttribute("tid");
            if(tid != 0){
                chain.doFilter(req , resp);
            }else{
                request.getRequestDispatcher("./sct_login.html").forward(request , response);
            }
        }
        else{
            chain.doFilter(req , resp);
            System.out.println("Success...");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
