package com.ankush.mavenshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.ankush.mavenshop")
@PropertySource("classpath:/com/ankush/mavenshop/config/mysqldb.properties")
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Autowired
	Environment env;

	@Bean
	public JdbcTemplate getJDBCTemplate() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.setDriverClassName"));
		ds.setUrl(env.getProperty("db.setUrl"));
		ds.setUsername(env.getProperty("db.setUsername"));
		ds.setPassword(env.getProperty("db.setPassword"));
		return new JdbcTemplate(ds);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**").addResourceLocations("/WEB-INF/assets/");
	}

}
