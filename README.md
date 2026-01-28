Desafio técnico (X-brain) - Backend
---

Para facilitar os testes, rode o script SQL (que está na pasta raíz do projeto) no console do H2 para popular as tabelas.

```
insere_dados.sql
```

## Endpoints
1. Listar os vendedores com as estatísticas de vendas:
   - GET /api/vendas/vendedores

2. Criar uma venda:
   - POST /api/vendas
   ```json
   {
   "dataVenda": "2026-01-09",
    "valor": 65.00,
    "idVendedor": 3,
    "nomeVendedor": "Marcos"
   }
   ```
   
## Resultados para referência
> Dados que foram inseridos no script SQL da pasta raíz do projeto.
```json
[
  {
    "nome": "Alysson",
    "totalVendas": 13600.50,
    "mediaVendasDiarias": 850.03
  },
  {
    "nome": "Gabriel",
    "totalVendas": 16350.50,
    "mediaVendasDiarias": 1021.91
  },
  {
    "nome": "Lucas",
    "totalVendas": 13051.25,
    "mediaVendasDiarias": 815.70
  },
  {
    "nome": "Bruno",
    "totalVendas": 16151.50,
    "mediaVendasDiarias": 1009.47
  }
]

```