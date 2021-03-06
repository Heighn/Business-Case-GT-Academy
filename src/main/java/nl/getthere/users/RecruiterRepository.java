package nl.getthere.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends CrudRepository<Recruiter, Long>{
    public Recruiter findByRecruiterName(String username);
}
