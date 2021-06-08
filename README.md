# Spring Challenge

# O projeto foi desenvolvido com base no documento "Req. técnicos funcionais - Desafio Spring.pdf"

- foram adicionados dois casos de usos: US 0013 - registerUser e US 0014 - registerSeller, registros de usuário e vendedor, para que tornasse mais fácil
realizar os testes de outros US.

- o tipo de alguns atributos foram alterados. De int para Long e double para Double.

- alterado a semântica "followed" por "following", para que ficasse de forma mais compreensiva, seguindo a nomenclatura de algumas redes sociais existentes.

- com o uso do hibernate, alguns bodys passados deixaram de ter alguns campos e também tiveram o nome de alguns atributos alterados sem perder sua semântica.
(a collection do Postman neste mesmo repositório possui os testes de todos os US)

- o nome de alguns atributos possuiam o padrão de nomenclatura snake case, esses foram alterados pelo padrão camel case ainda garantindo a mesma semântica.
