# Rabit e Docker 

## Criar um ambiente para o rabbit
    1. Crie um virtual environment
    ```bash
    python3 -m venv venv
    ```

    2. Active o virtual environment (precisa de repetir este passo sempre que começar uma nova sessão/terminal):
    ```bash
    source venv/bin/activate
    ```

    3.Instale o pip:
    ```bash
    python -m pip install --upgrade pip
    ```

    4. Instale os requisitos:
    ```bash
    pip install -r requirements.txt
    ```

    5. Corre geracao de dados:
    ```
    python3 main.py 
    ```

    6. Ver a interface do rabbitMQ 
    http://localhost:15672
