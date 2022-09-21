# HelloBank
Projeto final da capacitação If Black, Then Code (IBM & Gama Academy). 
### Sobre o Desafio
Criar uma aplicação para o banco fictício *HelloBank*, utilizando conhecimentos em Java, Banco de dados e AWS. O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais e dados para contato, sendo que cada cliente registrado no sistema deve ser atrelado à respectiva conta bancária. Além disso, o sistema deve registrar histórico de transações entre as contas.
<div align="center">
<img src="https://user-images.githubusercontent.com/93226440/191615977-5eaec2a4-145f-4162-ba9e-213231fb1ee8.gif" />
</div>



## Equipe **Black Eyed Devs**
<div align="center">
<table>
  <tr>
    <td align="center"><img style="width: 150px; border-radius: 50%" 
    src="https://user-images.githubusercontent.com/93226440/191617166-d6b0230d-6ff7-4486-92f4-ecb8fc50e906.png"
     alt="Amanda da Rocha Pitta"/><br /><sub style="font-size: 14px"><b>Amanda da Rocha Pitta</b></sub><br /> 
    <a href="https://www.linkedin.com/in/amanda-pitta" alt="Linkedin">
    <br>
    <img src="https://img.shields.io/badge/-Linkedin-1C1C1C?style=for-the-badge&logo=Linkedin&logoColor=00FFFF" style= "width:90px;"/>
    </a>
    </td>
  <td align="center"><img style="width: 150px; border-radius: 50%" 
  src="https://avatars.githubusercontent.com/u/93226440?v=4"
   alt="Cristhiane da Cruz"/><br /><sub style="font-size: 14px"><b>Cristhiane da Cruz</b></sub><br /> 
  <a href="https://www.linkedin.com/in/barroscruzc/" alt="Linkedin">
  <br>
<img src="https://img.shields.io/badge/-Linkedin-1C1C1C?style=for-the-badge&logo=Linkedin&logoColor=00FFFF" style= "width:90px;"/>
  </a>
  </td>
  <td align="center"><img style="width: 150px; border-radius: 50%" 
  src="https://user-images.githubusercontent.com/93226440/191617669-1aa3b976-c2ac-4d9c-9d56-76754e8a5f3d.png"
   alt="José Ricardo Pereira Junior"/><br /><sub style="font-size: 14px"><b>José Ricardo Pereira Junior</b></sub><br /> 
  <a href="https://www.linkedin.com/in/r1cardopereira/" alt="Linkedin">
  <br>
<img src="https://img.shields.io/badge/-Linkedin-1C1C1C?style=for-the-badge&logo=Linkedin&logoColor=00FFFF" style= "width:90px;"/>
  </a>
  </td>
  <td align="center"><img style="width: 150px; border-radius: 50%" 
  src="https://user-images.githubusercontent.com/93226440/191619700-18f4a72e-235d-43b5-a95d-2b0039055671.png"
   alt="Marcus Vinicius Lameu Lima"/><br /><sub style="font-size: 14px"><b>Marcus Vinicius Lameu Lima</b></sub><br /> 
  <a href="https://www.linkedin.com/in/marcuslameu/" alt="Linkedin">
  <br>
<img src="https://img.shields.io/badge/-Linkedin-1C1C1C?style=for-the-badge&logo=Linkedin&logoColor=00FFFF" style= "width:90px;"/>
  </a>
  </td>
  </tr>
  <tr>
  <td align="center"><img style="width: 150px; border-radius: 50%" 
  src="https://user-images.githubusercontent.com/93226440/191620144-536ff095-24cf-4c31-b42f-a5e115eb2393.png"
   alt="Natanael Queiroz"/><br /><sub style="font-size: 14px"><b>Natanael Queiroz</b></sub><br /> 
  <a href="https://www.linkedin.com/in/natanael-queiroz" alt="Linkedin">
  <br>
<img src="https://img.shields.io/badge/-Linkedin-1C1C1C?style=for-the-badge&logo=Linkedin&logoColor=00FFFF" style= "width:90px;"/>
  </a>
  </td>
  <td align="center"><img style="width: 150px; border-radius: 50%" 
  src="https://user-images.githubusercontent.com/93226440/191620462-cefbd5dc-1654-4a24-99b8-6f2f6839742f.png"
   alt="Thiago Conceição de Oliveira"/><br /><sub style="font-size: 14px"><b>Thiago Conceição de Oliveira</b></sub><br /> 
  <a href="https://www.linkedin.com/in/thiagooliveira410/" alt="Linkedin">
  <br>
<img src="https://img.shields.io/badge/-Linkedin-1C1C1C?style=for-the-badge&logo=Linkedin&logoColor=00FFFF" style= "width:90px;"/>
  </a>
  </td>
  <td align="center"><img style="width: 150px; border-radius: 50%" 
  src="https://user-images.githubusercontent.com/93226440/191621236-217f04fa-0e5b-40e8-8e16-e67e359028d2.png"
   alt="Walderney Oliveira Azevedo"/><br /><sub style="font-size: 14px"><b>Walderney Oliveira Azevedo</b></sub><br /> 
  <a href="https://www.linkedin.com/in/walderney-oliveira-165198214/" alt="Linkedin">
  <br>
<img src="https://img.shields.io/badge/-Linkedin-1C1C1C?style=for-the-badge&logo=Linkedin&logoColor=00FFFF" style= "width:90px;"/>
  </a>
  </td>
  <td align="center"><img style="width: 150px; border-radius: 50%" 
  src="https://user-images.githubusercontent.com/93226440/191621378-08e2245b-acfb-4df1-a2d5-201ea8b13889.png"
   alt="Wesner Souza Carvalho Filho"/><br /><sub style="font-size: 14px"><b>Wesner Souza Carvalho Filho</b></sub><br /> 
  <a href="https://www.linkedin.com/in/wesner-filho" alt="Linkedin">
  <br>
<img src="https://img.shields.io/badge/-Linkedin-1C1C1C?style=for-the-badge&logo=Linkedin&logoColor=00FFFF" style= "width:90px;"/>
  </a>
  </td>
  </tr>
</table>
</div>
  
 
 ## Como executar a aplicação
  Antes de iniciar a aplicação, é necessário criar um banco de dados no MySQL chamado **hellobank** na porta **3306**, no **localhost**. Configure seus usuário e senha no arquivo `src\main\resources\application.properties`, e execute os <a href="https://github.com/HelloBank-IBM/hellobank/blob/main/sql_script_hellobank.sql">Scripts SQL</a> para criação e população das tabelas. A seguir, torne os scripts shell executáveis com o comando `chmod +x` e execute a aplicação com o comando `./start.sh`
 
 ## Banco de dados
  Clique <a href="https://github.com/HelloBank-IBM/hellobank/blob/main/sql_script_hellobank.sql">aqui</a> para visualizar o Script SQL.
  
  Diagrama EER:
  
  ![image](https://user-images.githubusercontent.com/93226440/190196397-1e023b8b-b799-4372-a058-22f785179fbe.png)
  
 ## Endpoints
 A documentação completa dos Endpoints da aplicação podem ser visualizada <a href="Model-View-Controller" target="_blank"> aqui </a>.

### Package **Contas**
#### Listar Contas
- Verbo HTTP **GET**
- Endpoint: 
```curl
localhost:8080/conta/
```
- Exemplo de Request:
```curl
curl --location --request GET 'localhost:8080/conta/'
```
- Exemplo de response: `HTTP Status 200 ok`
```curl
[{"id":1,"tipo":{"codigo":1,"nome":"Corrente"},"saldo":200,"cliente":{"id":1,"nome":"Thiago Conceicao de Oliveira","contato":"21987894321","cpfCnpj":"63720145999","endereco":"Rua A, Bairro A, CidadeA1-J","email":"thiago@teste.com","senha":"369852147","novo":false},"numeroConta":7111111},{"id":2,"tipo":{"codigo":2,"nome":"Poupanca"},"saldo":0,"cliente":{"id":2,"nome":"Amanda da Rocha Pitta","contato":"71987665321","cpfCnpj":"16553786194","endereco":"Rua B, Bairro B, CidadeB2-RJ","email":"amanda@teste.com","senha":"698521473","novo":false},"numeroConta":7122222},{"id":3,"tipo":{"codigo":3,"nome":"Universitaria"},"saldo":900,"cliente":{"id":3,"nome":"Walderney Oliveira Azevedo","contato":"98984354321","cpfCnpj":"14288772230","endereco":"Rua C, Bairro C CidadeC3-RJ","email":"walderney@teste.com","senha":"985214736","novo":false},"numeroConta":7133333}]
```

#### Cadastrar Conta
- Verbo HTTP **POST**
- Parâmetros:
    -  Tipo
    -  Saldo
    -  ID Cliente
- Endpoint:
```curl
localhost:8080/conta
```
- Exemplo de request: 
```curl

curl --location --request POST 'localhost:8080/conta' \
--data-raw '{"tipo":{"codigo":2,"nome":"Poupanca"},"saldo":null,"cliente":{"id":1,"nome":"Thiago Conceicao de Oliveira","contato":"21987894321","cpfCnpj":"63720145999","endereco":"Rua A, Bairro A, CidadeA1-RJ","email":"thiago@teste.com","senha":"369852147"},"numeroConta":null}'
```
- Exemplo de response: `HTTP Status 200 ok`
```curl
{"id":20,"tipo":{"codigo":2,"nome":"Poupanca"},"saldo":500,"cliente":{"id":1,"nome":"Thiago Conceicao de Oliveira","contato":"21987894321","cpfCnpj":"63720145999","endereco":"Rua A, Bairro A, CidadeA1-RJ","email":"thiago@teste.com","senha":"369852147","novo":false},"numeroConta":7176142}
```

#### Buscar conta bancária por número
- Verbo HTTP **GET**
- Endpoint:
```curl
localhost:8080/conta/{numeroConta}
```
- Exemplo de request:
```curl
curl --location --request GET 'localhost:8080/conta/7123503'
```
- Exemplo de response: `HTTP Status 200 ok`
```curl
{"id":19,"tipo":{"codigo":3,"nome":"Universitaria"},"saldo":737,"cliente":{"id":1,"novo":false},"numeroConta":7123503}
```

#### Excluir conta
- Verbo HTTP **DELETE**
- Endpoint:
```curl
localhost:8080/conta/{numeroConta}
```
- Exemplo de request:
```curl
curl --location --request DELETE 'localhost:8080/conta/7130353'
```

#### Transferência
- Verbo HTTP **PUT**
- Parâmetros:
- Endpoint:
```curl
localhost:8080/transferencia/{numeroContaOrigem}/{valor}/{numeroContaDestino}
```
- Exemplo de request:
```curl
curl --location --request PUT 'localhost:8080/transferencia/7111111/300/7133333' \
--data-raw ''
```
- Exemplo de response: `HTTP Status 200 ok`
```curl
{"id":1,"tipo":{"codigo":1,"nome":"Corrente"},"saldo":347,"cliente":{"id":1,"novo":false},"numeroConta":7111111}
```

#### Depósito
- Verbo HTTP **PUT**
- Endpoint 
```curl
localhost:8080/depositar/{numeroConta}/{valor}
```
- Exemplo de request:
```curl
curl --location --request PUT 'localhost:8080/depositar/45/7133333'
```
- Exemplo de response: `HTTP Status 200 ok`
```curl
{"id":2,"tipo":{"codigo":2,"nome":"Poupanca"},"saldo":1675,"cliente":{"id":2,"novo":false},"numeroConta":7122222}
```

#### Extrato
- Verbo HTTP **POST**
- Endpoint
```curl
localhost:8080/extrato/{numeroConta}
```
- Exemplo de request:
```curl
curl --location --request POST 'localhost:8080/extrato/7122222'
```
- Exemplo de response: `HTTP Status 200 ok`
```curl
[{"id":2,"contaOrigem":{"id":2,"tipo":{"codigo":2,"nome":"Poupanca"},"saldo":1175,"cliente":{"id":2,"novo":false},"numeroConta":7122222},"contaDestino":null,"data":"2022-09-20","valor":200,"tipoTransacao":{"id":2,"nome":"Saque"}},{"id":9,"contaOrigem":{"id":2,"tipo":{"codigo":2,"nome":"Poupanca"},"saldo":1175,"cliente":{"id":2,"novo":false},"numeroConta":7122222},"contaDestino":{"id":1,"tipo":{"codigo":1,"nome":"Corrente"},"saldo":-190,"cliente":{"id":1,"novo":false},"numeroConta":7111111},"data":"2022-09-18","valor":50,"tipoTransacao":{"id":3,"nome":"Transferencia"}},{"id":11,"contaOrigem":{"id":2,"tipo":{"codigo":2,"nome":"Poupanca"},"saldo":1175,"cliente":{"id":2,"novo":false},"numeroConta":7122222},"contaDestino":{"id":1,"tipo":{"codigo":1,"nome":"Corrente"},"saldo":-190,"cliente":{"id":1,"novo":false},"numeroConta":7111111},"data":"2022-09-18","valor":65,"tipoTransacao":{"id":3,"nome":"Transferencia"}}]
```
