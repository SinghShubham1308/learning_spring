-- Insert data into the users table
INSERT INTO users (birth_Date, User_Id, name) 
VALUES 
    (current_date, 1001, 'Shubham'),
    (current_date, 1002, 'abhishek'),
    (current_date, 1003, 'ritik'),
    (current_date, 1004, 'ankit');

-- Insert data into the post table
INSERT INTO post (id, description, users_user_id) 
VALUES 
    (2001, 'learning spring', 1001),
    (2002, 'learning aws', 1002),
    (2003, 'learning java', 1003),
    (2004, 'learning cloud', 1004);
