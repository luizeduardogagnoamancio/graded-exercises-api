DELETE FROM GRD_EX_QUESTION WHERE CHAPTER_ID = (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Present');

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = '{
  "defaultFormat": "FILL_IN_THE_BLANK",
  "formats": {
    "FILL_IN_THE_BLANK": {"textBefore": "I", "textAfter": " tired.", "correctAnswer": "am"},
    "MULTIPLE_CHOICE": {"question": "I ___ tired.", "options": ["is", "am", "are"], "correctAnswerIndex": 1}
  }
}'
WHERE QUESTION_ID = 1;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = '{
  "defaultFormat": "FILL_IN_THE_BLANK",
  "formats": {
    "FILL_IN_THE_BLANK": {"textBefore": "You", "textAfter": " nice.", "correctAnswer": "are"},
    "MULTIPLE_CHOICE": {"question": "You ___ nice.", "options": ["is", "am", "are"], "correctAnswerIndex": 2}
  }
}'
WHERE QUESTION_ID = 2;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = '{
  "defaultFormat": "FILL_IN_THE_BLANK",
  "formats": {
    "FILL_IN_THE_BLANK": {"textBefore": "He", "textAfter": " cool.", "correctAnswer": "is"},
    "MULTIPLE_CHOICE": {"question": "He ___ cool.", "options": ["is", "am", "are"], "correctAnswerIndex": 0}
  }
}'
WHERE QUESTION_ID = 3;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = '{
  "defaultFormat": "FILL_IN_THE_BLANK",
  "formats": {
    "FILL_IN_THE_BLANK": {"textBefore": "She", "textAfter": " pretty.", "correctAnswer": "is"},
    "MULTIPLE_CHOICE": {"question": "She ___ pretty.", "options": ["is", "am", "are"], "correctAnswerIndex": 0}
  }
}'
WHERE QUESTION_ID = 4;