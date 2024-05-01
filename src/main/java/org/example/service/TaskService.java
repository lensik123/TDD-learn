package org.example.service;

import org.example.repository.TaskRepository;

public class TaskService {

  private TaskRepository taskRepository;

  public TaskService(){
    this.taskRepository = new TaskRepository();
  }
}
