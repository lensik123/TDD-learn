package org.example.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.example.model.Task;
import org.junit.Test;

public class TaskRepositoryTest {

  @Test
  public void whenAddTaskShouldCheckThatTaskWasAdded(){
    TaskRepository taskRepository = new TaskRepository();
    Task task = new Task();
    task.setDone(false);
    task.setAssignTo("SkillFactory Student");
    task.setAuthor("Turpal Baysarov");
    taskRepository.add(task);
    boolean added = taskRepository.add(task);

    Task findByIdTask  = taskRepository.getTaskById(task.getId());

    assertTrue(added);
    assertNotNull(findByIdTask);
    assertNotNull(findByIdTask.getId());
    assertThat("Wrong assingTo", findByIdTask.getAssignTo(), is("SkillFactory Student"));
    assertThat("Wrong author", findByIdTask.getAuthor(), is ("Turpal Baysarov"));
    assertThat("Wrong done flag", findByIdTask.isDone(), is (false));
  }

  @Test
  public void whenEditTaskShouldCheckThatChangesSaved(){
    TaskRepository taskRepository = new TaskRepository();
    Task task = new Task();
    task.setDone(false);
    task.setAuthor("Turpal Baysarov");
    task.setAssignTo("SkillFactory Student");
    boolean added = taskRepository.add(task);

    Task findByIdTask = taskRepository.getTaskById(task.getId());

    assertTrue(added);
    assertNotNull(findByIdTask);
    assertNotNull(findByIdTask.getId());
    assertThat("Wrong assingTo", findByIdTask.getAssignTo(), is("SkillFactory Student"));
    assertThat("Wrong author", findByIdTask.getAuthor(), is ("Turpal Baysarov"));
    assertThat("Wrong done flag", findByIdTask.isDone(), is (false));

    findByIdTask.setAssignTo("Turpal Baysarov");
    taskRepository.editTask(findByIdTask);

    findByIdTask = taskRepository.getTaskById(task.getId());
    assertNotNull(findByIdTask);
    assertThat("Wrong assing to", findByIdTask.getAssignTo(), is ("Turpal Baysarov"));
  }

  @Test(expected = RuntimeException.class)
  public void whenRemoveTaskShouldCheckThatTaskWasRemoved(){
    TaskRepository taskRepository = new TaskRepository();

    Task task = new Task();
    task.setDone(false);
    task.setAuthor("Turpal Baysarov");
    task.setAssignTo("SkillFactory Student");
    boolean added = taskRepository.add(task);

    Task findByIdTask = taskRepository.getTaskById(task.getId());
    taskRepository.remove(findByIdTask);
    taskRepository.getTaskById(1L);

  }

}