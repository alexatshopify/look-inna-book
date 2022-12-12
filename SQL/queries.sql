INSERT INTO Addresses values('" + this.id + "','"+ this.line_1 + "','" + this.city + "','" + this.postal_code + "','" + this.province + "','" + this.country + "','" + "')

SELECT * FROM Addresses WHERE id= this.id

DELETE FROM Addresses WHERE id = this.id

INSERT INTO Books values('" + this.isbn + "','"+ this.title + "','" + this.publisher_id + "','" + this.num_pages + "','" + this.price + "','" + this.num_in_stock + "','" + this.publisher_percentage + "')

SELECT * FROM Books WHERE isbn = '" + this.isbn + "'

DELETE FROM Books WHERE isbn = this.isbn

INSERT INTO Genres values('" + this.book_isbn + "','"+ this.genre_name + "')

SELECT * FROM Genres WHERE book_isbn = '" + this.book_isbn + "' AND genre_name = '" + this.genre_name + "'

DELETE FROM Genres WHERE book_isbn = '" + this.book_isbn + "' AND genre_name = '" + this.genre_name + "'

INSERT INTO Orders values('" + this.id + "','"+ this.status + "','" + this.created_at + "','" + this.updated_at + "','" + this.user_id + "','" + this.delivery_address_id + "')

SELECT * FROM Orders WHERE id = this.id

DELETE FROM Orders WHERE id = this.id

INSERT INTO Items_in_order values('" + this.book_isbn + "','" + this.order_id + "','" + this.count + "')

SELECT * FROM Items_in_order WHERE book_isbn = '" + this.book_isbn + "' AND order_id = this.order_id

DELETE FROM Items_in_order WHERE book_isbn = '" + this.book_isbn + "' AND order_id = this.order_id

INSERT INTO Publishers values('" + this.id + "','"+ this.name + "','" + this.address_id + "','" + this.email + "','" + this.phone_num + "','" + this.bank_acc + "')

SELECT * FROM Publishers WHERE id = this.id

DELETE FROM Publishers WHERE id = this.id

INSERT INTO Written_by values('" + this.book_isbn + "','"+ this.auth_id + "')

SELECT * FROM Written_by WHERE book_isbn = '" + this.book_isbn + "' AND auth_id = this.auth_id

DELETE FROM Written_by WHERE book_isbn = '" + this.book_isbn + "' AND auth_id = this.auth_id

INSERT INTO Users values('" + this.id + "','"+ this.username + "','" + this.password + "','" + this.name + "','" + this.preferred_address_id + "','" + this.created_at + "')

SELECT * FROM Users WHERE username = '" + this.username + "' AND password = '" + this.password + "'

DELETE FROM Users WHERE id = this.id

INSERT INTO Authors values('" + this.id + "','"+ this.name + "','" + this.wiki_link + "')

SELECT * FROM Authors WHERE id = this.id

DELETE FROM Authors WHERE id = this.id

SELECT * FROM Book WHERE title LIKE '" + query_string + "'

SELECT * FROM Book JOIN Genre ON Book.isbn = Genre.isbn WHERE Genre.genre_name LIKE '" + query_string + "'

SELECT * FROM Book JOIN Written_by ON Book.isbn = Written_by.book_isbn WHERE Written_by.book_isbn = (SELECT id FROM Author WHERE name LIKE '" + query_string + "' LIMIT 1

SELECT * FROM Book LIMIT 100
