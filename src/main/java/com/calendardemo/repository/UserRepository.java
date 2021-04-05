package com.calendardemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.calendardemo.entity.AppUsers;



@Repository
public interface UserRepository  extends JpaRepository<AppUsers, Long>{

	AppUsers findByUserName(String userName);
}
