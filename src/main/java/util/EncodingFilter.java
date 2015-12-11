package util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/5.
 */
@WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name  = "charset", value = "UTF-8"))
public class EncodingFilter implements Filter {

    private String charset;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset = filterConfig.getInitParameter("charset");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
