package com.webmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webmvc.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer>{
	
	

}
