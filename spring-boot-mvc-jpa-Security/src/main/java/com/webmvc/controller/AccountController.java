package com.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webmvc.dto.AccountDto;
import com.webmvc.exception.AccountNotFoundException;
import com.webmvc.security.beans.UserDetailsImpl;
import com.webmvc.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/find.htm")
	public String showFindAccount() {
		return "find-account";
	}

	@PostMapping("/find.htm")
	public String findAccount(@RequestParam("accountNo") String accountNo, Model model) throws AccessDeniedException {

		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		UserDetailsImpl userDetails = null;
		boolean isCustomerRole = false;

		isCustomerRole = authentication.getAuthorities().stream().map(t -> {
			return t.getAuthority();
		} ).anyMatch(authority -> authority.equals("customer"));
		
		AccountDto account = accountService.findAccount(Integer.parseInt(accountNo));
		
		
		if(isCustomerRole) {
			userDetails = (UserDetailsImpl) authentication.getPrincipal();
			
			if(userDetails.getUserId() != account.getUserId()) {
				throw new AccessDeniedException("You are not Authorised to access another customer's account no");
			}
		}

		
		model.addAttribute("account", account);

		return "account-details";
	}

	@ExceptionHandler(AccountNotFoundException.class)
	public String handleAccountNotFoundException(AccountNotFoundException e) {

		return "account-error";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDeniedException(AccessDeniedException e) {
		
		return "forbidden";
	}
}
