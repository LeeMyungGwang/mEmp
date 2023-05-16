package memp.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import memp.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/users")
@Transactional
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @PutMapping("/users/search/findByUser")
    public Object findByUser(@RequestBody UserViewQuery query) {
        return usersRepository.findByUser(query.getUserName());
    }
}
