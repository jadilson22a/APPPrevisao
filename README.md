# Banco de dados

```
CREATE DATABASE  IF NOT EXISTS `compras` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `compras`;

CREATE TABLE `previsoes` (
  `id` int not null auto_increment,
  `numPedido` int DEFAULT NULL,
  `previsao` date DEFAULT NULL,
  `fornecedor` text,
  `cotacao` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * from previsoes;  
```

# Front end
```
npm install axios

npm install styled-components
```
