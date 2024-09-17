-- Migration for Category and Product tables


-- Create Category table if it does not exist
CREATE TABLE IF NOT EXISTS category (
    id INTEGER NOT NULL PRIMARY KEY,  -- Corrected sequence name here
    name VARCHAR(255) NOT NULL,       -- Name of the category
    description TEXT                  -- Description of the category
);

-- Create Product table if it does not exist
CREATE TABLE IF NOT EXISTS product (
    id INTEGER NOT NULL PRIMARY KEY ,  -- Corrected sequence name here
    name VARCHAR(255) NOT NULL,       -- Name of the product
    description TEXT,                 -- Description of the product
    available_quantity DOUBLE PRECISION NOT NULL,  -- Available quantity of the product
    price DECIMAL(38, 2) NOT NULL,    -- Price of the product
    category_id INTEGER,              -- Foreign key referencing Category table
    CONSTRAINT fk_category
        FOREIGN KEY (category_id)
        REFERENCES category (id)
        ON DELETE CASCADE             -- When a category is deleted, all its products are also removed
);

create sequence if not exists category_seq increment by 1;
create sequence if not exists product_seq increment by 1;
