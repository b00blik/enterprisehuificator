package ru.b00blik.enterprisehuificator.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class WordHuificationServiceTest {

    @Autowired
    private WordHuificationService wordHuificationService;

    @Test
    public void testSimpleHuification() {
        String EXPECTED_TO_HUIFY = "хуёдопровод";
        String toHuify = "водопровод";
        String huified = wordHuificationService.huifyWord(toHuify);
        assertEquals(EXPECTED_TO_HUIFY, huified);
    }

}
