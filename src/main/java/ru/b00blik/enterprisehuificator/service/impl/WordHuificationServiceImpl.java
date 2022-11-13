package ru.b00blik.enterprisehuificator.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.b00blik.enterprisehuificator.service.HuiReplacementService;
import ru.b00blik.enterprisehuificator.service.WordHuificationService;

@Service
@RequiredArgsConstructor
public class WordHuificationServiceImpl implements WordHuificationService {

    private final HuiReplacementService huiReplacementService;

    @Override
    public String huifyWord(String word) {
        return huiReplacementService.updateWordWithHuiSuffix(word);
    }
}
