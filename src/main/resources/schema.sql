CREATE TABLE atms
(
    id         INT PRIMARY KEY,
    out        INT    NOT NULL,
    in         INT    NOT NULL,
    expected   DOUBLE NOT NULL,
    dispersion DOUBLE NOT NULL
);

CREATE TABLE route_maps
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    atm_one          INT NOT NULL,
    atm_two          INT NOT NULL,
    -- Будем считать в метрах
    distance_between INT NOT NULL
);

-- Предположим, что один инкассатор - это группа инкассаторов на одной машине
CREATE TABLE collectors
(
    id INT PRIMARY KEY
);

CREATE TABLE routes
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    day       INT NOT NULL,
    collector INT NOT NULL,
    atm_from  INT NOT NULL,
    atm_to    INT NOT NULL
);

ALTER TABLE route_maps
    ADD CONSTRAINT fk_atm_one FOREIGN KEY (atm_one) REFERENCES atms (id);
ALTER TABLE route_maps
    ADD CONSTRAINT fk_atm_two FOREIGN KEY (atm_two) REFERENCES atms (id);
ALTER TABLE routes
    ADD CONSTRAINT fk_collector FOREIGN KEY (collector) REFERENCES collectors (id);
ALTER TABLE routes
    ADD CONSTRAINT fk_atm_from FOREIGN KEY (atm_from) REFERENCES atms (id);
ALTER TABLE routes
    ADD CONSTRAINT fk_atm_to FOREIGN KEY (atm_to) REFERENCES atms (id);


-- Пять групп инкассаторов
INSERT INTO collectors(id)
VALUES (1),
       (2),
       (3),
       (4),
       (5);

-- Костыль - банкомат с индексом 0 является условным офисом
INSERT INTO atms(id, out, in, expected, dispersion)
VALUES (0, 0, 0, 0, 0);

-- Банкоматы для теста, значения от балды
INSERT INTO atms(id, out, in, expected, dispersion)
VALUES (1, 100, 100, 100, 10),
       (2, 100, 100, 100, 10);

INSERT INTO route_maps(atm_one, atm_two, distance_between)
VALUES (1, 2, 500),
       (1, 0, 1000),
       (2, 0, 700);