UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = JSONB_SET(
    QUESTION_CONTENT::jsonb,
    '{formats,DRAG_AND_DROP}',
    '{"sentenceParts": ["I", "___", " tired."], "options": ["is", "am", "are"], "correctAnswer": "am"}'::jsonb
)
WHERE QUESTION_ID = 1;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = JSONB_SET(
    QUESTION_CONTENT::jsonb,
    '{formats,DRAG_AND_DROP}',
    '{"sentenceParts": ["You", "___", " nice."], "options": ["is", "am", "are"], "correctAnswer": "are"}'::jsonb
)
WHERE QUESTION_ID = 2;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = JSONB_SET(
    QUESTION_CONTENT::jsonb,
    '{formats,DRAG_AND_DROP}',
    '{"sentenceParts": ["He", "___", " cool."], "options": ["is", "am", "are"], "correctAnswer": "is"}'::jsonb
)
WHERE QUESTION_ID = 3;

UPDATE GRD_EX_QUESTION
SET QUESTION_CONTENT = JSONB_SET(
    QUESTION_CONTENT::jsonb,
    '{formats,DRAG_AND_DROP}',
    '{"sentenceParts": ["She", "___", " pretty."], "options": ["is", "am", "are"], "correctAnswer": "is"}'::jsonb
)
WHERE QUESTION_ID = 4;