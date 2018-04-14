package com.nchu.library.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
//配置mapper的扫描路径
@MapperScan("com.nchu.library.dao")
public class DataSourceConfiguration {
	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUsername;
	@Value("${jdbc.password}")
	private String jdbcPassword;
	/**
	 * 生成与Spring-dao.xml对应的bean dataSource
	 * @throws PropertyVetoException 
	 * 
	 */
	@Bean(name="dataSource")
	public ComboPooledDataSource createDataSoure() throws PropertyVetoException {
		//生成datasource实例
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		
		dataSource.setDriverClass(jdbcDriver);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(jdbcUsername);
		//密码
		dataSource.setPassword(jdbcPassword);
		//连接池最大线程数
		dataSource.setMaxPoolSize(30);
		//连接池最小线程数
		dataSource.setMinPoolSize(10);
		//关闭连接后不自动commit
		dataSource.setAutoCommitOnClose(false);
		//连接超时时间
		dataSource.setCheckoutTimeout(10000);
		//连接失败重试次数
		dataSource.setAcquireRetryAttempts(2);
		return dataSource;
	}


}
