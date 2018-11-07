package test;

import model.AllRequestsThread;
import model.Types;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllRequestsThreadTest {
    Types t;
    AllRequestsThread a;
    @BeforeEach
    void setUp() {
    }

    @Test
    void getTypes() {
        if(t != null && a != null) {
            Assertions.assertEquals(t.Obsolete(), a.getTypes());
        }
    }
}