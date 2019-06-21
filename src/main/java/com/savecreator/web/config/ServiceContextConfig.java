package com.savecreator.web.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.savecreator.web.dao.mybatis", "com.savecreator.web.service"})
public class ServiceContextConfig {
	 
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		/* Mysql or mariaDB*/
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/board"); //blinddb2?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("qwe123");
		
		
		/* PULL 관리*/
		dataSource.setRemoveAbandoned(true);
		dataSource.setInitialSize(20);
		dataSource.setMaxActive(30);
		
		//dataSource.setRemove
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(BasicDataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver()
					.getResources("classpath:com/savecreator/web/dao/mybatis/mapper/*.xml"));
		
		return sqlSessionFactory.getObject();
	}
	
    @Bean
    public PlatformTransactionManager platformTransactionManager(BasicDataSource dataSource) {
    	return new DataSourceTransactionManager(dataSource);
    }
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		//sqlSessionFactoryBean은 맞지만 팩토리 객체를 반환하기 때문에.
		//SqlSessionFactoryBean->SqlSessionFactory로 변경하고 SqlSessionFactory return은 .getObject를 해야함
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}



/*
 * package com.savecreator.web.config;
 * 
 * import java.util.Properties;
 * 
 * import org.apache.commons.dbcp.BasicDataSource; import
 * org.apache.ibatis.session.SqlSessionFactory; import
 * org.mybatis.spring.SqlSessionFactoryBean; import
 * org.mybatis.spring.SqlSessionTemplate; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.io.support.PathMatchingResourcePatternResolver;
 * //import org.springframework.mail.javamail.JavaMailSender; //import
 * org.springframework.mail.javamail.JavaMailSenderImpl; //import
 * org.springframework.orm.hibernate5.HibernateTransactionManager; //import
 * org.springframework.orm.hibernate5.LocalSessionFactoryBean; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * @Configuration
 * 
 * @EnableTransactionManagement //Hibernate 설정
 * 
 * @ComponentScan(basePackages= {"com.newlecture.web.dao.hb",
 * "com.newlecture.web.service"}) public class ServiceContextConfig {
 * 
 * @Bean public BasicDataSource basicDataSource() {
 * 
 * BasicDataSource basicDataSource = new BasicDataSource();
 * 
 * // db 연결 설정 mssql-server // basicDataSource.setDriverClassName(
 * "com.microsoft.sqlserver.jdbc.SQLServerDriver");
 * basicDataSource.setDriverClassName(
 * "org.springframework.jdbc.datasource.DriverManagerDataSource");
 * basicDataSource.setUrl("jdbc:sqlserver://localhost;databaseName=board");
 * basicDataSource.setUsername("root"); basicDataSource.setPassword("qwe123");
 * 
 * mysql basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
 * basicDataSource.setUrl(
 * "jdbc:mysql://localhost/newlecturedb?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8"
 * ); basicDataSource.setUsername("hong"); basicDataSource.setPassword("1234");
 * 
 * // 커넥션풀 설정 basicDataSource.setRemoveAbandoned(true);
 * basicDataSource.setInitialSize(20); basicDataSource.setMaxActive(30); return
 * basicDataSource; }
 * 
 * //Hibernate 설정을 위한 Bean 객체들
 * 
 * @Bean //스프링이 깨어날때 담아주자 public LocalSessionFactoryBean sessionFactory() {
 * 
 * Properties props = new Properties(); //props.put("hibernate.dialect",
 * "org.hibernate.dialect.MySQLDialect"); props.put("hibernate.dialect",
 * "org.hibernate.dialect.SQLServerDialect"); //연결할 DB가 무엇인지 설정
 * props.put("hibernate.show_sql", "true"); //콘솔에 찍어주세요
 * 
 * LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
 * sessionFactoryBean.setDataSource(basicDataSource());
 * sessionFactoryBean.setPackagesToScan("com.newlecture.web.entity"); //스캔할곳 설정
 * sessionFactoryBean.setHibernateProperties(props); //map개체
 * 
 * return sessionFactoryBean; }
 * 
 * //sessionFactory를 위한 설정
 * 
 * @Bean public HibernateTransactionManager transactionManager() {
 * 
 * HibernateTransactionManager transactionManager = new
 * HibernateTransactionManager();
 * transactionManager.setSessionFactory(sessionFactory().getObject());
 * //transactionManager는 sessionFactory를 반환해야 하는데 위 LocalSessionFactoryBean가
 * SessionFactory를 만들었다, getObject()로 반환할 수 있다.
 * 
 * return transactionManager; }
 * 
 * //Mybatis 설정을 위한 Bean 객체들 //객체 만들 때는 SqlSessionFactoryBean, return 할 때는
 * SqlSessionFactory ok??
 * 
 * @Bean //Dao 객체를 생성하는 Mybatis의 Mapper 객체(쿼리문 포함) public SqlSessionFactory
 * sqlSessionFactoryBean(BasicDataSource basicDataSource) throws Exception { //
 * IoC 컨테이너를 뒤져서 매개변수 설정에 참조된다. ex) basicDataSource 위에서 설정한 이름 똑같이 해야 한다.
 * SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
 * sqlSessionFactory.setDataSource(basicDataSource);
 * sqlSessionFactory.setMapperLocations( new
 * PathMatchingResourcePatternResolver()
 * .getResources("classpath:com/newlecture/web/dao/mybatis/mapper/*.xml") );
 * return sqlSessionFactory.getObject(); }
 * 
 * 
 * //위에서 만든 SqlSesstionFactory를 IoC 컨테이너에서 찾아 매개변수에 자동으로 넣어주고 //
 * SqlSesstionTemplate객체를 반환하자
 * 
 * @Bean public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory
 * sqlSessionFactory) { return new SqlSessionTemplate(sqlSessionFactory); }
 * 
 * @Bean public JavaMailSender mailSender() { //이메일을 보내기 위한 준비작업
 * 
 * //이메일 보낼 때 이용할 smtp 정보 JavaMailSenderImpl mailSender = new
 * JavaMailSenderImpl(); mailSender.setDefaultEncoding("UTF-8");
 * mailSender.setHost("smtp.gmail.com"); mailSender.setPort(587);
 * mailSender.setUsername("amadeus0108@gmail.com");
 * mailSender.setPassword("Skscjswo3#");
 * 
 * //이메일 보낼 때 이용할 설정값 Properties javaMailProperties = new Properties();
 * javaMailProperties.put("mail.transport.protocol", "smtp");
 * javaMailProperties.put("mail.smtp.auth", true);
 * javaMailProperties.put("mail.smtp.starttls.enable", true);
 * javaMailProperties.put("mail.debug", true);
 * mailSender.setJavaMailProperties(javaMailProperties);
 * 
 * return mailSender;
 * 
 * }
 * 
 * 
 * }
 */