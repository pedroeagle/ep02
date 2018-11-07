package test;

import model.User;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

class UserTest {
    User u;
    @org.junit.jupiter.api.BeforeEach //inicializa um objeto da classe em que será feito os testes
    void setUp() {
        u = new User();
    }
    @org.junit.jupiter.api.Test
    void createUser() {
        try {
            Assertions.assertEquals(true, u.CreateUser("",""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void loginUser() {
        try {
            Assertions.assertEquals(true, u.LoginUser("", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}