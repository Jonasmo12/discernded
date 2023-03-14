CREATE TABLE patient (
    id BIGSERIAL PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    email TEXT NOT NULL,
    identityNumber TEXT NOT NULL,
);