package com.webmvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmvc.dto.AccountDto;
import com.webmvc.entity.Accounts;
import com.webmvc.exception.AccountNotFoundException;
import com.webmvc.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public AccountDto findAccount(int accountNo) {
		
		final AccountDto accountDto = new AccountDto();
		Optional<Accounts> accountOptional = accountRepository.findById(accountNo);
		
		accountOptional.ifPresentOrElse((account)->{
				accountDto.setAccountNo(account.getAccountNo());
				accountDto.setAccountHolderName(account.getAccountHolderName());
				accountDto.setAccountType(account.getAccountType());
				accountDto.setBalance(account.getBalance());
				accountDto.setIfscCode(account.getIfscCode());
				accountDto.setStatus(account.getStatus());
				accountDto.setUserId(account.getUser().getUserId());
		}
		, ()-> {
			throw new AccountNotFoundException("User Account Not Fond");
		});
		
		return accountDto;
	}
}
