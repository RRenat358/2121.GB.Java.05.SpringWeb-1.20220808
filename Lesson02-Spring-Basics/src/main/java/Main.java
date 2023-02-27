import ru.rrenat358.persist.User;
import ru.rrenat358.persist.UserRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter user name: ");
            String userName = scanner.nextLine();

            userRepository.insert(new User(userName));
        }
    }


}
