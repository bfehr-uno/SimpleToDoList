package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  age INT NOT NULL,    
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "task")
public class Task {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "duedate")
   private String dueDate;
   
   public Task() {
   }

   public Task(String name, String dueDate) {
	   this.name = name;
	   this.dueDate = dueDate;
   }
   
   public Integer getID() {
	   return id;
   }
   
   public String getName() {
      return name;
   }

   public String getDueDate() {
	  return dueDate;
   }

   @Override
   public String toString() {
      return "Task " + this.name + ", Due Date: " + this.dueDate;
   }
}