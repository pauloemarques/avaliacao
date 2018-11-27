package br.com.theodoro.avaliacao.framework.spring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**Classe para objetos do tipo CorsFilter, onde serao contidos, informacoes e metodos para o mesmo.
* 
* @version 1.0
* 
*/
@Component
public class CorsFilter implements Filter {

	private static final Log LOGGER = LogFactory.getLog(CorsFilter.class);
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
				HttpServletResponse response = (HttpServletResponse) res;
			    HttpServletRequest request = (HttpServletRequest) req;
			    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
			    response.setHeader("Access-Control-Allow-Headers", "x-auth-token, x-requested-with");
			    response.setHeader("Access-Control-Max-Age", "3600");
			    if(!"OPTIONS".equalsIgnoreCase(request.getMethod())) {
		            chain.doFilter(req, res);
		        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("CORS Filter initialized");
	}

}
