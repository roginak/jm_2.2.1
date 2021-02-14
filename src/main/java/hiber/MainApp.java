package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {

      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User u1 = new User("Igor", "Kan", "IKanv13@gmail.com");
      u1.setCar(new Car("Porshche Taycan 4s", 9118964));
      userService.add(u1);

      User u2 = new User("Test", "Testov", "test@gmail.com");
      u2.setCar(new Car("TestCar", 11111111));
      userService.add(u2);

      User u3 = new User("Test2", "Testov2", "test2@gmail.com");
      u3.setCar(new Car("Test2Car", 2222222));
      userService.add(u3);

      List<User> list = userService.listUsers();
      for (User user : list) {
         System.out.println(user.toString());
      }

      System.out.println(userService.getUserByCar("Porshche Taycan 4s", 9118964));

      context.close();
   }
}
