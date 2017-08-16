package com.devops.backend.persistence.repos;

import com.devops.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by XxX on 7/22/2017.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan,Integer> {
}
