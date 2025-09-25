TRUNCATE TABLE GRD_EX_QUESTION RESTART IDENTITY CASCADE;
TRUNCATE TABLE GRD_EX_CHAPTERS RESTART IDENTITY CASCADE;

INSERT INTO GRD_EX_CHAPTERS (CHAPTER_TITLE, CHAPTER_DESC) VALUES
('Verb To Be', 'Master the basics of the verb to be in its simple present form.'),
('Simple Present', 'Learn how to describe routines, habits, and general facts.'),
('Present Continuous', 'Describe actions that are happening right now, at this very moment.'),
('Simple Past', 'Learn to talk about events, actions, and situations that are finished.'),
('Articles: A, An, The', 'Understand when to use definite and indefinite articles.');

INSERT INTO GRD_EX_QUESTION (CHAPTER_ID, QUESTION_TYPE, QUESTION_CONTENT) VALUES
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Verb To Be'),
    'FILL_IN_THE_BLANK',
    '{"textBefore": "I", "textAfter": "tired.", "correctAnswer": "am"}'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Verb To Be'),
    'FILL_IN_THE_BLANK',
    '{"textBefore": "You", "textAfter": "nice.", "correctAnswer": "are"}'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Verb To Be'),
    'FILL_IN_THE_BLANK',
    '{"textBefore": "He", "textAfter": "cool.", "correctAnswer": "is"}'
),
(
    (SELECT CHAPTER_ID FROM GRD_EX_CHAPTERS WHERE CHAPTER_TITLE = 'Verb To Be'),
    'FILL_IN_THE_BLANK',
    '{"textBefore": "She", "textAfter": "pretty.", "correctAnswer": "is"}'
);