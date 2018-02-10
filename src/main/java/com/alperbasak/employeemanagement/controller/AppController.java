package com.alperbasak.employeemanagement.controller;


import com.alperbasak.employeemanagement.model.Employee;
import com.alperbasak.employeemanagement.service.EmployeeService;
import com.alperbasak.employeemanagement.service.UserService;
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
public class AppController {

   @Autowired
   EmployeeService employeeService;

   @Autowired
    UserService userService;

   @Autowired
   MessageSource messageSource;


    @RequestMapping(value = {"/","/list"},method = RequestMethod.GET)
    public String listEmployees(ModelMap model){

        List<Employee> employees= employeeService.findAllEmployees();
        model.addAttribute("employees",employees);
        return "allemployees";
    }

    @RequestMapping(value = {"/new"},method = RequestMethod.GET)
    public String newEmployee(ModelMap model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        model.addAttribute("edit",false);
        return "registration";
    }

    @RequestMapping(value = {"/new"},method = RequestMethod.POST)
    public String addEmployee(@Valid  Employee employee, BindingResult result,ModelMap model){
        if (result.hasErrors()){
            return "registration";
        }
        if (!employeeService.isEmployeeSsnUnique(employee.getId(),employee.getSsn())){
            FieldError fieldError=new FieldError("employee","ssn", messageSource.getMessage("non.unique.ssn",new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(fieldError);
            return "registration";
        }

        employeeService.saveEmployee(employee);
        model.addAttribute("success","Employee "+employee.getName()+" registered successfully");
        return "success";
    }

    @RequestMapping(value = {"/edit-{ssn}-employee"},method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model){
        Employee employee= employeeService.findBySsn(ssn);
        model.addAttribute("employee",employee);
        model.addAttribute("edit",true);
        return "registration";
    }

    @RequestMapping(value = {"/edit-{ssn}-employee"},method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee,BindingResult result,ModelMap model,@PathVariable String ssn){
        if (result.hasErrors()){
            return "registration";
        }
        if (!employeeService.isEmployeeSsnUnique(employee.getId(),employee.getSsn())){
            FieldError fieldError=new FieldError("employee","ssn", messageSource.getMessage("non.unique.ssn",new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(fieldError);
            return "registration";
        }

        employeeService.updateEmployee(employee);
        model.addAttribute("success","Employee "+employee.getName()+" updated successfully");
        return "success";
    }

    @RequestMapping(value = "/delete-{ssn}-employee",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable String ssn){
       employeeService.deleteEmployeeBySsn(ssn);
       return "redirect:/list";
    }


}
