package com.alperbasak.employeemanagement.controller;


import com.alperbasak.employeemanagement.model.Employee;
import com.alperbasak.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {

   @Autowired
   EmployeeService service;

   @Autowired
   MessageSource messageSource;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public String login(ModelMap model){
        return "login";
    }

    @RequestMapping(value = {"/list"},method = RequestMethod.GET)
    public String listEmployees(ModelMap model){

        List<Employee> employees=service.findAllEmployees();
        model.addAttribute("employees",employees);
        return "allemployees";
    }

    @RequestMapping(value = {"list/new"},method = RequestMethod.GET)
    public String newEmployee(ModelMap model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        model.addAttribute("edit",false);
        return "registration";
    }

    @RequestMapping(value = {"list/new"},method = RequestMethod.POST)
    public String addEmployee(@Valid  Employee employee, BindingResult result,ModelMap model){
        if (result.hasErrors()){
            return "registration";
        }
        if (!service.isEmployeeSsnUnique(employee.getId(),employee.getSsn())){
            FieldError fieldError=new FieldError("employee","ssn", messageSource.getMessage("non.unique.ssn",new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(fieldError);
            return "registration";
        }

        service.saveEmployee(employee);
        model.addAttribute("success","Employee "+employee.getName()+" registered successfully");
        return "success";
    }

    @RequestMapping(value = {"list/edit-{ssn}-employee"},method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model){
        Employee employee=service.findBySsn(ssn);
        model.addAttribute("employee",employee);
        model.addAttribute("edit",true);
        return "registration";
    }

    @RequestMapping(value = {"list/edit-{ssn}-employee"},method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee,BindingResult result,ModelMap model,@PathVariable String ssn){
        if (result.hasErrors()){
            return "registration";
        }
        if (!service.isEmployeeSsnUnique(employee.getId(),employee.getSsn())){
            FieldError fieldError=new FieldError("employee","ssn", messageSource.getMessage("non.unique.ssn",new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(fieldError);
            return "registration";
        }

        service.updateEmployee(employee);
        model.addAttribute("success","Employee "+employee.getName()+" updated successfully");
        return "success";
    }

    @RequestMapping(value = "list/delete-{ssn}-employee",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable String ssn){
       service.deleteEmployeeBySsn(ssn);
       return "redirect:/list";
    }


}
