# FastTravel

Sistema de portagens electrónicas de monitorização de portagens e automatização de pagamentos.

## Sobre o Projeto 

O sistema tem como objetivo gerir os pórticos em autoestradas e outras vias, para tal, tem que monitorar os automóveis que transitam na via destinada ao Fast Travel. Conferir também, se os mesmos têm o identificador, o trajeto percorrido e o custo da viagem, retirar o correspondente montante da conta bancária associada ao cliente, e assim, agilizar o processo de viagem com pagamentos instantâneos.

## Backlog
Para monitorizar as tarefas e acompanhar o desenvolvimento do projeto, usamos:

* **[GitHub Projects](https://github.com/eva-pomposo/IES_Project/projects)**
* **Jira**

##  Constituição do projeto

* **[reports](https://github.com/eva-pomposo/IES_Project/tree/main/Reports)**
* **[prototype](https://github.com/eva-pomposo/IES_Project/tree/main/projFastTravel)**

## Correr FastTravel

### Compilar FastTravelService

1. Ao compilar o FastTravelService, irá eliminar a pasta target caso exista, e gera-lo de novo com base no código do FastTravelService, contendo este um ficheiro jar. 
2. Para isto basta correr o seguinte comando no diretório ./FastTravelService:
    ```
    mvn clean package -DskipTests
    ```

### Compilar o docker que une a base de dados e o FastTravelService

1. Antes de compilar o docker é necessario ter o ficheiro jar do FastTravelService pretendido (para obte-lo basta executar os passos vistos anteriormmente)
2. Para compilar o docker basta correr o seguinte comando no diretório raiz do projeto:
    ```
    sudo docker-compose build
    ```

### Executar o docker que une a base de dados e o FastTravelService

1. Para correr o docker basta correr o seguinte comando no diretório raiz do projeto:
    ```
    sudo docker-compose down
    ```
    ```
    sudo docker-compose up
    ```

2. Caso o docker de erro para eliminar 
    docker rm -f $(docker ps -aq)

3. Observar os resultados Website
    http://localhost:6868/

### Compilar a geração de dados e rabbit 
1. Entrar no diretorio dataGeneratorBroker
2. Ver o Readme do diretorio
3. Ver a interface do rabbitMQ 
    http://localhost:15672

## Papéis 

* **Team Manager**: [Eva Bartolomeu](https://github.com/eva-pomposo), nº 98513
* **Product Owner**: [Marta Fradique](https://github.com/MartaFradique), nº 98629
* **Architect**: [André Freixo](https://github.com/andre180701), nº 98495
* **DevOps Master**: [Luís Martins](https://github.com/luisccmartins), nº 98521