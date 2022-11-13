package ru.b00blik.enterprisehuificator.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.b00blik.enterprisehuificator.exceptions.IllegalArgumentHuificationException;
import ru.b00blik.enterprisehuificator.service.WordHuificationValidator;
import ru.b00blik.enterprisehuificator.util.HuificationUtil;

@Service
public class WordHuificationValidatorImpl implements WordHuificationValidator {

    @Override
    public boolean isHuificationPossible(String word) throws IllegalArgumentHuificationException {
        int countVowels = 0;
        for (char l : word.toCharArray()) {
            if (HuificationUtil.VOWELS_SET.contains(l)) {
                countVowels++;
            }
        }
        if (countVowels == 0 || !isWord(word))
            throw new IllegalArgumentHuificationException("No vowels in word: " + word);
        return true;
    }

    @Override
    public boolean isWord(String token) {
        if (StringUtils.isEmpty(token))
            return false;
        for (char c : token.toCharArray()) {
            if (c < 'а' || c > 'я') return false;
        }
        return true;
    }
}
