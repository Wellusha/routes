CREATE TABLE IF NOT EXISTS atms -- таблица банкоматов
(
    id         INT AUTO_INCREMENT PRIMARY KEY, -- идентификатор банкомата
    out        INT    NOT NULL,                -- количество банкнот для извлечения
    in         INT    NOT NULL,                -- количество банкнот для поступления
    expected   DOUBLE NOT NULL,                -- мат.ожидание извлекаемых/поступаемых банкнот
    dispersion DOUBLE NOT NULL                 -- дисперсия извлекаемых/поступаемых банкнот
);

CREATE TABLE IF NOT EXISTS route_maps -- таблица перемещений
(
    id         INT AUTO_INCREMENT PRIMARY KEY, -- идентификатор перемещения между банкоматами
    atm_one    INT    NOT NULL,                -- идентификатор первого банкомата
    atm_two    INT    NOT NULL,                -- идентификатор второго банкомата
    distance   INT    NOT NULL,                -- расстояние между банкоматами
    expected   DOUBLE NOT NULL,                -- мат.ожидание времени перемещения между банкоматами
    dispersion DOUBLE NOT NULL                 -- дисперсия времени перемещения между банкоматами
);

CREATE TABLE IF NOT EXISTS collectors -- таблица групп инкасаторов
(
    id INT AUTO_INCREMENT PRIMARY KEY -- идентификатор группы инкасаторов
);

CREATE TABLE IF NOT EXISTS routes -- таблица маршрутов
(
    id        INT AUTO_INCREMENT PRIMARY KEY, -- идентификатор маршрута
    day       INT NOT NULL,                   -- идентификатор дня
    collector INT NOT NULL,                   -- идентификатор группы инкасаторов
    atm_from  INT NOT NULL,                   -- идентификатор первого банкомата
    atm_to    INT NOT NULL                    -- идентификатор второго банкомата
);

-- ограничения на внешние ключи
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

-- Костыль - банкомат с индексом 0 является условным офисом
INSERT INTO atms(id, out, in, expected, dispersion)
VALUES (0, 0, 0, 0, 0);