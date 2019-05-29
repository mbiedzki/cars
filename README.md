# cars
test app with timer and multithread

SQL staments to create db

CREATE DATABASE cars CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci
use cars;
create table cars (id int auto_increment primary key, producer varchar(50), 
model varchar(25), capacity decimal(6,2));


Zadanie:

Napisać program umożliwiający uzupełnianie i wyświetlanie zawartości bazy danych o samochodach. Baza danych przechowuje informację o producencie, modelu i pojemności samochodu. Program ma korzystać z konsoli tekstowej do wyboru operacji oraz wprowadzania i wyświetlania danych. Program ma umożliwić użytkownikowi trzy operacje: 
1.	Wyświetlanie listy rekordów z bazy danych 
Po wybraniu tej opcji program ma wyświetlić wszystkie rekordy zapisane w bazie danych i umożliwić wykonywanie innych operacji.
2.	Dodawanie nowego rekordu
Po wybraniu tej opcji program ma umożliwić użytkownikowi wprowadzenie nowego rekordu. Dane wejściowe mają zostać sprawdzone według poniższych kryteriów:
Producent: słowo rozpoczynające się z dużej litery, nie zawierające spacji, np. Mercedes
Model: przynajmniej 1 litera lub cyfra, np. A320
Pojemność: liczba w formacie cyfry.cyfry, np. 1.0
Po wprowadzeniu przez użytkownika wszystkich danych rekordu program ma umożliwić wykonywanie innych operacji.
3.	Zakończenie aplikacji
Po wybraniu tej opcji program kończy działanie.
Program ma się składać z dwóch równolegle działających procesów: 
1.	Główny proces obsługujący interakcję z użytkownikiem. Proces ten umożliwia wybór operacji oraz zapisuje wprowadzone przez użytkownika rekordy do bufora w pamięci.
2.	Proces zapisujący cyklicznie (np. co 30 sekund) zawartość bufora z pamięci do bazy danych i czyszczący bufor.
Wraz z kodem źródłowym programu proszę dostarczyć SQL przygotowujący bazę danych.
Przykład działania programu (na zielono oznaczono dane wprowadzone przez użytkownika):
Podaj operacje (1 - lista, 2 - dodawanie, 3 – wyjscie):2
podaj producenta:Ford
podaj model:Fiesta
podaj pojemnosc:1.1
Podaj operacje (1 - lista, 2 - dodawanie, 3 – wyjscie):2
podaj producenta:Kia
podaj model:Picanto
podaj pojemnosc:1.0
Podaj operacje (1 - lista, 2 - dodawanie, 3 – wyjscie):2
podaj producenta:Fiat
podaj model:Panda
podaj pojemnosc:1.1
Podaj operacje (1 - lista, 2 - dodawanie, 3 – wyjscie):1
Producent Model Pojemnosc
Ford Fiesta 1.1
Kia Picanto 1.0
Fiat Panda 1.1
Podaj operacje (1 - lista, 2 - dodawanie, 3 – wyjscie):3
