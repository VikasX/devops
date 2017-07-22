package com.devops.backend.persistence.repos;

import com.devops.backend.persistence.domain.backend.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by XxX on 7/22/2017.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
