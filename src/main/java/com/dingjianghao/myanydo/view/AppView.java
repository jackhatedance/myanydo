package com.dingjianghao.myanydo.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hsqldb.rights.User;

import com.dingjianghao.myanydo.biz.Application;
import com.dingjianghao.myanydo.domain.Task;
import com.dingjianghao.oum.client.web.WebView;
import com.dingjianghao.oum.client.web.component.WebComponent;
import com.dingjianghao.oum.client.web.component.builder.WebViewBuilder;
import com.dingjianghao.oum.interaction.input.Input;
import com.dingjianghao.oum.interaction.input.StringInput;
import com.dingjianghao.oum.repository.biz.interafce.Repository;
import com.dingjianghao.oum.repository.biz.interafce.RepositoryContextUtils;
import com.dingjianghao.oum.view.EntityGrid;
import com.dingjianghao.oum.view._abstract.components.Label;
import com.dingjianghao.oum.view._abstract.components.TextBox;
import com.dingjianghao.oum.view._abstract.components.containers.window.FormDialog;
import com.dingjianghao.oum.view._abstract.components.containers.window.MainWindow;
import com.dingjianghao.oum.view._abstract.components.menu.MenuBar;
import com.dingjianghao.oum.view.builder.MenuBuilder;
import com.dingjianghao.oum.view.event.AbstractEventListener;

public class AppView extends MainWindow {

	TextBox tbname;

	Label lblGreetUser;
	Label lblTime;

	EntityGrid entityGrid;

	Application app;

	public AppView() {
		init();
	}

	private void init() {

		setName("oumDemo");
		setTitle("OUM Demo");

		lblGreetUser = new Label();
		// lblGreetUser.setText(getap);
		footPanel.addChild(lblGreetUser);

		lblTime = new Label();
		lblTime.setText((new Date()).toString());

		footPanel.addChild(lblTime);

		addEventListener(EVENT_BEFORE_REFRESH, new AbstractEventListener() {

			@Override
			public void process(String eventName, Object[] parameters) {
				// update time label
				lblTime.setText((new Date()).toString());

				// lblGreetUser.setText(app.getGreetMsg());
			}
		});

		Repository repo = RepositoryContextUtils.getRepository();

		entityGrid = new EntityGrid(repo.getCollection(Task.class),
				repo.getEntityMeta(Task.class));
		entityGrid.getPagingation().setPageSize(7);
		entityGrid.refreshGrid();

		bodyPanel.addChild(entityGrid);

	}

	@Override
	public void setModel(Object model) {
		super.setModel(model);

		app = (Application) getModel();

		setTitle(app.getTitle());

		// create menu from app object

		MenuBar menuBar = new MenuBar();
		MenuBuilder.build(model, menuBar);

		getMenuPanel().addChild(menuBar);

	}

	public static void main(String[] args) {

		WebViewBuilder builder = new WebViewBuilder();

		AppView view = new AppView();

		WebView webView = builder.build(view);
		WebComponent hc = webView.getRootContentWebComponent();
		System.out.println(webView.getDoc().outerHtml());

		Input input = new StringInput("foo");
		List<Input> inputs = new ArrayList<Input>();
		inputs.add(input);

		FormDialog form = new FormDialog(inputs);

		webView = builder.build(form);
		hc = webView.getRootContentWebComponent();
		// System.out.println(webView.getDoc().outerHtml());

	}

}
