-- Insert data
INSERT INTO address (address) VALUES
('123 Main Street, Anytown, CA 91234'),
('456 Oak Avenue, Springfield, IL 62704'),
('789 Pine Lane, Anytown, CA 91234');

INSERT INTO employee (address_id, created_date, dob, modified_date, email, first_name, gender, last_name, phone_number) VALUES
(1, NOW(), '1990-01-15', NOW(), 'john.doe@example.com', 'John', 'Male', 'Doe', '555-1212'),
(2, NOW(), '1985-05-20', NOW(), 'jane.doe@example.com', 'Jane', 'Female', 'Doe', '555-3434'),
(3, NOW(), '1995-11-10', NOW(), 'peter.pan@example.com', 'Peter', 'Male', 'Pan', '555-5656');