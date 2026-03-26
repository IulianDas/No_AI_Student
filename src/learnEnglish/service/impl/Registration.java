package learnEnglish.service.impl;

import learnEnglish.entity.User;
import learnEnglish.repository.UserRepository;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Registration implements learnEnglish.service.Registration {

    public void registerUser(UserRepository repository){

        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce your Email: example@mail.com");
        String email= scanner.nextLine();
        if (checkEmail(email)){
            System.out.println("Introduce your Password: example@mail.com");
            String tempPassword= scanner.nextLine();
            if (checkPassword(tempPassword)){
                user.setId(40);
                user.setEmail(email);
                user.setPassword(tempPassword);
                repository.setUsers(user);
                System.out.println("Registered successful!");
            }else{
                System.out.println("Wrong password format.");
            }
        } else{
                System.out.println("Wrong email format or email already exist.");
            }
    }

    private boolean checkEmail(String email){
        String emailValidator = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern p = Pattern.compile(emailValidator);

        return email != null && p.matcher(email).matches();
    }

    private boolean checkPassword(String password){
      /*  String regex = "^(?=.*[0-9])"
        + "(?=.*[a-z])(?=.*[A-Z])"
        + "(?=.*[@#$%^&amp;+=])"
        + "(?=\\S+$).{8,20}";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();*/
        return true;

        }
}

