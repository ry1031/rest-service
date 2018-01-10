package org.demo.controller;

import org.demo.service.DataFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "Data Feed API")
@RestController
public class DataFeedController {

	@Autowired
	private DataFeedService dataFeedService;

	@RequestMapping(method = RequestMethod.POST, value = "/feed")
	public @ResponseBody String feed(@RequestParam(value = "successcode") String successCode,
			@RequestParam(value = "Ref") String orderRef,
			@RequestParam(value = "PayRef") String paymentRef) {
		
		System.out.print(successCode);
		
		dataFeedService.updateAppointment(orderRef, paymentRef, "0".equals(successCode));
		
		return "OK";
	}
}
