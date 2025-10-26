package com.graded_exercises.api.enums;

import lombok.Getter;


@Getter
public enum QuestionType {
    FILL_IN_THE_BLANK("fill_in_the_blank"),
    MULTIPLE_CHOICE("multiple_choice"),
    SENTENCE_SCRAMBLE("sentence_scramble");

    private final String value;

    QuestionType(String value) {
        this.value = value;
    }


}
