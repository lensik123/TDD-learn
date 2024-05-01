package org.example.model;


import java.util.Objects;
import lombok.Data;

@Data
public class Task {

  private Long id;
  private String author;
  private String assignTo;
  private boolean done;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return done == task.done && Objects.equals(id, task.id) && Objects.equals(
        author, task.author) && Objects.equals(assignTo, task.assignTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, author, assignTo, done);
  }
}
