# Cult_API_Rest

![logo](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/3c7f324a-65f7-4f68-bcc2-1eb3b6d71694)

O cult é uma API Rest que faz a gestão de uma Livraria, permitindo que seus usuários consigam registrar
a chegada e saída dos livros por meio de um CRUD, cada um podendo fazer sua atualização no qual esta autorizado. Essa APU 
também consta com autenticação por JWT.

# CRUD

# CREATE 

![2](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/cc7f50fa-d7b9-4649-b581-8e447124d4c2)

Após a criação também é gerado uma URL com o id do cadastrado, para melhor 
localização das fichas.

![3](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/eda32aa5-e3d2-47fa-9a71-c6b849a91669)


# READ

![4](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/3d34d2a6-a1e5-4e80-8d03-bc627561f123)



Também esta incluso toda paginação.

![6](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/484a571a-8b77-4db9-ae4a-4895b0920ef0)



Podemos também pedir pesquisas de forma mais exclusivas usando apenas o ID.

# UPDATE 

![5](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/78afaee6-613c-44a2-8841-f371bc141fd6)

# DELETE 

![7](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/e6317511-5d04-4c57-bcae-c58a4d37768c)


# JWT 

O Json Web Token cobra para que toda vez que você for utilizar a aplicação você precisa inserir um login em uma senha que já 
estão previamente cadastradas no banco de dados

![12](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/626a07e4-6230-437a-83fc-5742aacc2b38)

Após o envio é retornado o token para uso.

![1](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/cde7a476-2d57-4b5a-aeb9-114e6dfe3c6d)

Caso você tente forçar acesso, irá ser mostrado o código 403(Acesso negado)

![9](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/75a44698-2731-4356-812c-d502812711ba)

# SpringDoc e Swagger

Toda essa API também pode ser documentada e testada online por meio do Swagger no link

http://localhost:8080/swagger-ui/index.html

![10](https://github.com/SrBorges/Cult_API_Rest/assets/96485637/1dac04d3-c461-4dcc-ba34-e8991152e08b)

Ou se quisermos pela End-point

http://localhost:8080/v3/api-docs

# End-Points


http://localhost:8080/v3/api-docs <- Documentação online

http://localhost:8080/livros <- Livros

http://localhost:8080/funcionarios <- Clientes

http://localhost:8080/login <- Login

http://localhost:8080/funcionarios <- Funcionários 




