package ru.b00blik.enterprisehuificator.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.b00blik.enterprisehuificator.service.CommonHuificationService;
import ru.b00blik.enterprisehuificator.service.TextHuificationService;
import ru.b00blik.enterprisehuificator.service.WordHuificationService;
import ru.b00blik.enterprisehuificator.service.WordHuificationValidator;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonHuificationServiceImpl implements CommonHuificationService {

    private final WordHuificationValidator validator;
    private final WordHuificationService huificationService;
    private final TextHuificationService textHuificationService;

    @Override
    public List<String> huificateWordsBatch(List<String> words) {
        List<String> result = new ArrayList<>();

        for (String w : words) {
            w = w.toLowerCase(); //keeping lowercase for easier impl
            if (validator.isHuificationPossible(w)) {
                result.add(huificationService.huifyWord(w));
            }
        }

        return result;
    }

    @Override
    public String huificateTextString(String text) {
        text = text.toLowerCase();
        return textHuificationService.huifyTextString(text);
    }
}
