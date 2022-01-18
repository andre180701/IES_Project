FROM python:3

COPY requirements.txt ./

RUN pip install --upgrade pip
RUN pip install -r requirements.txt

ADD Client.py /
ADD Scut.py /
ADD main.py /

CMD ["python3", "main.py" ]

