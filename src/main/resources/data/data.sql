INSERT INTO papel ( id, role ) VALUES
( 1, 'ROLE_ADMINISTRADOR' ),
( 2, 'ROLE_GESTOR' ),
( 3, 'ROLE_OPERACIONAL' ),
( 4, 'ROLE_AUDITOR' ),
;

-- Admin, 123456
-- Gestor, 654321
-- Operacional, 112233
-- Auditor, 123123
INSERT INTO usuario ( nome, email, cpf, senha, ativo ) VALUES
( 'Admin', '11122233344@mailinator.com', '11122233344', '$2a$04$a726kcr6VvnceF/blfD67.bHWX9vYU5oiqxTd5kC/Ih/RSvy5Bg2W', true ),
( 'Gestor', '44499955522@mailinator.com', '44499955522', '$2a$04$qVDjPjmS2IHtHkhmGhUmI.WIgSTrVxZG5M4dDVeQIB2qdoAqsbQXa', true ),
( 'Operacional', '99988877766@mailinator.com', '99988877766', '$2a$04$ZPfYJUwIJ.ECDxDU5L0b.etkj6w6IrWedSRRrfbedEllj1.LYmeFi', true ),
( 'Auditor', '55522288833@mailinator.com', '55522288833', '$2a$04$7VGyrPD4WPxzIK2St1tXhuF/IMowC87sl8.z5IEHObew3p4W.gNw6', true ),
;


INSERT INTO usuario_papel ( id_usuario, id_papel ) VALUES
( 1, 1 ),
( 2, 2 ),
( 3, 3 ),
( 4, 4 ),
;
