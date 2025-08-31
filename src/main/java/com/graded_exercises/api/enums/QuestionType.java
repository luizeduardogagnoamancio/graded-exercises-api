package com.graded_exercises.api.enums;

import lombok.Getter;


@Getter
public enum QuestionType {
    FILL_IN_THE_BLANK("fill_in_the_blank"),
    MULTIPLE_CHOICE("multiple_choice"),
    DRAG_AND_DROP("drag_and_drop");

    private final String value;

    QuestionType(String value) {
        this.value = value;
    }


}
