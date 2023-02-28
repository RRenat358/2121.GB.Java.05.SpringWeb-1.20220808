import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rrenat358.persist.User;
import ru.rrenat358.persist.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class UserService {

/*
    @Autowired
    @Qualifier("first")
*/
    private UserRepository userRepository;

/*
    @PostConstruct
    public void init() {
        System.out.println("Метод postConstruct отработал");
    }
*/


    public void insert(User user) {
        if(user.getRole().equals("ADMIN") || user.getRole().equals("GUEST")) {
            this.userRepository.insert(user);
        } else {
            throw new IllegalArgumentException("Incorrect role");
        }
    }

    public int findAll() {
        return this.userRepository.findAll().size();
    }

/*
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
*/


}
