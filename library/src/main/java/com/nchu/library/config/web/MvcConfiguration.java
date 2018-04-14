package com.nchu.library.config.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware{
	//spring容器
		private ApplicationContext applicationContext;

		@Override
		public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			// TODO Auto-generated method stub
			this.applicationContext=applicationContext;
			
		}
		
		/*
		 * 定义默认的请求处理器
		 */
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
		}
		/**
		 * 创建viewResolver
		 * @return
		 */
		@Bean(name="viewResolver")
		public ViewResolver createViewResolver() {
			InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
			//设置Spring容器
			viewResolver.setApplicationContext(this.applicationContext);
			//取消缓存
			viewResolver.setCache(false);
			//设置解析的前缀
			viewResolver.setPrefix("/WEB-INF/front/");
			//设置试图解析的后
			viewResolver.setSuffix(".html");
			return viewResolver;
			
		}
}
