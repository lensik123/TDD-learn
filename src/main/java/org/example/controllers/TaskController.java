package org.example.controllers;

import org.example.service.TaskService;

public class TaskController {

  private TaskService taskService;


  public TaskController(){
    this.taskService = new TaskService();
  }


}
