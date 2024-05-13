DROP SEQUENCE IF EXISTS "author_id_seq";
CREATE SEQUENCE "author_id_seq" INCREMENT BY 50 START 1;

DROP TABLE IF EXISTS "authors";
CREATE TABLE "authors" (
    "id" bigint NOT NULL,
    "name" VARCHAR(512),
    "description" VARCHAR(512),
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "books";
CREATE TABLE "books" (
    "isbn" VARCHAR(19) NOT NULL,
    "title" VARCHAR(512),
    "description" VARCHAR(2048),
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn")
);