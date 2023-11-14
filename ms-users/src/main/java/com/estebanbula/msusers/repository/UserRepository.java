package com.estebanbula.msusers.repository;

import com.estebanbula.msusers.models.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
