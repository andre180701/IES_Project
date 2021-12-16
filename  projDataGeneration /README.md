# Rabit e Docker 

#### Executar o ficheiro .yml
    docker-compose up -d

#### Confirmar se esta bem o docker
    docker-compose ps




## Criar um ambiente para o rabbit
    1. Crie um virtual environment
    ```bash
    python3 -m venv venv
    ```

    2. Active o virtual environment (precisa de repetir este passo sempre que começar uma nossa sessão/terminal):
    ```bash
    source venv/bin/activate
    ```

    3. Instale os requisitos:
    ```bash
    pip install -r requirements.txt
    ```

    4. caso o docker de erro para eliminar 
        docker rm -f $(docker ps -aq)

run rabitmq using docker compose with guest user outside localhost