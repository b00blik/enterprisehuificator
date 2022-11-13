package ru.b00blik.enterprisehuificator.service;

import java.util.List;

public interface CommonHuificationService {

    List<String> huificateWordsBatch(List<String> words);

    String huificateTextString(String text);

}
