string(62) "/usr/local/phpbin/pg_dump -i -n '"care_home_schema"' --inserts"
--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- Name: care_home_schema; Type: SCHEMA; Schema: -; Owner: jchrun
--

CREATE SCHEMA care_home_schema;


ALTER SCHEMA care_home_schema OWNER TO jchrun;

SET search_path = care_home_schema, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t_actor; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_actor (
    id integer NOT NULL,
    job character varying,
    sector character varying,
    surname character varying,
    name character varying,
    uuid character varying
);


ALTER TABLE care_home_schema.t_actor OWNER TO jchrun;

--
-- Name: t_actor_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_actor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_actor_id_seq OWNER TO jchrun;

--
-- Name: t_actor_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_actor_id_seq OWNED BY t_actor.id;


--
-- Name: t_actor_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_actor_id_seq', 5, true);


--
-- Name: t_cadre_infirmier; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_cadre_infirmier (
)
INHERITS (t_actor);


ALTER TABLE care_home_schema.t_cadre_infirmier OWNER TO jchrun;

--
-- Name: t_comment; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_comment (
    id integer NOT NULL,
    medical_staff_id integer NOT NULL,
    patient_id integer NOT NULL,
    date date,
    comment text
);


ALTER TABLE care_home_schema.t_comment OWNER TO jchrun;

--
-- Name: t_comment_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_comment_id_seq OWNER TO jchrun;

--
-- Name: t_comment_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_comment_id_seq OWNED BY t_comment.id;


--
-- Name: t_comment_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_comment_id_seq', 1, true);


--
-- Name: t_comment_medical_staff_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_comment_medical_staff_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_comment_medical_staff_id_seq OWNER TO jchrun;

--
-- Name: t_comment_medical_staff_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_comment_medical_staff_id_seq OWNED BY t_comment.medical_staff_id;


--
-- Name: t_comment_medical_staff_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_comment_medical_staff_id_seq', 1, false);


--
-- Name: t_comment_patient_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_comment_patient_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_comment_patient_id_seq OWNER TO jchrun;

--
-- Name: t_comment_patient_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_comment_patient_id_seq OWNED BY t_comment.patient_id;


--
-- Name: t_comment_patient_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_comment_patient_id_seq', 1, false);


--
-- Name: t_day_off; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_day_off (
    id integer NOT NULL,
    actor_id integer,
    begin_date date,
    end_date date
);


ALTER TABLE care_home_schema.t_day_off OWNER TO jchrun;

--
-- Name: t_day_off_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_day_off_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_day_off_id_seq OWNER TO jchrun;

--
-- Name: t_day_off_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_day_off_id_seq OWNED BY t_day_off.id;


--
-- Name: t_day_off_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_day_off_id_seq', 2, true);


--
-- Name: t_doctor; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_doctor (
    id integer NOT NULL,
    uuid character varying,
    name character varying,
    surname character varying,
    address text,
    phone character varying(10)
);


ALTER TABLE care_home_schema.t_doctor OWNER TO jchrun;

--
-- Name: t_doctor_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_doctor_id_seq OWNER TO jchrun;

--
-- Name: t_doctor_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_doctor_id_seq OWNED BY t_doctor.id;


--
-- Name: t_doctor_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_doctor_id_seq', 1, true);


--
-- Name: t_evaluation; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_evaluation (
    id integer NOT NULL,
    judge_id integer,
    candidate_id integer,
    date date,
    evaluation text
);


ALTER TABLE care_home_schema.t_evaluation OWNER TO jchrun;

--
-- Name: t_evaluation_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_evaluation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_evaluation_id_seq OWNER TO jchrun;

--
-- Name: t_evaluation_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_evaluation_id_seq OWNED BY t_evaluation.id;


--
-- Name: t_evaluation_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_evaluation_id_seq', 1, true);


--
-- Name: t_laboratory; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_laboratory (
    id integer NOT NULL,
    uuid character varying,
    name character varying,
    phone character varying(10),
    address text
);


ALTER TABLE care_home_schema.t_laboratory OWNER TO jchrun;

--
-- Name: t_laboratory_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_laboratory_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_laboratory_id_seq OWNER TO jchrun;

--
-- Name: t_laboratory_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_laboratory_id_seq OWNED BY t_laboratory.id;


--
-- Name: t_laboratory_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_laboratory_id_seq', 1, true);


--
-- Name: t_medical_staff; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_medical_staff (
    birthday date,
    ssid character varying,
    namerefering character varying
)
INHERITS (t_actor);


ALTER TABLE care_home_schema.t_medical_staff OWNER TO jchrun;

--
-- Name: t_meet; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_meet (
    id integer NOT NULL,
    medical_staff_id integer NOT NULL,
    patient_id integer NOT NULL,
    date date,
    priority character varying
);


ALTER TABLE care_home_schema.t_meet OWNER TO jchrun;

--
-- Name: t_meet_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_meet_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_meet_id_seq OWNER TO jchrun;

--
-- Name: t_meet_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_meet_id_seq OWNED BY t_meet.id;


--
-- Name: t_meet_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_meet_id_seq', 1, true);


--
-- Name: t_meet_medical_staff_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_meet_medical_staff_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_meet_medical_staff_id_seq OWNER TO jchrun;

--
-- Name: t_meet_medical_staff_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_meet_medical_staff_id_seq OWNED BY t_meet.medical_staff_id;


--
-- Name: t_meet_medical_staff_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_meet_medical_staff_id_seq', 1, false);


--
-- Name: t_meet_patient_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_meet_patient_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_meet_patient_id_seq OWNER TO jchrun;

--
-- Name: t_meet_patient_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_meet_patient_id_seq OWNED BY t_meet.patient_id;


--
-- Name: t_meet_patient_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_meet_patient_id_seq', 1, false);


--
-- Name: t_patient; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_patient (
    birthday date,
    ssid character varying,
    namerefering character varying,
    keynumber character varying,
    priority character varying,
    address character varying,
    doctor_id integer NOT NULL,
    pharmacy_id integer NOT NULL,
    laboratory_id integer NOT NULL
)
INHERITS (t_actor);


ALTER TABLE care_home_schema.t_patient OWNER TO jchrun;

--
-- Name: t_patient_doctor_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_patient_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_patient_doctor_id_seq OWNER TO jchrun;

--
-- Name: t_patient_doctor_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_patient_doctor_id_seq OWNED BY t_patient.doctor_id;


--
-- Name: t_patient_doctor_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_patient_doctor_id_seq', 1, false);


--
-- Name: t_patient_laboratory_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_patient_laboratory_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_patient_laboratory_id_seq OWNER TO jchrun;

--
-- Name: t_patient_laboratory_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_patient_laboratory_id_seq OWNED BY t_patient.laboratory_id;


--
-- Name: t_patient_laboratory_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_patient_laboratory_id_seq', 1, false);


--
-- Name: t_patient_pharmacy_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_patient_pharmacy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_patient_pharmacy_id_seq OWNER TO jchrun;

--
-- Name: t_patient_pharmacy_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_patient_pharmacy_id_seq OWNED BY t_patient.pharmacy_id;


--
-- Name: t_patient_pharmacy_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_patient_pharmacy_id_seq', 1, false);


--
-- Name: t_pharmacy; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_pharmacy (
    id integer NOT NULL,
    uuid character varying,
    name character varying,
    phone character varying(10),
    address text
);


ALTER TABLE care_home_schema.t_pharmacy OWNER TO jchrun;

--
-- Name: t_pharmacy_id_seq; Type: SEQUENCE; Schema: care_home_schema; Owner: jchrun
--

CREATE SEQUENCE t_pharmacy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE care_home_schema.t_pharmacy_id_seq OWNER TO jchrun;

--
-- Name: t_pharmacy_id_seq; Type: SEQUENCE OWNED BY; Schema: care_home_schema; Owner: jchrun
--

ALTER SEQUENCE t_pharmacy_id_seq OWNED BY t_pharmacy.id;


--
-- Name: t_pharmacy_id_seq; Type: SEQUENCE SET; Schema: care_home_schema; Owner: jchrun
--

SELECT pg_catalog.setval('t_pharmacy_id_seq', 2, true);


--
-- Name: t_responsable; Type: TABLE; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

CREATE TABLE t_responsable (
)
INHERITS (t_actor);


ALTER TABLE care_home_schema.t_responsable OWNER TO jchrun;

--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_actor ALTER COLUMN id SET DEFAULT nextval('t_actor_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_cadre_infirmier ALTER COLUMN id SET DEFAULT nextval('t_actor_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_comment ALTER COLUMN id SET DEFAULT nextval('t_comment_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_day_off ALTER COLUMN id SET DEFAULT nextval('t_day_off_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_doctor ALTER COLUMN id SET DEFAULT nextval('t_doctor_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_evaluation ALTER COLUMN id SET DEFAULT nextval('t_evaluation_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_laboratory ALTER COLUMN id SET DEFAULT nextval('t_laboratory_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_medical_staff ALTER COLUMN id SET DEFAULT nextval('t_actor_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_meet ALTER COLUMN id SET DEFAULT nextval('t_meet_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_patient ALTER COLUMN id SET DEFAULT nextval('t_actor_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_pharmacy ALTER COLUMN id SET DEFAULT nextval('t_pharmacy_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_responsable ALTER COLUMN id SET DEFAULT nextval('t_actor_id_seq'::regclass);


--
-- Data for Name: t_actor; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--



--
-- Data for Name: t_cadre_infirmier; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_cadre_infirmier VALUES (2, 'doctor', 'diagnosis', 'Cameron', 'Allison', 'uuuid_acameron');


--
-- Data for Name: t_comment; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_comment VALUES (1, 3, 5, '2013-11-02', 'Est très malade.');


--
-- Data for Name: t_day_off; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_day_off VALUES (2, 2, '2013-02-01', '2013-02-15');


--
-- Data for Name: t_doctor; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_doctor VALUES (1, 'uuid-doctor', 'Florence', 'Giacomini', '1 Place Etoile Noisy-le-Grand', '0143056644');


--
-- Data for Name: t_evaluation; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_evaluation VALUES (1, 1, 2, '2013-02-15', 'Très belle');


--
-- Data for Name: t_laboratory; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_laboratory VALUES (1, 'uuid-labo', 'Labo', '0101010101', 'adress');


--
-- Data for Name: t_medical_staff; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_medical_staff VALUES (3, 'doctor', 'urgency', 'Chase', 'Robert', 'uuid_rchase', '1975-01-03', '1750399', 'Cameron');


--
-- Data for Name: t_meet; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_meet VALUES (1, 3, 5, '2013-11-02', '1');


--
-- Data for Name: t_patient; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_patient VALUES (5, 'University', 'University', 'Descartes', 'Descartes', 'uuid-University', '1991-01-01', 'ssid-University', 'Descartes', '1234', '2', '5 boulevard Descartes 77545 Marne-la-Vallée', 1, 1, 1);


--
-- Data for Name: t_pharmacy; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_pharmacy VALUES (1, 'uuid_pharma', 'Pharmacie Gallieni', '0143035447', '11 Avenue Emile Cossonneau Noisy-le-Grand');


--
-- Data for Name: t_responsable; Type: TABLE DATA; Schema: care_home_schema; Owner: jchrun
--

INSERT INTO t_responsable VALUES (1, 'Chief Responsable', 'diagnosis', 'House', 'Gregory', 'uuid_ghouse');


--
-- Name: PK_cadre_infirmier; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_cadre_infirmier
    ADD CONSTRAINT "PK_cadre_infirmier" PRIMARY KEY (id);


--
-- Name: PK_medical_staff; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_medical_staff
    ADD CONSTRAINT "PK_medical_staff" PRIMARY KEY (id);


--
-- Name: PK_patient; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_patient
    ADD CONSTRAINT "PK_patient" PRIMARY KEY (id);


--
-- Name: PK_responsable; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_responsable
    ADD CONSTRAINT "PK_responsable" PRIMARY KEY (id);


--
-- Name: t_actor_pkey; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_actor
    ADD CONSTRAINT t_actor_pkey PRIMARY KEY (id);


--
-- Name: t_comment_pkey; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_comment
    ADD CONSTRAINT t_comment_pkey PRIMARY KEY (id);


--
-- Name: t_day_off_pkey; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_day_off
    ADD CONSTRAINT t_day_off_pkey PRIMARY KEY (id);


--
-- Name: t_doctor_pkey; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_doctor
    ADD CONSTRAINT t_doctor_pkey PRIMARY KEY (id);


--
-- Name: t_evaluation_pkey; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_evaluation
    ADD CONSTRAINT t_evaluation_pkey PRIMARY KEY (id);


--
-- Name: t_laboratory_pkey; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_laboratory
    ADD CONSTRAINT t_laboratory_pkey PRIMARY KEY (id);


--
-- Name: t_meet_pkey; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_meet
    ADD CONSTRAINT t_meet_pkey PRIMARY KEY (id);


--
-- Name: t_pharmacy_pkey; Type: CONSTRAINT; Schema: care_home_schema; Owner: jchrun; Tablespace: 
--

ALTER TABLE ONLY t_pharmacy
    ADD CONSTRAINT t_pharmacy_pkey PRIMARY KEY (id);


--
-- Name: FK_Comment_Patient; Type: FK CONSTRAINT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_comment
    ADD CONSTRAINT "FK_Comment_Patient" FOREIGN KEY (patient_id) REFERENCES t_patient(id);


--
-- Name: FK_Comment_Staff; Type: FK CONSTRAINT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_comment
    ADD CONSTRAINT "FK_Comment_Staff" FOREIGN KEY (medical_staff_id) REFERENCES t_medical_staff(id);


--
-- Name: FK_Meet_Patient; Type: FK CONSTRAINT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_meet
    ADD CONSTRAINT "FK_Meet_Patient" FOREIGN KEY (patient_id) REFERENCES t_patient(id);


--
-- Name: FK_Meet_Staff; Type: FK CONSTRAINT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_meet
    ADD CONSTRAINT "FK_Meet_Staff" FOREIGN KEY (medical_staff_id) REFERENCES t_medical_staff(id);


--
-- Name: FK_Patient_Doctor; Type: FK CONSTRAINT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_patient
    ADD CONSTRAINT "FK_Patient_Doctor" FOREIGN KEY (doctor_id) REFERENCES t_doctor(id);


--
-- Name: FK_Patient_Laboratory; Type: FK CONSTRAINT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_patient
    ADD CONSTRAINT "FK_Patient_Laboratory" FOREIGN KEY (laboratory_id) REFERENCES t_laboratory(id);


--
-- Name: FK_Patient_Pharmacy; Type: FK CONSTRAINT; Schema: care_home_schema; Owner: jchrun
--

ALTER TABLE ONLY t_patient
    ADD CONSTRAINT "FK_Patient_Pharmacy" FOREIGN KEY (pharmacy_id) REFERENCES t_pharmacy(id);


--
-- Name: care_home_schema; Type: ACL; Schema: -; Owner: jchrun
--

REVOKE ALL ON SCHEMA care_home_schema FROM PUBLIC;
REVOKE ALL ON SCHEMA care_home_schema FROM jchrun;
GRANT ALL ON SCHEMA care_home_schema TO jchrun;


--
-- PostgreSQL database dump complete
--

