package com.dingjianghao.myanydo.biz;

import com.dingjianghao.myanydo.domain.Task;
import com.dingjianghao.myanydo.view.AppView;
import com.dingjianghao.oum.view.annotation.Interaction;
import com.dingjianghao.oum.view.annotation.View;

/**
 * the application model for current user, at session level.
 * 
 * @author jack
 * 
 */
@View(clazz = AppView.class, menus = { "System" })
public class Application {

	private String title = "MyAny.do";

	public Application() {
	}

	public String getTitle() {
		return this.title;
	}

	@Interaction(category = "System", index = 1)
	public String addTask(Task task) {
		return "ok";
	}

}
