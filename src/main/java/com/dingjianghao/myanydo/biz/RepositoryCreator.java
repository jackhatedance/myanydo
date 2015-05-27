package com.dingjianghao.myanydo.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dingjianghao.myanydo.domain.Task;
import com.dingjianghao.oum.repository.biz.interafce.Collection;
import com.dingjianghao.oum.repository.biz.interafce.Repository;

public class RepositoryCreator {

	public void saveSamples(Repository repo) {

		List<Task> list = createSampleTasks();

		Collection<Task> collection = repo.getCollection(Task.class);

		for (Task t : list)
			collection.add(t);
	}

	private List<Task> createSampleTasks() {

		List<Task> list = new ArrayList<Task>();

		for (int i = 0; i < 100; i++) {
			Task task = new Task(String.valueOf(i), "task" + i, "", new Date(),
					false, null);

			list.add(task);
		}

		return list;
	}

}
