CREATE TABLE users (
    id BINARY(16) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR('USER', 'ADMIN', 'OWNER') NOT NULL DEFAULT 'USER', -- User role with default 'USER'
    age INT,
    PRIMARY KEY (id)
);
SELECT DISTINCT CONCAT('[', role, ']') AS role_check FROM users;

UPDATE users SET role = TRIM(role);

SELECT * FROM users WHERE role NOT IN ('USER', 'ADMIN', 'OWNER');