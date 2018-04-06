package org.smart.admin.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:application.properties" })
public abstract class BaseDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String persistenceMode;

	public Boolean isCreateMode() {
		return persistenceMode.equals("create");
	}
	
}
