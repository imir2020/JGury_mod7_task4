package by.filter;

import by.dto.UserDto;
import java.io.IOException;


//@WebFilter("/admin")
public class UnsafeFilter  {//implements Filter
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        var user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
//        if (user != null) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            ((HttpServletResponse) servletResponse).sendRedirect("/registration");
//        }
//    }
}
