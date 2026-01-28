-- Script de dados de teste para a API de Vendas
-- Período: 05/01/2026 a 20/01/2026
-- Vendedores: Alysson, Gabriel, Lucas e Bruno

-- ========================================
-- VENDAS DO ALYSSON (ID: 1)
-- ========================================
INSERT INTO venda (data_venda, valor_venda, id_vendedor, nome_vendedor) VALUES
                                                                            ('2026-01-05', 1500.00, 1, 'Alysson'),
                                                                            ('2026-01-07', 2300.50, 1, 'Alysson'),
                                                                            ('2026-01-10', 850.00, 1, 'Alysson'),
                                                                            ('2026-01-12', 3200.00, 1, 'Alysson'),
                                                                            ('2026-01-15', 1750.25, 1, 'Alysson'),
                                                                            ('2026-01-18', 2100.00, 1, 'Alysson'),
                                                                            ('2026-01-20', 1900.75, 1, 'Alysson');

-- ========================================
-- VENDAS DO GABRIEL (ID: 2)
-- ========================================
INSERT INTO venda (data_venda, valor_venda, id_vendedor, nome_vendedor) VALUES
                                                                            ('2026-01-06', 2800.00, 2, 'Gabriel'),
                                                                            ('2026-01-08', 1950.50, 2, 'Gabriel'),
                                                                            ('2026-01-11', 3500.00, 2, 'Gabriel'),
                                                                            ('2026-01-13', 2200.75, 2, 'Gabriel'),
                                                                            ('2026-01-16', 4100.00, 2, 'Gabriel'),
                                                                            ('2026-01-19', 1800.25, 2, 'Gabriel');

-- ========================================
-- VENDAS DO LUCAS (ID: 3)
-- ========================================
INSERT INTO venda (data_venda, valor_venda, id_vendedor, nome_vendedor) VALUES
                                                                            ('2026-01-05', 1200.00, 3, 'Lucas'),
                                                                            ('2026-01-09', 2750.00, 3, 'Lucas'),
                                                                            ('2026-01-11', 1500.50, 3, 'Lucas'),
                                                                            ('2026-01-14', 3300.00, 3, 'Lucas'),
                                                                            ('2026-01-17', 2450.75, 3, 'Lucas'),
                                                                            ('2026-01-20', 1850.00, 3, 'Lucas');

-- ========================================
-- VENDAS DO BRUNO (ID: 4)
-- ========================================
INSERT INTO venda (data_venda, valor_venda, id_vendedor, nome_vendedor) VALUES
                                                                            ('2026-01-06', 1750.00, 4, 'Bruno'),
                                                                            ('2026-01-08', 2200.00, 4, 'Bruno'),
                                                                            ('2026-01-10', 1950.50, 4, 'Bruno'),
                                                                            ('2026-01-13', 2850.00, 4, 'Bruno'),
                                                                            ('2026-01-16', 3100.25, 4, 'Bruno'),
                                                                            ('2026-01-18', 2500.00, 4, 'Bruno'),
                                                                            ('2026-01-20', 1800.75, 4, 'Bruno');

-- ========================================
-- RESUMO DOS DADOS
-- ========================================
-- Alysson: 7 vendas, Total: R$ 13.600,50
-- Gabriel: 6 vendas, Total: R$ 16.350,50
-- Lucas:   6 vendas, Total: R$ 13.051,25
-- Bruno:   7 vendas, Total: R$ 16.151,50
--
-- Total de vendas: 26
-- Período: 16 dias (05/01 a 20/01)
-- ========================================