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
    "author_id" bigint,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "unique_author_id" unique ("author_id"),
 	CONSTRAINT "fk_books_authors" foreign key("author_id") references "authors"("id")
);