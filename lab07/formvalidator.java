package lab07;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {

    @NotBlank
    String name;

    @NotBlank
    @MaxLength(10)
    String username;

    @NotBlank
    @MaxLength(20)
    String password;

    SignupForm(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}

class FormValidator {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            try {
                field.setAccessible(true);

                String value = (String) field.get(obj);

       
                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.trim().isEmpty()) {
                        errors.add(field.getName() + " cannot be blank");
                    }
                }

                
                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength max = field.getAnnotation(MaxLength.class);

                    if (value != null && value.length() > max.value()) {
                        errors.add(field.getName()
                                + " cannot be more than "
                                + max.value() + " characters");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error while checking field");
            }
        }

        return errors;
    }
}

public class formvalidator {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
                "",
                "verylongusername123",
                "mypassword"
        );

        List<String> errors = FormValidator.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}

