package by.filter;




import javax.imageio.spi.ServiceRegistry;
import java.io.IOException;
import java.util.Set;

import static by.utils.UrlPath.LOGIN;
import static by.utils.UrlPath.REGISTRATION;

//@WebFilter("/*")
public class AuthorizationFilter   {//implements Filter

//    private static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION);
//
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        var uri = ((HttpServletRequest) servletRequest).getRequestURI();
//        if (isPublicPath(uri) || isUserLoggedIn(servletRequest)) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            ((HttpServletResponse) servletResponse).sendRedirect("/login");
//        }
//    }
//
//    private boolean isUserLoggedIn(ServletRequest servletRequest) {
//        var user = ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
//        return user != null;
//    }
//
//    private boolean isPublicPath(String uri) {
//        return PUBLIC_PATH.stream().anyMatch(e -> uri.startsWith(e));
//    }
}
