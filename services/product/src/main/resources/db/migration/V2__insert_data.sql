-- Insert 10 categories
INSERT INTO category (id, name, description)
VALUES
    (nextval('category_seq'), 'Electronics', 'Devices and gadgets like phones, laptops, etc.'),
    (nextval('category_seq'), 'Clothing', 'Apparel and accessories for men, women, and children.'),
    (nextval('category_seq'), 'Home Appliances', 'Kitchen and household equipment.'),
    (nextval('category_seq'), 'Books', 'Fiction, non-fiction, and educational books.'),
    (nextval('category_seq'), 'Beauty', 'Cosmetics, skincare, and personal care items.'),
    (nextval('category_seq'), 'Sports', 'Equipment and clothing for sports and fitness.'),
    (nextval('category_seq'), 'Toys', 'Toys and games for kids of all ages.'),
    (nextval('category_seq'), 'Automotive', 'Car parts, accessories, and tools.'),
    (nextval('category_seq'), 'Furniture', 'Home and office furniture.'),
    (nextval('category_seq'), 'Groceries', 'Food items, snacks, and household supplies.');

-- Insert 10 products, each belonging to one of the categories
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'iPhone 13', 'Latest smartphone from Apple', 50, 999.99, 1),
    (nextval('product_seq'), 'Running Shoes', 'Comfortable and durable running shoes', 200, 79.99, 2),
    (nextval('product_seq'), 'Microwave Oven', '700W microwave with digital display', 30, 89.99, 3),
    (nextval('product_seq'), 'Cooking Book', 'A guide to cooking healthy meals', 150, 25.99, 4),
    (nextval('product_seq'), 'Face Cream', 'Moisturizing cream for dry skin', 100, 19.99, 5),
    (nextval('product_seq'), 'Basketball', 'Official size and weight basketball', 120, 29.99, 6),
    (nextval('product_seq'), 'Lego Set', 'Building blocks toy for kids', 75, 49.99, 7),
    (nextval('product_seq'), 'Car Tire', 'All-season radial car tire', 40, 120.50, 8),
    (nextval('product_seq'), 'Office Chair', 'Ergonomic office chair with lumbar support', 25, 149.99, 9),
    (nextval('product_seq'), 'Organic Almonds', 'Healthy snack option', 500, 14.99, 10);
