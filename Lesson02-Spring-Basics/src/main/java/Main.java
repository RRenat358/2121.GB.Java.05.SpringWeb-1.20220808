import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.rrenat358.persist.User;
import ru.rrenat358.persist.UserRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        UserService userService = context.getBean("userService", UserService.class);
//        Cart cart1 = context.getBean("cart", Cart.class);
//        Cart cart2 = context.getBean("cart", Cart.class);
//        Cart cart3 = context.getBean("cart", Cart.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter user name: ");
            String userName = scanner.nextLine();

            System.out.println("Enter user role: ");
            String role = scanner.nextLine();

            userService.insert(new User(userName, role));

            System.out.println("New user has been added. Current users count: " + userService.findAll());

            System.out.println("Enter \"end\" to exit");
            if (scanner.nextLine().equals("end")) {
                return;
            }
        }
    }


}
