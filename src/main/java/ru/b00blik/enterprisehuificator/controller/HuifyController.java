package ru.b00blik.enterprisehuificator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.b00blik.enterprisehuificator.api.HuifyApi;
import ru.b00blik.enterprisehuificator.exceptions.IllegalArgumentHuificationException;
import ru.b00blik.enterprisehuificator.model.FailedHuificationResponse;
import ru.b00blik.enterprisehuificator.model.RawText;
import ru.b00blik.enterprisehuificator.model.WordsList;
import ru.b00blik.enterprisehuificator.service.CommonHuificationService;

import java.util.List;

@Controller
public class HuifyController implements HuifyApi {

    @Autowired
    private CommonHuificationService commonHuificationService;

    @Override
    public ResponseEntity<RawText> textHuification(RawText rawText) {
        RawText result = new RawText();
        String textToHuify = rawText.getText();
        String huifiedText = commonHuificationService.huificateTextString(textToHuify);
        result.setText(huifiedText);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WordsList> wordsListHuification(WordsList wordsList) {
        List<String> words = wordsList.getWordsList();
        List<String> huifiedWords = commonHuificationService.huificateWordsBatch(words);
        WordsList resultList = new WordsList();
        resultList.setWordsList(huifiedWords);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentHuificationException.class)
    public ResponseEntity<FailedHuificationResponse> illegalArgumentException(IllegalArgumentHuificationException e) {
        FailedHuificationResponse response
                = new FailedHuificationResponse()
                .status(Boolean.FALSE)
                .errorDescription(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
