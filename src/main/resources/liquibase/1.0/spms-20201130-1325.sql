ALTER TABLE users
    ADD CONSTRAINT UC_Users_Email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT UC_Users_Username UNIQUE (username);

ALTER TABLE users
    ALTER COLUMN email SET NOT NULL;

ALTER TABLE users
    ALTER COLUMN password SET NOT NULL;
