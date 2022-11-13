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
public class TextHuificationServiceTest {

    @Autowired
    private TextHuificationService textHuificationService;

    @Test
    public void simpleTestHuificationTest(){
        String EXPECTED_TO_HUIFY = "хуивет хуючастникам хуёревнований, хуёрогие хуюзья!";
        String textToHuify = "Привет участникам соревнований, дорогие друзья!";
        String huified = textHuificationService.huifyTextString(textToHuify);
        assertEquals(EXPECTED_TO_HUIFY, huified);
    }

}
