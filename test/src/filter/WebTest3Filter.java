package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class WebTest3Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        System.out.print("Filter : ");
        if(uri.contains("/FilterTest.jsp") || uri.contains("/A.png")){
            String name = "";
            name = (String)session.getAttribute("user_name");
            if(name != null){
                chain.doFilter(req , resp);
                System.out.println("Success...");
            }else{
                request.getRequestDispatcher("./WebTest3.html").forward(request , response);
                System.out.println("Failed...");
            }
        }else{
            chain.doFilter(req , resp);
            System.out.println("Success...");
        }
        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
