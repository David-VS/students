package be.ehb.student_admin.model;

import be.ehb.student_admin.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDAO extends CrudRepository<Student, Integer> {


}
