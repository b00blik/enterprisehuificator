package ru.b00blik.enterprisehuificator.service.impl;

import org.springframework.stereotype.Service;
import ru.b00blik.enterprisehuificator.exceptions.IllegalArgumentHuificationException;
import ru.b00blik.enterprisehuificator.service.HuiReplacementService;

import static ru.b00blik.enterprisehuificator.util.HuificationUtil.VOWELS_PREFIX_MAP;
import static ru.b00blik.enterprisehuificator.util.HuificationUtil.VOWELS_SET;

@Service
public class HuiReplacementServiceImpl implements HuiReplacementService {

    private final String HUI_PREFIX = "хуй";
    private final String BLYA_PREFIX = "бля";

    @Override
    public String updateWordWithHuiSuffix(String word) {

        if (isWordIsHui(word)) {
            return HUI_PREFIX;
        }

        if (word.startsWith(BLYA_PREFIX)) {
            return word;
        }

        if (word.length() <= 3) { //for prepositions
            return word;
        }


        String syllable = getFirstSyllable(word);
        String prefix = selectPrefixForSyllable(syllable);
        word = word.replaceFirst(syllable, prefix);

        return word;
    }

    private boolean isWordIsHui(String word) {
        if (word.equalsIgnoreCase(HUI_PREFIX)) {
            return true;
        }
        return false;
    }

    private String getFirstSyllable(String word) {
        int pos = -1;
        String syllable;
        for (int i = 0; i < word.length(); i++) {
            if (VOWELS_SET.contains(word.charAt(i))) {
                pos = i;
                break;
            }
        }

        if (pos != -1) {
            syllable = word.substring(0, pos + 1);
        } else {
            throw new IllegalArgumentHuificationException("Cannot find syllable in the word: " + word);
        }

        return syllable;
    }

    private String selectPrefixForSyllable(String syllable) {
        return VOWELS_PREFIX_MAP.get(syllable.charAt(syllable.length() - 1));
    }

}
