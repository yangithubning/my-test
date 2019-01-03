package com.xfqb.test.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @Description 描述
 * 
 * @author ning yan
 * 
 * @Date 2019年1月2日 下午6:08:17
 * 
 */
@Configuration
@MapperScan(basePackages = { "com.xfqb.test.mapper.second" }, sqlSessionTemplateRef = "autoTestSqlSessionTemplate")
public class AutoTestMybatisConfig {
	@Bean(name = "autoTestDataSource")
	@ConfigurationProperties(prefix = "second.datasource")
	public DataSource autoTestDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public SqlSessionTemplate autoTestSqlSessionTemplate(
			@Qualifier("autoTestSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
		return template;
	}

	@Bean
	public SqlSessionFactory autoTestSqlSessionFactory(@Qualifier("autoTestDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);

		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath*:mappers/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
