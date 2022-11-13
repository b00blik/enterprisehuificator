package ru.b00blik.enterprisehuificator.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HuificationUtil {

    public static final Character[] VOWELS_ARARY = new Character[]{'а', 'у', 'о', 'ы', 'э', 'я', 'ю', 'ё', 'и', 'е'};

    public static final Map<Character, String> VOWELS_PREFIX_MAP = Map.of(
            'а', "хуя",
            'у', "хую",
            'о', "хуё",
            'ы', "хуи",
            'э', "хуе",
            'я', "хуя",
            'ю', "хую",
            'ё', "хуё",
            'и', "хуи",
            'е', "хуе"
    );

    public static final Set<Character> VOWELS_SET = new HashSet<>(Arrays.asList(VOWELS_ARARY));

}
