package com.example.spring.Spring.Security;
import com.example.spring.Spring.Security.repeating.RepeatRule;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Rule;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class AbstractFakerTest {
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Spy
    protected Faker faker;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);


        Logger rootLogger = LogManager.getLogManager().getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        rootLogger.setLevel(Level.INFO);
        for (Handler h : handlers) {
            h.setLevel(Level.INFO);
        }
    }
}
