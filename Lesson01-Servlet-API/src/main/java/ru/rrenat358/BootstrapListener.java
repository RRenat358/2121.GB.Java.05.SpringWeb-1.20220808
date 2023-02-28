package ru.rrenat358;

import ru.rrenat358.persist.User;
import ru.rrenat358.persist.UserRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserRepository userRepository = new UserRepository();
        userRepository.insert(new User("Vladimir"));
        userRepository.insert(new User("Anastasia"));
        userRepository.insert(new User("Evgeniy"));
        userRepository.insert(new User("Petr"));
        sce.getServletContext().setAttribute("userRepository", userRepository);
    }
}
