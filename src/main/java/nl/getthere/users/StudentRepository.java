package nl.getthere.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	public Student findByEmailAddress(String email);
	public Student findByFirstName(String firstName);
	public Student findByLastName(String lastName);
}
