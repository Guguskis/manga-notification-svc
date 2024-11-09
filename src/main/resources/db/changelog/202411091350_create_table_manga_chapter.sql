-- liquibase formatted sql logicalFilePath:202411091350_create_table_manga_chapter.sql

-- changeset admin:202411091350_create_table_manga_chapter runInTransaction:false

CREATE TABLE IF NOT EXISTS manga_chapter
(
    id                    UUID PRIMARY KEY,
    manga_subscription_id UUID          NOT NULL,
    title                 VARCHAR(255)  NOT NULL,
    url                   VARCHAR(1028) NOT NULL,
    created_on            TIMESTAMP(3)  NOT NULL,
    updated_on            TIMESTAMP(3)  NOT NULL
);

CREATE INDEX CONCURRENTLY IF NOT EXISTS idx_manga_chapter_subscription_id ON manga_chapter (manga_subscription_id);
