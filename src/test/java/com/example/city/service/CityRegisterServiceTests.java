package com.example.city.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.domain.City;
import com.example.form.CityForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRegisterServiceTests {
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityRegisterService cityRegisterService;
	
	@Autowired
	Validator validator;
	
	
	@Test
	public void test00_confirmCitySearchService() {
		System.out.println("CitySearchService=" + citySearchService);
		
	}
	
	@Test
	public void test00_confirmCityRegisterService() {
		System.out.println("CityRegisterService=" + cityRegisterService);
		
	}

	@Test
	public void test00_confirmValidator() {
		System.out.println("Validator=" + validator);
		
	}
	@Test
	public void test01_register(){
		CityForm cityForm=new CityForm();
		BindingResult errors =new BeanPropertyBindingResult(cityForm, "cityForm");
		
		cityForm.setName("xxx");
		cityForm.setCountryCode("XYZZ");
		validator.validate(cityForm, errors);
		if(errors.hasErrors()){
			System.out.println("errors"+errors);
			return;
		}
		cityRegisterService.register(cityForm,errors);
		if(errors.hasErrors()){
			System.out.println("errors"+errors);
			return;
		}
		System.out.println("city"+citySearchService.getCityById(cityForm.getId()));
		
	}
	
	
	
}
