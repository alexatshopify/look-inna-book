DROP TABLE IF EXISTS Address CASCADE;
DROP TABLE IF EXISTS Users CASCADE;
DROP TABLE IF EXISTS Orders CASCADE;
DROP TABLE IF EXISTS Publisher CASCADE;
DROP TABLE IF EXISTS Book CASCADE;
DROP TABLE IF EXISTS Author CASCADE;
DROP TABLE IF EXISTS Written_by CASCADE;
DROP TABLE IF EXISTS Genre CASCADE;
DROP TABLE IF EXISTS Items_in_order CASCADE;

CREATE TABLE Address (
    id serial PRIMARY KEY,
    line_1 varchar NOT NULL,
    city varchar NOT NULL,
    postal_code varchar NOT NULL,
    province varchar,
    country varchar
);

CREATE TABLE Users (
    id serial PRIMARY KEY,
    username varchar NOT NULL UNIQUE,
    password varchar NOT NULL,
    name varchar NOT NULL,
    preferred_address_id int,
    created_at date NOT NULL,
    CONSTRAINT fk_address
                  FOREIGN KEY (preferred_address_id)
                  REFERENCES Address(id)
);

CREATE TABLE Orders (
    id serial PRIMARY KEY,
    status varchar,
    created_at date NOT NULL,
    updated_at date NOT NULL,
    user_id int,
    delivery_address_id int,
    CONSTRAINT fk_user
                   FOREIGN KEY (user_id)
                   REFERENCES Users(id),
    CONSTRAINT fk_address
                   FOREIGN KEY (delivery_address_id)
                   REFERENCES Address(id)
);

CREATE TABLE Publisher (
    id serial PRIMARY KEY,
    name varchar NOT NULL,
    address_id int NOT NULL,
    email varchar NOT NULL,
    phone_num int NOT NULL,
    bank_acc varchar,
    CONSTRAINT fk_address
                       FOREIGN KEY (address_id)
                       REFERENCES Address(id)
);

CREATE TABLE Book (
    isbn varchar PRIMARY KEY NOT NULL,
    title varchar NOT NULL,
    publisher_id int NOT NULL,
    num_pages int,
    price float,
    num_in_stock int,
    publisher_percentage float,
    CONSTRAINT fk_publisher
                  FOREIGN KEY (publisher_id)
                  REFERENCES Publisher(id)
);

CREATE TABLE Author (
    id serial PRIMARY KEY,
    name varchar,
    wiki_link varchar
);

CREATE TABLE Written_by (
    book_isbn varchar NOT NULL,
    auth_id int NOT NULL,
    PRIMARY KEY (book_isbn, auth_id),
    CONSTRAINT fk_isbn
                FOREIGN KEY (book_isbn)
                REFERENCES Book(isbn),
    CONSTRAINT fk_author
                FOREIGN KEY (auth_id)
                REFERENCES Author(id)
);

CREATE TABLE Genre (
    book_isbn varchar NOT NULL,
    genre_name varchar NOT NULL,
    CONSTRAINT fk_isbn
                FOREIGN KEY (book_isbn)
                REFERENCES Book(isbn)
);

CREATE TABLE Items_in_order
(
    book_isbn varchar NOT NULL,
    order_id  int NOT NULL,
    count     int NOT NULL,
    CONSTRAINT fk_isbn
            FOREIGN KEY (book_isbn)
            REFERENCES Book(isbn),
    CONSTRAINT fk_order
            FOREIGN KEY (order_id)
            REFERENCES Orders(id)
);