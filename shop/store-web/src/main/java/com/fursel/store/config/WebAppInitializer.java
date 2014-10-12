package com.fursel.store.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.fursel.persistence.config.PersistenceConfig;

@Order(2)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		servletContext.addListener(new RequestContextListener());
		super.onStartup(servletContext);
	}
	// {!begin addToRootContext}
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
            SecurityConfig.class,
            PersistenceConfig.class,
            CoreConfig.class
        };
    }
    // {!end addToRootContext}

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }
}
