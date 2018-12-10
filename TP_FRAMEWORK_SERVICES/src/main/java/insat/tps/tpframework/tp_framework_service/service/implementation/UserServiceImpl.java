package insat.tps.tpframework.tp_framework_service.service.implementation;

import insat.tps.tpframework.tp_framework_dal.domain.User;
import insat.tps.tpframework.tp_framework_dal.repository.AdresseRepository;
import insat.tps.tpframework.tp_framework_service.service.UserService;
import insat.tps.tpframework.tp_framework_service.util.PasswordHasher;
import insat.tps.tpframework.tp_framework_service.util.Response;
import insat.tps.tpframework.tp_framework_service.util.ResultState;
import insat.tps.tpframework.tp_framework_dal.domain.Admin;
import insat.tps.tpframework.tp_framework_dal.domain.Customer;
import insat.tps.tpframework.tp_framework_dal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserRepository<Customer> customerRepository;

    @Autowired
    private UserRepository<Admin> adminRepository;

    @Autowired
    private AdresseRepository adresseRepository;

    public Response createCostumer(Customer c) {
        if (userRepository.findByEmail(c.getEmail()) != null)
            return new Response(ResultState.ERROR, "Email already exist", null);
        c.setCreateDate(new Date());
        c.setPassword(PasswordHasher.hash(c.getPassword()));
        adresseRepository.save(c.getShipingAdresse());
        customerRepository.save(c);
        return new Response(ResultState.SUCCESS, "", c);
    }

    public Response createAdmin(Admin c) {
        if (userRepository.findByEmail(c.getEmail()) != null)
            return new Response(ResultState.ERROR, "Email already exist", null);
        c.setCreateDate(new Date());
        c.setPassword(PasswordHasher.hash(c.getPassword()));
        adminRepository.save(c);
        return new Response(ResultState.SUCCESS, "", c);
    }

    public Response loginCostumer(String mail, String password) {
        String passwordHashed = PasswordHasher.hash(password);
        try {
            Customer customer = customerRepository.findByEmailAndPassword(mail, passwordHashed);
            return new Response(customer != null ? ResultState.SUCCESS : ResultState.ERROR, customer == null ? "Wrong password" : "", customer);
        }
        catch (Exception e){
            return new Response(ResultState.ERROR,"Wrong password",null);
        }
    }

    public Response loginAdmin(String mail, String password) {
        String passwordHashed = PasswordHasher.hash(password);
        try {
            Admin admin = adminRepository.findByEmailAndPassword(mail, passwordHashed);
            return new Response(admin != null ? ResultState.SUCCESS : ResultState.ERROR, admin == null ? "Wrong password" : "", admin);
        }
        catch (Exception e){
            return new Response(ResultState.ERROR,"Wrong password",null);
        }
    }

    public Response getListUsers() {
        Iterable<User> users = userRepository.findAll();
        return new Response(ResultState.SUCCESS, "", users);
    }
}
