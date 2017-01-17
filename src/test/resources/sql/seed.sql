use ecommercetest;

TRUNCATE TABLE inventory;

INSERT INTO inventory(version,name,stock_number,rating,description,no_of_reviews,discount,actual_price,quantity,restriction) VALUES(1,"iphone","6s",4,"good",3,20,50000,5,FALSE );