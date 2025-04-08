package com.naincy.SpringWebProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naincy.SpringWebProject.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

}
