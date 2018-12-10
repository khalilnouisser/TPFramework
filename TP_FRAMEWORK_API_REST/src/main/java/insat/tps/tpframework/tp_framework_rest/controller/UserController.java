package insat.tps.tpframework.tp_framework_rest.controller;

import insat.tps.tpframework.tp_framework_dal.domain.Admin;
import insat.tps.tpframework.tp_framework_dal.domain.Customer;
import insat.tps.tpframework.tp_framework_dal.domain.dto.LoginUserDTO;
import insat.tps.tpframework.tp_framework_service.service.UserService;
import insat.tps.tpframework.tp_framework_service.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "Users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("customer")
    public Response createCustomer(@RequestBody Customer customer){
        return userService.createCostumer(customer);
    }

    @GetMapping
    public Response getListUsers(){
        return userService.getListUsers();
    }

    @PostMapping("admin")
    public Response createAdmin(@RequestBody Admin admin){
        return userService.createAdmin(admin);
    }

    @PostMapping("login/admin")
    public Response loginAdmin(@RequestBody LoginUserDTO login){
        return userService.loginAdmin(login.getEmail(),login.getPassword());
    }

    @PostMapping("login/customer")
    public Response loginCustomer(@RequestBody LoginUserDTO login){
        return userService.loginCostumer(login.getEmail(),login.getPassword());
    }

}
