package com.kyle.parking_challenge.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RatesController {

	@RequestMapping(value="/rates")
	@ResponseBody
	public String sayHello() {
		return "here are your rates";
	}
}
