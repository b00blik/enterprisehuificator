package ru.b00blik.enterprisehuificator.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.b00blik.enterprisehuificator.service.TextHuificationService;
import ru.b00blik.enterprisehuificator.service.WordHuificationService;
import ru.b00blik.enterprisehuificator.service.WordHuificationValidator;

import java.util.StringTokenizer;

@Service
@RequiredArgsConstructor
public class TextHuificationServiceImpl implements TextHuificationService {

    private final WordHuificationService wordHuificationService;
    private final WordHuificationValidator validator;

    @Override
    public String huifyTextString(String text) {
        text = text.toLowerCase();
        StringTokenizer tokenizer = new StringTokenizer(text, ",;.!? ", true);
        StringBuilder resultBuilder = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            String s = tokenizer.nextToken().trim();
            if (validator.isWord(s)) {
                String huifiedWord = wordHuificationService.huifyWord(s);
                resultBuilder.append(huifiedWord);
            } else {
                if (s.isEmpty()) {
                    resultBuilder.append(" ");
                } else {
                    resultBuilder.append(s);
                }
            }
        }

        return resultBuilder.toString().trim();
    }
}
