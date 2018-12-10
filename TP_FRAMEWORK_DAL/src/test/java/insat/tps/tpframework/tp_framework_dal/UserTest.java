package insat.tps.tpframework.tp_framework_dal;

import insat.tps.tpframework.tp_framework_dal.domain.Admin;
import insat.tps.tpframework.tp_framework_dal.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TpFrameworkDalApplication.class)
public class UserTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testAddAdmin(){
        Admin admin = new Admin();
        admin.setFirstName("Khalil 2");
        admin.setLastName("Nouisser 2");
        admin.setEmail("med.khalilnouisse2r@gmail.com");
        admin.setCreateDate(new Date());
        admin.setPassword("12345");
        userRepository.save(admin);
        assert(admin.getId()>0);
    }
}
