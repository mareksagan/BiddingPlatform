--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS biddingplatformdb;
--
-- Name: biddingplatformdb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE biddingplatformdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE biddingplatformdb OWNER TO postgres;

\connect biddingplatformdb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    street character varying(100) NOT NULL,
    building integer,
    apartment integer,
    city character varying(100) NOT NULL,
    country_id integer NOT NULL,
    id uuid NOT NULL
);


ALTER TABLE public.address OWNER TO postgres;

--
-- Name: bid; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bid (
    "timestamp" timestamp without time zone DEFAULT now() NOT NULL,
    amount double precision NOT NULL,
    id uuid NOT NULL,
    client_id uuid NOT NULL,
    item_id uuid NOT NULL
);


ALTER TABLE public.bid OWNER TO postgres;

--
-- Name: blacklist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.blacklist (
    client_id uuid NOT NULL,
    blacklisted_client_id uuid NOT NULL,
    id uuid NOT NULL
);


ALTER TABLE public.blacklist OWNER TO postgres;

--
-- Name: card; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.card (
    number bigint NOT NULL,
    ccv character varying(3) NOT NULL,
    id uuid NOT NULL,
    exp_year integer NOT NULL,
    exp_month integer NOT NULL
);


ALTER TABLE public.card OWNER TO postgres;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cart (
    id uuid NOT NULL,
    client_id uuid NOT NULL
);


ALTER TABLE public.cart OWNER TO postgres;

--
-- Name: cart_orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cart_orders (
    id uuid NOT NULL,
    cart_id uuid NOT NULL,
    order_id uuid NOT NULL
);


ALTER TABLE public.cart_orders OWNER TO postgres;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    name character varying(200) NOT NULL,
    partof uuid,
    id uuid NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Name: country; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.country (
    name character varying(50) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.country OWNER TO postgres;

--
-- Name: discount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discount (
    item_id uuid,
    category_id uuid,
    active boolean NOT NULL,
    id uuid NOT NULL,
    client_id uuid,
    percentage double precision NOT NULL
);


ALTER TABLE public.discount OWNER TO postgres;

--
-- Name: discount_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discount_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discount_id_seq OWNER TO postgres;

--
-- Name: fee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fee (
    id uuid NOT NULL,
    category_id uuid NOT NULL,
    percentage double precision NOT NULL
);


ALTER TABLE public.fee OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    id uuid NOT NULL,
    seller_id uuid NOT NULL,
    "desc" character varying(200) NOT NULL,
    category_id uuid NOT NULL,
    amount integer NOT NULL,
    price double precision NOT NULL,
    due timestamp without time zone NOT NULL,
    active boolean NOT NULL,
    height double precision,
    length double precision,
    width double precision,
    weight double precision,
    allow_bidding boolean DEFAULT true NOT NULL
);


ALTER TABLE public.item OWNER TO postgres;

--
-- Name: item_photos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item_photos (
    id uuid NOT NULL,
    item_id uuid NOT NULL,
    photo_id uuid NOT NULL
);


ALTER TABLE public.item_photos OWNER TO postgres;

--
-- Name: message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message (
    sender_id uuid NOT NULL,
    receiver_id uuid NOT NULL,
    text character varying(1000),
    id uuid NOT NULL
);


ALTER TABLE public.message OWNER TO postgres;

--
-- Name: order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."order" (
    id uuid NOT NULL,
    item_id uuid NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public."order" OWNER TO postgres;

--
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment (
    id uuid NOT NULL,
    "timestamp" timestamp without time zone DEFAULT now() NOT NULL,
    total_amount double precision NOT NULL,
    card_id uuid
);


ALTER TABLE public.payment OWNER TO postgres;

--
-- Name: payout; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payout (
    id uuid NOT NULL,
    bank_name character varying(50) NOT NULL,
    swift_nr bigint NOT NULL,
    client_id uuid NOT NULL,
    "timestamp" timestamp without time zone DEFAULT now() NOT NULL,
    amount double precision NOT NULL
);


ALTER TABLE public.payout OWNER TO postgres;

--
-- Name: photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.photo (
    id uuid NOT NULL,
    url character varying(200) NOT NULL,
    height integer,
    width integer
);


ALTER TABLE public.photo OWNER TO postgres;

--
-- Name: review; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.review (
    item_id uuid NOT NULL,
    reviewer_id uuid NOT NULL,
    text character varying(400) NOT NULL,
    id uuid NOT NULL,
    stars integer NOT NULL
);


ALTER TABLE public.review OWNER TO postgres;

--
-- Name: shipping; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shipping (
    id uuid NOT NULL,
    company character varying(80) NOT NULL,
    amount double precision,
    days integer NOT NULL
);


ALTER TABLE public.shipping OWNER TO postgres;

--
-- Name: transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transaction (
    payment_id uuid NOT NULL,
    id uuid NOT NULL,
    cart_id uuid NOT NULL,
    finished boolean NOT NULL
);


ALTER TABLE public.transaction OWNER TO postgres;

--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id uuid NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    cart_id uuid,
    address_id uuid NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(200) NOT NULL,
    company_name character varying(80),
    tax_id integer,
    balance double precision DEFAULT 0 NOT NULL,
    is_admin boolean DEFAULT false NOT NULL
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- Name: watchlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.watchlist (
    client_id uuid NOT NULL,
    item_id uuid NOT NULL,
    id uuid NOT NULL
);


ALTER TABLE public.watchlist OWNER TO postgres;

--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.address (street, building, apartment, city, country_id, id) VALUES ('Na porici', 5, 4, 'Prague', 2, 'bcc782c4-4881-43bf-be63-74e1044e0bbd');
INSERT INTO public.address (street, building, apartment, city, country_id, id) VALUES ('Rakowiecka', 7, 6, 'Warsaw', 1, '2872fbb6-0391-479b-b84d-2f09efa31f43');
INSERT INTO public.address (street, building, apartment, city, country_id, id) VALUES ('Las Palmas', 80, 1, 'San Jose', 3, '8c1bb582-fa77-4365-bc6a-5595f270cb07');


--
-- Data for Name: bid; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.bid ("timestamp", amount, id, client_id, item_id) VALUES ('2018-12-17 04:06:36.922975', 12, 'e481ba2f-1251-4298-ab2b-00b756db6134', '4ec24d84-43c6-4978-984c-42773ce7b8e9', '2d5136f3-4ade-448c-bbd5-f101be83a49a');
INSERT INTO public.bid ("timestamp", amount, id, client_id, item_id) VALUES ('2018-12-17 04:06:36.922975', 15, 'e7968f1e-5f33-480f-bb70-ec89abb9bced', '2872fbb6-0391-479b-b84d-2f09efa31f43', '2d5136f3-4ade-448c-bbd5-f101be83a49a');


--
-- Data for Name: blacklist; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.blacklist (client_id, blacklisted_client_id, id) VALUES ('2872fbb6-0391-479b-b84d-2f09efa31f43', '4ec24d84-43c6-4978-984c-42773ce7b8e9', '4635a4db-b016-42c0-88c5-b8ec8647c6c7');


--
-- Data for Name: card; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.card (number, ccv, id, exp_year, exp_month) VALUES (5326452564952223, '013', 'eac4c2f1-de8f-434a-b29e-9c308b681256', 2027, 8);
INSERT INTO public.card (number, ccv, id, exp_year, exp_month) VALUES (4808684913084643, '368', '028f2626-1b4f-4f99-9e2b-e04f268c4b6e', 2027, 9);
INSERT INTO public.card (number, ccv, id, exp_year, exp_month) VALUES (5289774609659900, '788', 'fca727f5-ac58-4607-98c9-3820ef821246', 2019, 1);


--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cart (id, client_id) VALUES ('8858e9c4-d23f-45aa-a952-16e3d4582967', '2872fbb6-0391-479b-b84d-2f09efa31f43');


--
-- Data for Name: cart_orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cart_orders (id, cart_id, order_id) VALUES ('17b72f24-079f-4b12-bb52-19bf8ffa4117', '8858e9c4-d23f-45aa-a952-16e3d4582967', '4e6fd7d0-8314-4014-bd37-f01535f3883b');
INSERT INTO public.cart_orders (id, cart_id, order_id) VALUES ('5279ab6f-978a-4f79-9db7-9ac421929fa1', '8858e9c4-d23f-45aa-a952-16e3d4582967', 'fcaba228-3a77-44c0-8938-c88b961b72a1');


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.category (name, partof, id) VALUES ('Home', NULL, '2ceea620-0824-4f77-85d5-ad9b63563f70');
INSERT INTO public.category (name, partof, id) VALUES ('Garden', '2ceea620-0824-4f77-85d5-ad9b63563f70', '53254d4e-2b80-43c3-a1ec-0e2425c767af');
INSERT INTO public.category (name, partof, id) VALUES ('Black Friday', NULL, '606c3b44-f585-4ec7-91b7-4b773c432670');


--
-- Data for Name: country; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.country (name, id) VALUES ('Czech Republic', 1);
INSERT INTO public.country (name, id) VALUES ('Poland', 2);
INSERT INTO public.country (name, id) VALUES ('Costa Rica', 3);


--
-- Data for Name: discount; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.discount (item_id, category_id, active, id, client_id, percentage) VALUES (NULL, '606c3b44-f585-4ec7-91b7-4b773c432670', true, '5585be23-b147-41dd-82ef-30716dc87d57', NULL, 40);


--
-- Data for Name: fee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.fee (id, category_id, percentage) VALUES ('3488e84d-aaa6-4ab5-984b-323ab0a74541', '2ceea620-0824-4f77-85d5-ad9b63563f70', 1.5);
INSERT INTO public.fee (id, category_id, percentage) VALUES ('03ac5a8e-111f-4365-8df4-128c499af828', '606c3b44-f585-4ec7-91b7-4b773c432670', 1.75);


--
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.item (id, seller_id, "desc", category_id, amount, price, due, active, height, length, width, weight, allow_bidding) VALUES ('f2bfa094-2736-469f-b207-f474e2c03f28', '4ec24d84-43c6-4978-984c-42773ce7b8e9', 'Lampa', '606c3b44-f585-4ec7-91b7-4b773c432670', 20, 78, '2018-12-15 17:21:30.147', true, 23, 5, 5, 4, false);
INSERT INTO public.item (id, seller_id, "desc", category_id, amount, price, due, active, height, length, width, weight, allow_bidding) VALUES ('2d5136f3-4ade-448c-bbd5-f101be83a49a', '423ef4e8-2630-49bf-84f4-8e76a9d7447a', 'Dildo', '2ceea620-0824-4f77-85d5-ad9b63563f70', 1, 54, '2018-12-15 17:21:30.147', true, 23, 5, 5, 0.232999995350837708, true);
INSERT INTO public.item (id, seller_id, "desc", category_id, amount, price, due, active, height, length, width, weight, allow_bidding) VALUES ('45010957-7da2-4251-b98f-501981668bf7', '423ef4e8-2630-49bf-84f4-8e76a9d7447a', 'Krzeslo', '53254d4e-2b80-43c3-a1ec-0e2425c767af', 20, 56, '2018-12-15 17:21:30.147', false, 23, 5, 5, 12, false);


--
-- Data for Name: item_photos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.item_photos (id, item_id, photo_id) VALUES ('85269594-7b25-4695-ad5d-80172c8a6dd3', 'f2bfa094-2736-469f-b207-f474e2c03f28', '30df055c-0521-4dd1-892c-13fc7dd44731');
INSERT INTO public.item_photos (id, item_id, photo_id) VALUES ('e6141a97-3c2d-45aa-a251-b1a7f25a2ad4', '2d5136f3-4ade-448c-bbd5-f101be83a49a', '6663d71a-44b6-47f9-aa33-232e46267c5e');
INSERT INTO public.item_photos (id, item_id, photo_id) VALUES ('f28ece88-7597-40f1-b551-17b06a50c9e5', '45010957-7da2-4251-b98f-501981668bf7', '6663d71a-44b6-47f9-aa33-232e46267c5e');
INSERT INTO public.item_photos (id, item_id, photo_id) VALUES ('ab86eddd-2d87-4c64-9d04-e8c5675ef2c9', '45010957-7da2-4251-b98f-501981668bf7', '30df055c-0521-4dd1-892c-13fc7dd44731');


--
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.message (sender_id, receiver_id, text, id) VALUES ('423ef4e8-2630-49bf-84f4-8e76a9d7447a', '2872fbb6-0391-479b-b84d-2f09efa31f43', 'hey', '0ebb8db4-31fc-4c4d-99cb-c55b7b63b3cd');
INSERT INTO public.message (sender_id, receiver_id, text, id) VALUES ('2872fbb6-0391-479b-b84d-2f09efa31f43', '4ec24d84-43c6-4978-984c-42773ce7b8e9', 'hello', 'c83eff49-687e-4912-8379-94dfc57bda32');
INSERT INTO public.message (sender_id, receiver_id, text, id) VALUES ('4ec24d84-43c6-4978-984c-42773ce7b8e9', '2872fbb6-0391-479b-b84d-2f09efa31f43', 'you moron', '5f19bca6-2315-4daf-8c9f-307f1ff3ea1e');
INSERT INTO public.message (sender_id, receiver_id, text, id) VALUES ('4ec24d84-43c6-4978-984c-42773ce7b8e9', '2872fbb6-0391-479b-b84d-2f09efa31f43', 'you idiot', '89435e5f-b14b-4c8c-b772-ae5a9202a999');


--
-- Data for Name: order; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."order" (id, item_id, quantity) VALUES ('4e6fd7d0-8314-4014-bd37-f01535f3883b', 'f2bfa094-2736-469f-b207-f474e2c03f28', 2);
INSERT INTO public."order" (id, item_id, quantity) VALUES ('fcaba228-3a77-44c0-8938-c88b961b72a1', '45010957-7da2-4251-b98f-501981668bf7', 8);


--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.payment (id, "timestamp", total_amount, card_id) VALUES ('c9e69031-426d-4cc2-b285-196c86248601', '2018-12-14 00:06:36.451', 12.3000001907348633, 'eac4c2f1-de8f-434a-b29e-9c308b681256');
INSERT INTO public.payment (id, "timestamp", total_amount, card_id) VALUES ('0ae953e1-98c8-4cf1-a5ab-f3b0f958df3c', '2018-12-11 00:05:43.609', 11.4499998092651367, '028f2626-1b4f-4f99-9e2b-e04f268c4b6e');
INSERT INTO public.payment (id, "timestamp", total_amount, card_id) VALUES ('16f0cc8b-fd72-4b2b-a36f-65e29ccf80d2', '2018-12-07 00:05:50.306', 90, 'fca727f5-ac58-4607-98c9-3820ef821246');


--
-- Data for Name: payout; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.payout (id, bank_name, swift_nr, client_id, "timestamp", amount) VALUES ('534bd321-5ebb-48fd-817b-672e0f538614', 'AirBank', 4354553634, '423ef4e8-2630-49bf-84f4-8e76a9d7447a', '2018-12-15 16:54:09.871528', 0);


--
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.photo (id, url, height, width) VALUES ('30df055c-0521-4dd1-892c-13fc7dd44731', 'https://d3f650ayx9w00n.cloudfront.net/940/54359-002.jpg', 300, 600);
INSERT INTO public.photo (id, url, height, width) VALUES ('6663d71a-44b6-47f9-aa33-232e46267c5e', 'https://d3f650ayx9w00n.cloudfront.net/940/54359-062.jpg', NULL, NULL);


--
-- Data for Name: review; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.review (item_id, reviewer_id, text, id, stars) VALUES ('2d5136f3-4ade-448c-bbd5-f101be83a49a', '2872fbb6-0391-479b-b84d-2f09efa31f43', 'OK', '58610f5e-96fd-4af4-8d71-512df6a757dc', 2);
INSERT INTO public.review (item_id, reviewer_id, text, id, stars) VALUES ('2d5136f3-4ade-448c-bbd5-f101be83a49a', '4ec24d84-43c6-4978-984c-42773ce7b8e9', 'Alright', 'af7d5823-f37f-49dd-9e42-e0c41dc64c9b', 3);


--
-- Data for Name: shipping; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.shipping (id, company, amount, days) VALUES ('4811c1e4-6cff-4be0-ab8c-fabc9bd85c31', 'Post', 10, 3);
INSERT INTO public.shipping (id, company, amount, days) VALUES ('e4d4bed5-a453-459e-9d29-3899ca8932c4', 'Fedex', 30, 1);
INSERT INTO public.shipping (id, company, amount, days) VALUES ('0c4de3dc-dc5c-4e66-bba9-11e263349d97', 'UPS', 40, 2);


--
-- Data for Name: transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.transaction (payment_id, id, cart_id, finished) VALUES ('16f0cc8b-fd72-4b2b-a36f-65e29ccf80d2', 'a6fff1c0-8ce4-4f42-b95b-443bd7d61c57', '8858e9c4-d23f-45aa-a952-16e3d4582967', false);


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."user" (id, first_name, last_name, cart_id, address_id, email, password, company_name, tax_id, balance, is_admin) VALUES ('4ec24d84-43c6-4978-984c-42773ce7b8e9', 'Luis', 'Sanchez', NULL, '8c1bb582-fa77-4365-bc6a-5595f270cb07', 'luiss345@mail.cr', 'luis02', '', NULL, 12, false);
INSERT INTO public."user" (id, first_name, last_name, cart_id, address_id, email, password, company_name, tax_id, balance, is_admin) VALUES ('2872fbb6-0391-479b-b84d-2f09efa31f43', 'Jiri', 'Drahos', NULL, 'bcc782c4-4881-43bf-be63-74e1044e0bbd', 'jiridrah5453@seznam.cz', 'jiri02', '', NULL, 69, false);
INSERT INTO public."user" (id, first_name, last_name, cart_id, address_id, email, password, company_name, tax_id, balance, is_admin) VALUES ('423ef4e8-2630-49bf-84f4-8e76a9d7447a', 'Marcin', 'Puchacki', NULL, '2872fbb6-0391-479b-b84d-2f09efa31f43', 'puchacz09@wp.pl', 'marcin02', '', NULL, 0, true);


--
-- Data for Name: watchlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.watchlist (client_id, item_id, id) VALUES ('423ef4e8-2630-49bf-84f4-8e76a9d7447a', '2d5136f3-4ade-448c-bbd5-f101be83a49a', '5d60abeb-5eb8-4573-b90c-7db0bc619edb');
INSERT INTO public.watchlist (client_id, item_id, id) VALUES ('2872fbb6-0391-479b-b84d-2f09efa31f43', '45010957-7da2-4251-b98f-501981668bf7', '65bfa57b-8bdc-4560-b3e4-706519e14e57');


--
-- Name: discount_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.discount_id_seq', 1, false);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1100, true);


--
-- Name: address address_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pk PRIMARY KEY (id);


--
-- Name: cart_orders cart_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_orders
    ADD CONSTRAINT cart_orders_pkey PRIMARY KEY (id);


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (id);


--
-- Name: category category_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pk PRIMARY KEY (id);


--
-- Name: blacklist client_blacklist_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.blacklist
    ADD CONSTRAINT client_blacklist_pk PRIMARY KEY (id);


--
-- Name: message client_message_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT client_message_pk PRIMARY KEY (id);


--
-- Name: review client_reviews_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT client_reviews_pk PRIMARY KEY (id);


--
-- Name: transaction client_transactions_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT client_transactions_pk PRIMARY KEY (id);


--
-- Name: watchlist client_watchlist_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watchlist
    ADD CONSTRAINT client_watchlist_pk PRIMARY KEY (id);


--
-- Name: country country_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.country
    ADD CONSTRAINT country_pk PRIMARY KEY (id);


--
-- Name: discount discount_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discount
    ADD CONSTRAINT discount_pk PRIMARY KEY (id);


--
-- Name: fee fee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fee
    ADD CONSTRAINT fee_pkey PRIMARY KEY (id);


--
-- Name: bid item_bids_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bid
    ADD CONSTRAINT item_bids_pk PRIMARY KEY (id);


--
-- Name: item_photos item_photos_pkey1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_photos
    ADD CONSTRAINT item_photos_pkey1 PRIMARY KEY (id);


--
-- Name: item item_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pk PRIMARY KEY (id);


--
-- Name: order order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (id);


--
-- Name: card payment_card_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.card
    ADD CONSTRAINT payment_card_pk PRIMARY KEY (id);


--
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id);


--
-- Name: payout payout_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payout
    ADD CONSTRAINT payout_pk PRIMARY KEY (id);


--
-- Name: photo photo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_pkey PRIMARY KEY (id);


--
-- Name: shipping shipping_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shipping
    ADD CONSTRAINT shipping_pkey PRIMARY KEY (id);


--
-- Name: user user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- Name: address_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX address_id_uindex ON public.address USING btree (id);


--
-- Name: cart_orders_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX cart_orders_id_uindex ON public.cart_orders USING btree (id);


--
-- Name: category_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX category_id_uindex ON public.category USING btree (id);


--
-- Name: client_blacklist_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX client_blacklist_id_uindex ON public.blacklist USING btree (id);


--
-- Name: client_message_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX client_message_id_uindex ON public.message USING btree (id);


--
-- Name: client_transactions_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX client_transactions_id_uindex ON public.transaction USING btree (id);


--
-- Name: client_watchlist_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX client_watchlist_id_uindex ON public.watchlist USING btree (id);


--
-- Name: country_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX country_id_uindex ON public.country USING btree (id);


--
-- Name: discount_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX discount_id_uindex ON public.discount USING btree (id);


--
-- Name: fee_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX fee_id_uindex ON public.fee USING btree (id);


--
-- Name: item_bids_client_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX item_bids_client_id_uindex ON public.bid USING btree (client_id);


--
-- Name: item_bids_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX item_bids_id_uindex ON public.bid USING btree (id);


--
-- Name: order_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX order_id_uindex ON public."order" USING btree (id);


--
-- Name: payment_card_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX payment_card_id_uindex ON public.card USING btree (id);


--
-- Name: payout_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX payout_id_uindex ON public.payout USING btree (id);


--
-- Name: shipping_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX shipping_id_uindex ON public.shipping USING btree (id);


--
-- Name: user_email_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX user_email_uindex ON public."user" USING btree (email);


--
-- Name: address address_country_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_country_id_fk FOREIGN KEY (country_id) REFERENCES public.country(id);


--
-- Name: bid bid_item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bid
    ADD CONSTRAINT bid_item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(id);


--
-- Name: cart_orders cart_orders_cart_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_orders
    ADD CONSTRAINT cart_orders_cart_id_fk FOREIGN KEY (cart_id) REFERENCES public.cart(id);


--
-- Name: cart_orders cart_orders_order_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_orders
    ADD CONSTRAINT cart_orders_order_id_fk FOREIGN KEY (order_id) REFERENCES public."order"(id);


--
-- Name: category category_category_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_category_id_fk FOREIGN KEY (partof) REFERENCES public.category(id);


--
-- Name: blacklist client_blacklist_client_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.blacklist
    ADD CONSTRAINT client_blacklist_client_id_fk FOREIGN KEY (client_id) REFERENCES public."user"(id);


--
-- Name: blacklist client_blacklist_client_id_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.blacklist
    ADD CONSTRAINT client_blacklist_client_id_fk_2 FOREIGN KEY (blacklisted_client_id) REFERENCES public."user"(id);


--
-- Name: message client_message_client_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT client_message_client_id_fk FOREIGN KEY (sender_id) REFERENCES public."user"(id);


--
-- Name: message client_message_client_id_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT client_message_client_id_fk_2 FOREIGN KEY (receiver_id) REFERENCES public."user"(id);


--
-- Name: review client_review_client_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT client_review_client_id_fk FOREIGN KEY (reviewer_id) REFERENCES public."user"(id);


--
-- Name: review client_review_item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT client_review_item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(id);


--
-- Name: watchlist client_watchlist_client_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watchlist
    ADD CONSTRAINT client_watchlist_client_id_fk FOREIGN KEY (client_id) REFERENCES public."user"(id);


--
-- Name: discount discount_client_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discount
    ADD CONSTRAINT discount_client_id_fk FOREIGN KEY (client_id) REFERENCES public."user"(id);


--
-- Name: discount discount_item_category_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discount
    ADD CONSTRAINT discount_item_category_id_fk FOREIGN KEY (category_id) REFERENCES public.category(id);


--
-- Name: discount discount_item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discount
    ADD CONSTRAINT discount_item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(id);


--
-- Name: fee fee_category_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fee
    ADD CONSTRAINT fee_category_id_fk FOREIGN KEY (category_id) REFERENCES public.category(id);


--
-- Name: user fkddefmvbrws3hvl5t0hnnsv8ox; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT fkddefmvbrws3hvl5t0hnnsv8ox FOREIGN KEY (address_id) REFERENCES public.address(id);


--
-- Name: bid item_bids_client_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bid
    ADD CONSTRAINT item_bids_client_id_fk FOREIGN KEY (client_id) REFERENCES public."user"(id);


--
-- Name: item item_category_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_category_id_fk FOREIGN KEY (category_id) REFERENCES public.category(id);


--
-- Name: item item_client_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_client_id_fk FOREIGN KEY (seller_id) REFERENCES public."user"(id);


--
-- Name: item_photos item_photos_item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_photos
    ADD CONSTRAINT item_photos_item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(id);


--
-- Name: item_photos item_photos_photo_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_photos
    ADD CONSTRAINT item_photos_photo_id_fk FOREIGN KEY (photo_id) REFERENCES public.photo(id);


--
-- Name: order order_item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(id);


--
-- Name: payment payment_card_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_card_id_fk FOREIGN KEY (card_id) REFERENCES public.card(id);


--
-- Name: payout payout_client_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payout
    ADD CONSTRAINT payout_client_id_fk FOREIGN KEY (client_id) REFERENCES public."user"(id);


--
-- Name: transaction transaction_cart_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_cart_id_fk FOREIGN KEY (cart_id) REFERENCES public.cart(id);


--
-- Name: transaction transaction_payment_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_payment_id_fk FOREIGN KEY (payment_id) REFERENCES public.payment(id);


--
-- Name: user user_cart_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_cart_id_fk FOREIGN KEY (cart_id) REFERENCES public.cart(id);


--
-- Name: watchlist watchlist_item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watchlist
    ADD CONSTRAINT watchlist_item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(id);


--
-- PostgreSQL database dump complete
--

