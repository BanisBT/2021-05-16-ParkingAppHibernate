CREATE TABLE public.usertable
(
    id bigint NOT NULL DEFAULT nextval('usertable_id_seq'::regclass),
    user_id character varying(55) COLLATE pg_catalog."default" NOT NULL,
    user_password character varying(55) COLLATE pg_catalog."default" NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    surname character varying(100) COLLATE pg_catalog."default" NOT NULL,
    car_number character varying(20) COLLATE pg_catalog."default",
    user_balance double precision,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    user_role character varying(22) COLLATE pg_catalog."default",
    CONSTRAINT usertable_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.usertable
    OWNER to hibernate_parking;

-- Table: public.parking_ticket

-- DROP TABLE public.parking_ticket;


CREATE TABLE public.parking_zone
(
    id bigint NOT NULL DEFAULT nextval('parking_zone_id_seq'::regclass),
    zone_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cost_per_hour double precision NOT NULL,
    fine double precision NOT NULL,
    CONSTRAINT parking_zone_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.parking_zone
    OWNER to hibernate_parking;

-- Table: public.parking_ticket

-- DROP TABLE public.parking_ticket;

CREATE TABLE public.parking_ticket
(
    id bigint NOT NULL DEFAULT nextval('parking_ticket_id_seq'::regclass),
    usertable_id bigint NOT NULL,
    parking_zone_id bigint NOT NULL,
    parking_city character varying(25) COLLATE pg_catalog."default" NOT NULL,
    parking_status character varying(15) COLLATE pg_catalog."default" NOT NULL,
    began_parking date NOT NULL,
    end_parking date,
    amount_ticket double precision NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT parking_ticket_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.parking_ticket
    OWNER to hibernate_parking;

-- Table: public.parking_fine

-- DROP TABLE public.parking_fine;

CREATE TABLE public.parking_fine
(
    id bigint NOT NULL DEFAULT nextval('parking_fine_id_seq'::regclass),
    usertable_id bigint NOT NULL,
    parking_zone_id bigint NOT NULL,
    parking_city character varying(25) COLLATE pg_catalog."default" NOT NULL,
    parking_status character varying(15) COLLATE pg_catalog."default" NOT NULL,
    fine_date_time date NOT NULL,
    amount_fine double precision NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT parking_fine_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.parking_fine
    OWNER to hibernate_parking;