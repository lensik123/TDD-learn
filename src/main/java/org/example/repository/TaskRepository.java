package org.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.example.model.Task;

public class TaskRepository {


  private static AtomicLong ID_COUNTER = new AtomicLong();
  private List<Task> taskList;

  public TaskRepository() {
    this.taskList = new ArrayList<>();

  }

  public boolean add(Task task) {
    task.setId(ID_COUNTER.incrementAndGet());
    return taskList.add(task);
  }

  public Task getTaskById(Long id) {
    if (id == null) {
      throw new RuntimeException("ID cannot be null");
    }

    return taskList.stream()
        .filter(savedTask -> savedTask.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Da"));

  }

  public void editTask(Task task) {
    if (task == null) {
      throw new RuntimeException("Не удалось найти такую задачу");
    }

    Task savedTask = taskList.stream()
        .filter(editTask -> editTask.equals(task))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Не удалось найти задачу"));

    savedTask.setAssignTo(task.getAssignTo());
    savedTask.setAuthor(task.getAuthor());
    savedTask.setDone(task.isDone());
  }

  public void remove(Task task) {
    if (task == null) {
      throw new RuntimeException("Не удалось найти такую задачу");
    }

     taskList.stream()
        .filter(editTask -> editTask.equals(task))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Не удалось найти задачу"));

    this.taskList.remove(task);
  }
}
