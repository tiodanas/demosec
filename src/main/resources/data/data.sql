INSERT INTO papel ( id, role ) VALUES
( 1, 'ROLE_ADMINISTRADOR' ),
( 2, 'ROLE_GESTOR' ),
( 3, 'ROLE_OPERACIONAL' ),
( 4, 'ROLE_AUDITOR' ),
;

-- -- Admin, 123456
-- -- Gestor, 654321
-- -- Operacional, 112233
-- -- Auditor, 123123
-- INSERT INTO usuario ( nome, email, cpf, senha, ativo ) VALUES
-- ( 'Admin', '11122233344@mailinator.com', '11122233344', '$2a$04$a726kcr6VvnceF/blfD67.bHWX9vYU5oiqxTd5kC/Ih/RSvy5Bg2W', true ),
-- ( 'Gestor', '44499955522@mailinator.com', '44499955522', '$2a$04$qVDjPjmS2IHtHkhmGhUmI.WIgSTrVxZG5M4dDVeQIB2qdoAqsbQXa', true ),
-- ( 'Operacional', '99988877766@mailinator.com', '99988877766', '$2a$04$ZPfYJUwIJ.ECDxDU5L0b.etkj6w6IrWedSRRrfbedEllj1.LYmeFi', true ),
-- ( 'Auditor', '55522288833@mailinator.com', '55522288833', '$2a$04$7VGyrPD4WPxzIK2St1tXhuF/IMowC87sl8.z5IEHObew3p4W.gNw6', true ),
-- ;
--
-- bcrypt strenght 10
-- admin, 123456 = $2a$10$FuufzBhVu1MhCy7y9xI21OcuIhcEjF9LEFfGf/0gF6yPEWNZ2vB2a
-- gestor, 123123 = $2a$10$vwZ5CTwO3sbdueXV1hpcm.cRc2eZ/YtstG.P9j4Ho4vr.n.2i9yPK
-- oprecional, 654321 = $2a$10$J5fMTlhk3lxXYnNsNmhM8ey2HO.mOsYIm0zNgAG.bn0NhetiQKQX.
-- auditor, 112233 = $2a$10$E.Hrrl9zFee3opU9kBI8we8mi9s7wntwk6z8JlYtkr.saoDLxQll.
--
INSERT INTO usuario ( username, password, cpf, email, matricula, ativo ) VALUES
( 'admin', '$2a$10$FuufzBhVu1MhCy7y9xI21OcuIhcEjF9LEFfGf/0gF6yPEWNZ2vB2a', 48458150018, '48458150018@mailinator.com', '123.456-89', 1 ),
( 'gestor', '$2a$10$vwZ5CTwO3sbdueXV1hpcm.cRc2eZ/YtstG.P9j4Ho4vr.n.2i9yPK', 52587641098, '52587641098@mailinator.com', '0124-5', 1 ),
( 'operacional','$2a$10$J5fMTlhk3lxXYnNsNmhM8ey2HO.mOsYIm0zNgAG.bn0NhetiQKQX.', 52899829068, '52899829068@mailinator.com', '001523-5', 1 ),
( 'auditor', '$2a$10$E.Hrrl9zFee3opU9kBI8we8mi9s7wntwk6z8JlYtkr.saoDLxQll.', 85085070038, '85085070038@mailinator.com', '2400-6', 1 ),
;



INSERT INTO usuario_papel ( id_usuario, id_papel ) VALUES
( 1, 1 ),
( 2, 2 ),
( 3, 3 ),
( 4, 4 ),
;

