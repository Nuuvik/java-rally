

CREATE TABLE IF NOT EXISTS cars
(
    id    bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    model  varchar(255)                                       NOT NULL,
    groups varchar(10)                                 NOT NULL
);

