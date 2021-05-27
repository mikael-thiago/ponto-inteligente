INSERT INTO empresas (id, cnpj, razao_social) 
VALUES (NULL, '82198127000121', 'Kazale IT');

INSERT INTO funcionarios (id, cpf, email, nome, 
perfil, qtd_horas_almoco, qtd_horas_trabalho_dia, senha, valor_hora, empresa_id) 
VALUES (NULL, '16248890935', 'admin@kazale.com', 'ADMIN', 'ROLE_ADMIN', NULL, NULL, 
'$2a$06$xIvBeNRfS65L1N17I7JzgefzxEuLAL0Xk0wFAgIkoNqu9WD6rmp4m', NULL, 
(SELECT id FROM empresas WHERE cnpj = '82198127000121'));
