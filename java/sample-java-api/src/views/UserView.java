package views;

import entities.User;

public class UserView {

    public String render(User user) {
        return String.format(
                "{ \"name\": \"%s\", \"email\": \"%s\" }",
                user.getName(),
                user.getEmail()
        );
    }
}
