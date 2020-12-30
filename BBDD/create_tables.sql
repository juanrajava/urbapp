--
-- PostgreSQL database dump
--

-- Dumped from database version 11.9 (Debian 11.9-1.pgdg90+1)
-- Dumped by pg_dump version 12.2

-- Started on 2020-09-22 08:20:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: urbapp; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA urbapp;


ALTER SCHEMA urbapp OWNER TO postgres;

--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA urbapp; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA urbapp IS 'standard public schema';


SET default_tablespace = '';

--
-- TOC entry 203 (class 1259 OID 16424)
-- Name: direccion; Type: TABLE; Schema: urbapp; Owner: postgres
--

CREATE TABLE urbapp.direccion (
    direccion_id integer NOT NULL,
    creation_time timestamp(0) without time zone,
    remove_time timestamp(0) without time zone,
    urbanizacion_id integer
);


ALTER TABLE urbapp.direccion OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16402)
-- Name: garage; Type: TABLE; Schema: urbapp; Owner: postgres
--

CREATE TABLE urbapp.garage (
    garage_id integer NOT NULL,
    creation_time timestamp(0) without time zone,
    remove_time timestamp(0) without time zone,
    urbanizacion_id integer,
    vivienda_id integer
);


ALTER TABLE urbapp.garage OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16387)
-- Name: incidencia; Type: TABLE; Schema: urbapp; Owner: postgres
--

CREATE TABLE urbapp.incidencia (
    incidencia_id integer NOT NULL,
    creation_time timestamp(0) without time zone,
    remove_time timestamp(0) without time zone,
    persona_id integer,
    vivienda_id integer,
    urbanizacion_id integer,
    garage_id integer,
    sala_id integer
);


ALTER TABLE urbapp.incidencia OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16390)
-- Name: persona; Type: TABLE; Schema: urbapp; Owner: postgres
--

CREATE TABLE urbapp.persona (
    persona_id integer NOT NULL,
    creation_time timestamp(0) without time zone,
    remove_time timestamp(0) without time zone,
    vivienda_id integer
);


ALTER TABLE urbapp.persona OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16384)
-- Name: rol; Type: TABLE; Schema: urbapp; Owner: postgres
--

CREATE TABLE urbapp.rol (
    rol_id integer NOT NULL,
    creation_time timestamp(0) without time zone,
    remove_time timestamp(0) without time zone,
    persona_id integer
);


ALTER TABLE urbapp.rol OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16396)
-- Name: sala; Type: TABLE; Schema: urbapp; Owner: postgres
--

CREATE TABLE urbapp.sala (
    sala_id integer NOT NULL,
    creation_time timestamp(0) without time zone,
    remove_time timestamp(0) without time zone,
    urbanizacion_id integer,
    vivienda_id integer
);


ALTER TABLE urbapp.sala OWNER TO postgres;

--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE sala; Type: COMMENT; Schema: urbapp; Owner: postgres
--

COMMENT ON TABLE urbapp.sala IS 'Concepto generico de 4 paredes pero que no son habitable, vale para trasteros por ejemplo';


--
-- TOC entry 202 (class 1259 OID 16408)
-- Name: urbanizacion; Type: TABLE; Schema: urbapp; Owner: postgres
--

CREATE TABLE urbapp.urbanizacion (
    urbanizacion_id integer NOT NULL,
    creation_time timestamp(0) without time zone,
    remove_time timestamp(0) without time zone
);


ALTER TABLE urbapp.urbanizacion OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16405)
-- Name: vivienda; Type: TABLE; Schema: urbapp; Owner: postgres
--

CREATE TABLE urbapp.vivienda (
    vivienda_id integer NOT NULL,
    creation_time timestamp(0) without time zone,
    remove_time timestamp(0) without time zone,
    urbanizacion_id integer
);


ALTER TABLE urbapp.vivienda OWNER TO postgres;

--
-- TOC entry 2931 (class 0 OID 16424)
-- Dependencies: 203
-- Data for Name: direccion; Type: TABLE DATA; Schema: urbapp; Owner: postgres
--



--
-- TOC entry 2928 (class 0 OID 16402)
-- Dependencies: 200
-- Data for Name: garage; Type: TABLE DATA; Schema: urbapp; Owner: postgres
--



--
-- TOC entry 2925 (class 0 OID 16387)
-- Dependencies: 197
-- Data for Name: incidencia; Type: TABLE DATA; Schema: urbapp; Owner: postgres
--



--
-- TOC entry 2926 (class 0 OID 16390)
-- Dependencies: 198
-- Data for Name: persona; Type: TABLE DATA; Schema: urbapp; Owner: postgres
--



--
-- TOC entry 2924 (class 0 OID 16384)
-- Dependencies: 196
-- Data for Name: rol; Type: TABLE DATA; Schema: urbapp; Owner: postgres
--



--
-- TOC entry 2927 (class 0 OID 16396)
-- Dependencies: 199
-- Data for Name: sala; Type: TABLE DATA; Schema: urbapp; Owner: postgres
--



--
-- TOC entry 2930 (class 0 OID 16408)
-- Dependencies: 202
-- Data for Name: urbanizacion; Type: TABLE DATA; Schema: urbapp; Owner: postgres
--



--
-- TOC entry 2929 (class 0 OID 16405)
-- Dependencies: 201
-- Data for Name: vivienda; Type: TABLE DATA; Schema: urbapp; Owner: postgres
--



--
-- TOC entry 2789 (class 2606 OID 16443)
-- Name: direccion direccion_pk; Type: CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.direccion
    ADD CONSTRAINT direccion_pk PRIMARY KEY (direccion_id);


--
-- TOC entry 2780 (class 2606 OID 16433)
-- Name: garage garage_pk; Type: CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.garage
    ADD CONSTRAINT garage_pk PRIMARY KEY (garage_id);


--
-- TOC entry 2771 (class 2606 OID 16439)
-- Name: incidencia incidencia_pk; Type: CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.incidencia
    ADD CONSTRAINT incidencia_pk PRIMARY KEY (incidencia_id);


--
-- TOC entry 2774 (class 2606 OID 16437)
-- Name: persona persona_pk; Type: CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.persona
    ADD CONSTRAINT persona_pk PRIMARY KEY (persona_id);


--
-- TOC entry 2767 (class 2606 OID 16441)
-- Name: rol rol_pk; Type: CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.rol
    ADD CONSTRAINT rol_pk PRIMARY KEY (rol_id);


--
-- TOC entry 2776 (class 2606 OID 16435)
-- Name: sala sala_pk; Type: CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.sala
    ADD CONSTRAINT sala_pk PRIMARY KEY (sala_id);


--
-- TOC entry 2785 (class 2606 OID 16431)
-- Name: urbanizacion urbanizacion_pk; Type: CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.urbanizacion
    ADD CONSTRAINT urbanizacion_pk PRIMARY KEY (urbanizacion_id);


--
-- TOC entry 2782 (class 2606 OID 16429)
-- Name: vivienda vivenda_pk; Type: CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.vivienda
    ADD CONSTRAINT vivenda_pk PRIMARY KEY (vivienda_id);


--
-- TOC entry 2787 (class 1259 OID 16427)
-- Name: direccion_direccion_id_idx; Type: INDEX; Schema: urbapp; Owner: postgres
--

CREATE UNIQUE INDEX direccion_direccion_id_idx ON urbapp.direccion USING btree (direccion_id);


--
-- TOC entry 2778 (class 1259 OID 16421)
-- Name: garage_garage_id_idx; Type: INDEX; Schema: urbapp; Owner: postgres
--

CREATE UNIQUE INDEX garage_garage_id_idx ON urbapp.garage USING btree (garage_id);


--
-- TOC entry 2769 (class 1259 OID 16418)
-- Name: incidencia_incidencia_id_idx; Type: INDEX; Schema: urbapp; Owner: postgres
--

CREATE INDEX incidencia_incidencia_id_idx ON urbapp.incidencia USING btree (incidencia_id);


--
-- TOC entry 2772 (class 1259 OID 16419)
-- Name: persona_persona_id_idx; Type: INDEX; Schema: urbapp; Owner: postgres
--

CREATE UNIQUE INDEX persona_persona_id_idx ON urbapp.persona USING btree (persona_id);


--
-- TOC entry 2768 (class 1259 OID 16417)
-- Name: rol_rol_id_idx; Type: INDEX; Schema: urbapp; Owner: postgres
--

CREATE INDEX rol_rol_id_idx ON urbapp.rol USING btree (rol_id);


--
-- TOC entry 2777 (class 1259 OID 16420)
-- Name: sala_sala_id_idx; Type: INDEX; Schema: urbapp; Owner: postgres
--

CREATE UNIQUE INDEX sala_sala_id_idx ON urbapp.sala USING btree (sala_id);


--
-- TOC entry 2786 (class 1259 OID 16423)
-- Name: urbanizacion_urbanizacion_id_idx; Type: INDEX; Schema: urbapp; Owner: postgres
--

CREATE UNIQUE INDEX urbanizacion_urbanizacion_id_idx ON urbapp.urbanizacion USING btree (urbanizacion_id);


--
-- TOC entry 2783 (class 1259 OID 16422)
-- Name: vivenda_vivienda_id_idx; Type: INDEX; Schema: urbapp; Owner: postgres
--

CREATE UNIQUE INDEX vivenda_vivienda_id_idx ON urbapp.vivienda USING btree (vivienda_id);


--
-- TOC entry 2794 (class 2606 OID 16507)
-- Name: incidencia garage_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.incidencia
    ADD CONSTRAINT garage_fk FOREIGN KEY (garage_id) REFERENCES urbapp.garage(garage_id);


--
-- TOC entry 2790 (class 2606 OID 16474)
-- Name: rol persona_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.rol
    ADD CONSTRAINT persona_fk FOREIGN KEY (persona_id) REFERENCES urbapp.persona(persona_id);


--
-- TOC entry 2791 (class 2606 OID 16492)
-- Name: incidencia persona_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.incidencia
    ADD CONSTRAINT persona_fk FOREIGN KEY (persona_id) REFERENCES urbapp.persona(persona_id);


--
-- TOC entry 2795 (class 2606 OID 16512)
-- Name: incidencia sala_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.incidencia
    ADD CONSTRAINT sala_fk FOREIGN KEY (sala_id) REFERENCES urbapp.sala(sala_id);


--
-- TOC entry 2801 (class 2606 OID 16444)
-- Name: vivienda urbanizacion_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.vivienda
    ADD CONSTRAINT urbanizacion_fk FOREIGN KEY (urbanizacion_id) REFERENCES urbapp.urbanizacion(urbanizacion_id);


--
-- TOC entry 2799 (class 2606 OID 16449)
-- Name: garage urbanizacion_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.garage
    ADD CONSTRAINT urbanizacion_fk FOREIGN KEY (urbanizacion_id) REFERENCES urbapp.urbanizacion(urbanizacion_id);


--
-- TOC entry 2798 (class 2606 OID 16464)
-- Name: sala urbanizacion_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.sala
    ADD CONSTRAINT urbanizacion_fk FOREIGN KEY (urbanizacion_id) REFERENCES urbapp.urbanizacion(urbanizacion_id);


--
-- TOC entry 2802 (class 2606 OID 16469)
-- Name: direccion urbanizacion_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.direccion
    ADD CONSTRAINT urbanizacion_fk FOREIGN KEY (urbanizacion_id) REFERENCES urbapp.urbanizacion(urbanizacion_id);


--
-- TOC entry 2793 (class 2606 OID 16502)
-- Name: incidencia urbanizacion_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.incidencia
    ADD CONSTRAINT urbanizacion_fk FOREIGN KEY (urbanizacion_id) REFERENCES urbapp.urbanizacion(urbanizacion_id);


--
-- TOC entry 2800 (class 2606 OID 16454)
-- Name: garage vivienda_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.garage
    ADD CONSTRAINT vivienda_fk FOREIGN KEY (vivienda_id) REFERENCES urbapp.vivienda(vivienda_id);


--
-- TOC entry 2797 (class 2606 OID 16459)
-- Name: sala vivienda_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.sala
    ADD CONSTRAINT vivienda_fk FOREIGN KEY (vivienda_id) REFERENCES urbapp.vivienda(vivienda_id);


--
-- TOC entry 2796 (class 2606 OID 16487)
-- Name: persona vivienda_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.persona
    ADD CONSTRAINT vivienda_fk FOREIGN KEY (vivienda_id) REFERENCES urbapp.vivienda(vivienda_id);


--
-- TOC entry 2792 (class 2606 OID 16497)
-- Name: incidencia vivienda_fk; Type: FK CONSTRAINT; Schema: urbapp; Owner: postgres
--

ALTER TABLE ONLY urbapp.incidencia
    ADD CONSTRAINT vivienda_fk FOREIGN KEY (vivienda_id) REFERENCES urbapp.vivienda(vivienda_id);


-- Completed on 2020-09-22 08:20:33

--
-- PostgreSQL database dump complete
--

