package com.devops.backend.persistence.repos;

import com.devops.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by XxX on 7/22/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    public User findByUsername(String uname);
}
