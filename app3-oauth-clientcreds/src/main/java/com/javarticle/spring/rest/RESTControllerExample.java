package com.javarticle.spring.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/txa")
public class RESTControllerExample {
    @RequestMapping(path = "/employees", method = RequestMethod.GET)
	@ApiOperation(
			value = "Get all employees",
			notes = "Returns first N employees specified by the size parameter with page offset specified by page parameter.",
			response = Employee.class)
    public Collection<Employee> getEmployeeNames() {
        return EmployeeSource.getEmployees();
    }

}
