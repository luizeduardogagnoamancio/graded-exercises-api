UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = JSONB_SET(
    QUESTION_CONTENT::jsonb,
    '{formats,SENTENCE_SCRAMBLE}',
    '{"correctOrder": ["I", "am", "tired."], "shuffledOptions": ["tired.", "I", "am"]}'::jsonb
)
WHERE QUESTION_ID = 1;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = JSONB_SET(
    QUESTION_CONTENT::jsonb,
    '{formats,SENTENCE_SCRAMBLE}',
    '{"correctOrder": ["You", "are", "nice."], "shuffledOptions": ["nice.", "You", "are"]}'::jsonb
)
WHERE QUESTION_ID = 2;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = JSONB_SET(
    QUESTION_CONTENT::jsonb,
    '{formats,SENTENCE_SCRAMBLE}',
    '{"correctOrder": ["He", "is", "cool."], "shuffledOptions": ["cool.", "is", "He"]}'::jsonb
)
WHERE QUESTION_ID = 3;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = JSONB_SET(
    QUESTION_CONTENT::jsonb,
    '{formats,SENTENCE_SCRAMBLE}',
    '{"correctOrder": ["She", "is", "pretty."], "shuffledOptions": ["is", "pretty.", "She"]}'::jsonb
)
WHERE QUESTION_ID = 4;