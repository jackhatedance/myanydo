package com.dingjianghao.myanydo.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dingjianghao.oum.repository.biz.interafce.Repository;

@Component
public class SpringContextListener implements
		ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private Repository repo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		RepositoryCreator creator = new RepositoryCreator();

		// init repo
		creator.saveSamples(repo);

	}
}
