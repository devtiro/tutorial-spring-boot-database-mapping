DROP TABLE IF EXISTS "authors";
CREATE TABLE "authors" (
    "id" bigint NOT NULL,
    "name" VARCHAR(512),
    "desc" VARCHAR(512),
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "books";
CREATE TABLE "books" (
    "isbn" VARCHAR(19) NOT NULL,
    "title" VARCHAR(512),
    "description" VARCHAR(2048),
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn")
);