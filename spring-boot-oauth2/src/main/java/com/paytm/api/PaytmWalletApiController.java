package com.paytm.api;

import java.util.Date;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paytm.domain.MerchantPayRequest;
import com.paytm.domain.MerchantPayResponse;

@RestController
@RequestMapping("/api")
public class PaytmWalletApiController {

	@PostMapping(value = "/wallet/merchantPay", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public MerchantPayResponse merchantPay(MerchantPayRequest request) {

		MerchantPayResponse response = null;

		response = new MerchantPayResponse();
		response.setPaytmAccountNo(request.getPaytmAccountNo());
		response.setMerchantAccountNo(request.getMerchantAccountNo());
		response.setStatus("Success");
		response.setAmount(request.getAmount());
		response.setTransactionDate(new Date());
		response.setTransactionNo(UUID.randomUUID().toString());

		return response;

	}
	
	
	@GetMapping(value = "/testing")
	public String testing() {
		return "testing";
	}

}
