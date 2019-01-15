
CREATE SEQUENCE public.stock_id_seq;

CREATE TABLE public.stock (
                id INTEGER NOT NULL DEFAULT nextval('public.stock_id_seq'),
                quantity INTEGER NOT NULL,
                expire_date DATE NOT NULL,
                packaging VARCHAR NOT NULL,
                unit_by_package INTEGER NOT NULL,
                product_id INTEGER NOT NULL,
                CONSTRAINT stock_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.stock_id_seq OWNED BY public.stock.id;
