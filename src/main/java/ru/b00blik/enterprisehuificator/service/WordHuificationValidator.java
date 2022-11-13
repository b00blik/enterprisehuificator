package ru.b00blik.enterprisehuificator.service;

public interface WordHuificationValidator {

    boolean isHuificationPossible(String word);

    boolean isWord(String token);

}
