INSERT INTO `members`
VALUES
('john', 1, '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q'),
('mary', 1, '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q'),
('susan', 1, '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q');

INSERT INTO `roles`
VALUES
('ROLE_EMPLOYEE', 'john'),
('ROLE_EMPLOYEE', 'mary'),
('ROLE_MANAGER', 'mary'),
('ROLE_EMPLOYEE', 'susan'),
('ROLE_MANAGER', 'susan'),
('ROLE_ADMIN', 'susan');