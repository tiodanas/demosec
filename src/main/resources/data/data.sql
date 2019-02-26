INSERT INTO papel ( id, role ) VALUES
( 1, 'ROLE_ADMINISTRADOR' ),
( 2, 'ROLE_OPERACIONAL' ),
( 3, 'ROLE_AUDITOR' )
;


INSERT INTO usuario ( nome, email, cpf, senha, ativo ) VALUES
( 'Admin', 'admin@mailinator.com', '11122233344', '123456', true ),
( 'User', 'user@mailinator.com', '99988877766', '654321', true ),
( 'TCE', 'tce@mailinator.com', '55522288833', '123123', true ),
;


INSERT INTO usuario_papel ( id_usuario, id_papel ) VALUES
( 1, 1 ),
( 2, 2 ),
( 3, 3 ),
;
