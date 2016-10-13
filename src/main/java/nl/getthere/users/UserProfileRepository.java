package nl.getthere.users;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by hein.dehaan on 12-10-2016.
 */
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    public UserProfile findByUserName(String userName);
}
