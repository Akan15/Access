import java.util.Scanner;

public class Main {
    public static User[] getUsersList() {
        User user1 = new User("jhon", "jhon@gmail.com", "pass", 24);
        User user2 = new User("tom", "tom@gmail.com", "tom11", 16);
        User user3 = new User("fred", "fred@gmail.com", "fredi", 21);

        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsersList();
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not fond");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Age too young");
        }
    }

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        //Проверить логин и пароль
        User user = getUserByLoginAndPassword(login, password);

        //Вызвать методы валидации пользователя
        validateUser(user);

        System.out.println("Доступ предоставлен");
    }
 }