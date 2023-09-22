CREATE TABLE exercise (
    _id TEXT PRIMARY KEY UNIQUE NOT NULL,
    number TEXT NOT NULL,
    title TEXT NOT NULL,
    sentence TEXT NOT NULL,
    answers TEXT[] NOT NULL
);