package insat.tps.tpframework.tp_framework_service.service;

import insat.tps.tpframework.tp_framework_service.util.Response;
import insat.tps.tpframework.tp_framework_dal.domain.Admin;
import insat.tps.tpframework.tp_framework_dal.domain.Customer;

public interface UserService {
    Response createCostumer(Customer c);
    Response createAdmin(Admin c);
    Response loginCostumer(String mail , String password);
    Response loginAdmin(String mail , String password);
    Response getListUsers();
}
