package com.employee.controller;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.Person;
import com.employee.exception.BadRequestException;

@RestController
@RequestMapping("/person")
public class PersonController {

	@PostMapping(path= "/new")
	public String getPersonInfo(@RequestBody @Valid Person person, Errors errors) throws BadRequestException {
		if (errors.hasErrors())
			throw new BadRequestException("ER-400", errors);

		return "valid response!";
	}

}
