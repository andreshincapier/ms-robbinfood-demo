CREATE TABLE survey
(
    id          varchar(80) NOT NULL,
    name        varchar(100),
    description varchar(255),
    status      varchar(50),
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