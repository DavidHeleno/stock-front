CREATE TABLE "user"(
                       "id" BIGSERIAL PRIMARY KEY,  -- Alterado para BIGSERIAL
                       "name" VARCHAR(255) NOT NULL,
                       "create_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                       "update_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                       "type_user" VARCHAR(255) NOT NULL,
                       "active" BOOLEAN NOT NULL
);

CREATE TABLE "user_documentation"(
                                     "id" BIGSERIAL PRIMARY KEY,  -- Alterado para BIGSERIAL
                                     "type" VARCHAR(255) NOT NULL,
                                     "description" VARCHAR(255) NOT NULL,
                                     "reference_number" VARCHAR(255) NOT NULL,
                                     "bucket_path" VARCHAR(255) NOT NULL,
                                     "user_id" BIGINT NOT NULL,
                                     "valid" BOOLEAN NOT NULL,
                                     "issue_date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                                     "issuing_body" VARCHAR(255) NOT NULL,
                                     "create_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE "product"(
                          "id" BIGSERIAL PRIMARY KEY,  -- Alterado para BIGSERIAL
                          "name" VARCHAR(255) NOT NULL,
                          "type" VARCHAR(255) NOT NULL,
                          "create_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                          "update_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                          "active" BOOLEAN NOT NULL,
                          "sku" VARCHAR(255) NOT NULL,
                          "category_id" BIGINT NOT NULL
);

CREATE TABLE "stock_flow"(
                             "id" BIGSERIAL PRIMARY KEY,  -- Alterado para BIGSERIAL
                             "product_id" BIGINT NOT NULL,
                             "quantity" BIGINT NOT NULL,
                             "unit_value" DECIMAL(8, 2) NOT NULL,
                             "type_event" VARCHAR(255) NOT NULL,
                             "create_at" VARCHAR(255) NOT NULL,
                             "user_id" BIGINT NOT NULL,
                             "container_id" BIGINT NOT NULL
);

CREATE TABLE "container_product"(
                                    "id" BIGSERIAL PRIMARY KEY,  -- Alterado para BIGSERIAL
                                    "name" VARCHAR(255) NOT NULL,
                                    "description" VARCHAR(255) NOT NULL,
                                    "location" VARCHAR(255) NOT NULL,
                                    "type" VARCHAR(255) NOT NULL,
                                    "active" BOOLEAN NOT NULL DEFAULT '1',
                                    "create_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                                    "update_at" TIMESTAMP(0) NOT NULL
);

CREATE TABLE "product_category"(
                                   "id" BIGSERIAL PRIMARY KEY,  -- Alterado para BIGSERIAL
                                   "description" VARCHAR(255) NOT NULL
);

-- Adicionando as chaves estrangeiras
ALTER TABLE "user_documentation"
    ADD CONSTRAINT "user_documentation_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "user"("id");

ALTER TABLE "stock_flow"
    ADD CONSTRAINT "stock_flow_product_id_foreign" FOREIGN KEY("product_id") REFERENCES "product"("id");

ALTER TABLE "stock_flow"
    ADD CONSTRAINT "stock_flow_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "user"("id");

ALTER TABLE "stock_flow"
    ADD CONSTRAINT "stock_flow_container_id_foreign" FOREIGN KEY("container_id") REFERENCES "container_product"("id");

ALTER TABLE "product"
    ADD CONSTRAINT "product_category_id_foreign" FOREIGN KEY("category_id") REFERENCES "product_category"("id");
