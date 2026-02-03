package com.assignment.restApi.repository;

import com.assignment.restApi.entities.Employee;
import com.assignment.restApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
