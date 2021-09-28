CREATE TABLE survey
(
    id          VARCHAR(80)  NOT NULL,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status      VARCHAR(50)  NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO survey (id, name, description, status)
VALUES ('2f3ac99c88c246208334e5f24f979179', 'MERCADEO', 'Encuesta estudio mercadeo',
        '38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16'),
       ('0d8f364c9b644fc0b1b4f8798b84fb2c', 'CLEINTE', 'Encuesta satisfacion cliente',
        '38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16'),
       ('31c8c0a70df4476d8e4bc22677cf164a', 'MARCA', 'Encuesta conocimiento marca',
        '38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16'),
       ('363b88d70100443f9f2336fb24eb247b', 'PRUDUCTOS', 'Encuesta inspecion producto',
        '969e0631-2121-4965-aa4e-9779d5d6fab2'),
       ('28de502cc7c5498c8a9ad5819c890d3c', 'PUBLICIDAD', 'Encuesta inspecion publicidad',
        '38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16');

CREATE TABLE question
(
    id           VARCHAR(80) NOT NULL,
    content      VARCHAR(100),
    survey_id_fk VARCHAR(255),
    status       VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (survey_id_fk) REFERENCES survey (id)
);

INSERT INTO question(id, content, survey_id_fk, status)
VALUES ('5ef8e7a9451940acad6fc79c4a51e199', '¿Qué tan satisfecho te sientes con este producto?',
        '2f3ac99c88c246208334e5f24f979179', '38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16'),
       ('39e824f6fc884e6bb72c7709433683ea', '¿Te parece adecuado su precio?',
        '2f3ac99c88c246208334e5f24f979179', '38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16'),
       ('7c4d5e604c5f468d80fd7fd42d9a7145', '¿Por qué eliges este producto?',
        '2f3ac99c88c246208334e5f24f979179', '38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16');

CREATE TABLE customers
(
    id        VARCHAR(80)  NOT NULL,
    name      VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    phone     DECIMAL,
    email     VARCHAR(50)  NOT NULL,
    status    VARCHAR(50),
    PRIMARY KEY (id)
);


CREATE TABLE customers_answers
(
    id                    VARCHAR(80) NOT NULL,
    customer_id_fk        VARCHAR(80) NOT NULL,
    creation_date         int8        NOT NULL,
    customer_survey_id_fk VARCHAR(80) NOT NULL,
        PRIMARY KEY (id),
    FOREIGN KEY (customer_survey_id_fk) REFERENCES survey (id),
    FOREIGN KEY (customer_id_fk) REFERENCES customers (id)
);

CREATE TABLE customers_answers_detail
(
    id                   VARCHAR(80) NOT NULL,
    customers_answers_fk VARCHAR(80) NOT NULL,
    question_fk          VARCHAR(80) NOT NULL,
    answer               VARCHAR(80) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customers_answers_fk) REFERENCES customers_answers (id),
    FOREIGN KEY (question_fk) REFERENCES question (id)
);


