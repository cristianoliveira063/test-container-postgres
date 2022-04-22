DO
$$
BEGIN
        IF
NOT EXISTS
                (SELECT 1
                 FROM information_schema.columns
                 WHERE table_schema = 'public'
                   AND table_name = 'person')
        THEN
CREATE SEQUENCE public.person_seq
    INCREMENT 1
                MINVALUE 1
                MAXVALUE 9223372036854775807
                START 1
                CACHE 1;

CREATE TABLE public.person
(
    id   bigint       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT person_id_pk PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
        );


END IF;
END;
$$
LANGUAGE plpgsql;