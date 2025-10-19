-- --- Simple Present ---
INSERT INTO GRD_EX_QUESTION (CHAPTER_ID, QUESTION_TYPE, QUESTION_CONTENT) VALUES
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Present'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "He", "textAfter": " soccer every weekend.", "correctAnswer": "plays"},
        "MULTIPLE_CHOICE": {"question": "He ___ soccer every weekend.", "options": ["play", "plays", "playing"], "correctAnswerIndex": 1},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["He", "plays", "soccer", "every", "weekend."], "shuffledOptions": ["weekend.", "soccer", "He", "every", "plays"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Present'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "They", "textAfter": " to the movies on Fridays.", "correctAnswer": "go"},
        "MULTIPLE_CHOICE": {"question": "They ___ to the movies on Fridays.", "options": ["go", "goes", "going"], "correctAnswerIndex": 0},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["They", "go", "to", "the", "movies", "on", "Fridays."], "shuffledOptions": ["Fridays.", "movies", "go", "on", "They", "the", "to"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Present'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "She", "textAfter": " not like coffee.", "correctAnswer": "does"},
        "MULTIPLE_CHOICE": {"question": "She ___ not like coffee.", "options": ["do", "does", "is"], "correctAnswerIndex": 1},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["She", "does", "not", "like", "coffee."], "shuffledOptions": ["does", "coffee.", "like", "She", "not"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Present'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "We", "textAfter": " English every day.", "correctAnswer": "study"},
        "MULTIPLE_CHOICE": {"question": "We ___ English every day.", "options": ["study", "studies", "studying"], "correctAnswerIndex": 0},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["We", "study", "English", "every", "day."], "shuffledOptions": ["day.", "study", "every", "We", "English"]}
      }
    }'
);

-- --- Present Continuous ---
INSERT INTO GRD_EX_QUESTION (CHAPTER_ID, QUESTION_TYPE, QUESTION_CONTENT) VALUES
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Present Continuous'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "She", "textAfter": " reading a book now.", "correctAnswer": "is"},
        "MULTIPLE_CHOICE": {"question": "She ___ reading a book now.", "options": ["is", "am", "are"], "correctAnswerIndex": 0},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["She", "is", "reading", "a", "book", "now."], "shuffledOptions": ["book", "She", "a", "is", "now.", "reading"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Present Continuous'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "They", "textAfter": " playing video games.", "correctAnswer": "are"},
        "MULTIPLE_CHOICE": {"question": "They ___ playing video games.", "options": ["is", "am", "are"], "correctAnswerIndex": 2},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["They", "are", "playing", "video", "games."], "shuffledOptions": ["games.", "are", "They", "playing", "video"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Present Continuous'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "I", "textAfter": " listening to music.", "correctAnswer": "am"},
        "MULTIPLE_CHOICE": {"question": "I ___ listening to music.", "options": ["is", "am", "are"], "correctAnswerIndex": 1},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["I", "am", "listening", "to", "music."], "shuffledOptions": ["music.", "listening", "am", "I", "to"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Present Continuous'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "", "textAfter": " he sleeping right now?", "correctAnswer": "Is"},
        "MULTIPLE_CHOICE": {"question": "___ he sleeping right now?", "options": ["Is", "Am", "Are"], "correctAnswerIndex": 0},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["Is", "he", "sleeping", "right", "now?"], "shuffledOptions": ["sleeping", "Is", "now?", "right", "he"]}
      }
    }'
);

-- --- Simple Past ---
INSERT INTO GRD_EX_QUESTION (CHAPTER_ID, QUESTION_TYPE, QUESTION_CONTENT) VALUES
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Past'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "He", "textAfter": " to the park yesterday.", "correctAnswer": "went"},
        "MULTIPLE_CHOICE": {"question": "He ___ to the park yesterday.", "options": ["go", "goes", "went"], "correctAnswerIndex": 2},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["He", "went", "to", "the", "park", "yesterday."], "shuffledOptions": ["park", "yesterday.", "went", "the", "He", "to"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Past'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "We", "textAfter": " a great movie last night.", "correctAnswer": "watched"},
        "MULTIPLE_CHOICE": {"question": "We ___ a great movie last night.", "options": ["watch", "watched", "watching"], "correctAnswerIndex": 1},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["We", "watched", "a", "great", "movie", "last", "night."], "shuffledOptions": ["night.", "watched", "movie", "a", "last", "great", "We"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Past'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "Did you", "textAfter": " your homework?", "correctAnswer": "finish"},
        "MULTIPLE_CHOICE": {"question": "Did you ___ your homework?", "options": ["finish", "finished", "finishing"], "correctAnswerIndex": 0},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["Did", "you", "finish", "your", "homework?"], "shuffledOptions": ["homework?", "finish", "you", "Did", "your"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Simple Past'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "She", "textAfter": " not go to the party.", "correctAnswer": "did"},
        "MULTIPLE_CHOICE": {"question": "She ___ not go to the party.", "options": ["do", "did", "does"], "correctAnswerIndex": 1},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["She", "did", "not", "go", "to", "the", "party."], "shuffledOptions": ["party.", "go", "did", "to", "She", "the", "not"]}
      }
    }'
);

-- --- Articles: A, An, The ---
INSERT INTO GRD_EX_QUESTION (CHAPTER_ID, QUESTION_TYPE, QUESTION_CONTENT) VALUES
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Articles: A, An, The'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "She is", "textAfter": " doctor.", "correctAnswer": "a"},
        "MULTIPLE_CHOICE": {"question": "She is ___ doctor.", "options": ["a", "an", "the"], "correctAnswerIndex": 0},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["She", "is", "a", "doctor."], "shuffledOptions": ["a", "doctor.", "is", "She"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Articles: A, An, The'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "He saw", "textAfter": " elephant at the zoo.", "correctAnswer": "an"},
        "MULTIPLE_CHOICE": {"question": "He saw ___ elephant at the zoo.", "options": ["a", "an", "the"], "correctAnswerIndex": 1},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["He", "saw", "an", "elephant", "at", "the", "zoo."], "shuffledOptions": ["elephant", "zoo.", "at", "He", "an", "the", "saw"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Articles: A, An, The'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "", "textAfter": " sun is shining today.", "correctAnswer": "The"},
        "MULTIPLE_CHOICE": {"question": "___ sun is shining today.", "options": ["A", "An", "The"], "correctAnswerIndex": 2},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["The", "sun", "is", "shining", "today."], "shuffledOptions": ["is", "today.", "The", "shining", "sun"]}
      }
    }'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Articles: A, An, The'),
    'FILL_IN_THE_BLANK',
    '{
      "defaultFormat": "FILL_IN_THE_BLANK",
      "formats": {
        "FILL_IN_THE_BLANK": {"textBefore": "I will be back in", "textAfter": " hour.", "correctAnswer": "an"},
        "MULTIPLE_CHOICE": {"question": "I will be back in ___ hour.", "options": ["a", "an", "the"], "correctAnswerIndex": 1},
        "SENTENCE_SCRAMBLE": {"correctOrder": ["I", "will", "be", "back", "in", "an", "hour."], "shuffledOptions": ["hour.", "an", "back", "I", "will", "in", "be"]}
      }
    }'
);