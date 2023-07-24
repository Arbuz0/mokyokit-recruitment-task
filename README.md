## Zadanie 1

lokalizacja: ./src/main/java

Uznałem, że to wykonania tego zadania wystarczy mi jedna klasa 
"ContactDataProcessor". Zadanie podzieliłem na 4 części, 
którym odpowiadają konkretne metody: wczytanie danych z pliku,
odfiltrowanie niepasujących rekordów, posortowanie rekordów 
oraz zapisanie danych do pliku. W przypadku gdyby wykonanie
tych mniejszych zadań było bardziej skomplikowane rozdzieliłbym
to na 3 osobne klasy: do wczytania danych, do przetworzenia danych
oraz do zapisania danych.

## Zadanie 2

lokalizacja: ./stc/main/sql/task2.sql

użyty: PostgresSQL

Zadanie podzieliłem na dwie części: 
* odnalezienie id klientów, 
z którymi były conajmniej 3 próby kontaktu
* odnaleznienie timestampu ostatniego kontaktu dla każdego klienta

## Zadanie 3

lokalizacja: ./src/main/sql/task_3.sql

użyty: PostgresSQL

Zadanie zinterpretowałem w sposób następujący: 
Dla każdej daty chcemy zobaczyć ile było
(sukcesy, porażki, do_ponowienia, 
zainteresowani_utraty, niezainteresowani_sukcesy) w danym dniu.


Na początku za pomocą kwerendy pomocniczej do każdego kontaktu 
dodałem 
status poprzedniego kontaktu dla danego klienta.
Następnie pogrupowałem rekordy po dacie i policzyłem wystąpienia 
poszczególnych statusów. Dodatkowo rekordy posortowałem po dacie
w celu łatwiejszego dalszego wykorzystania.

## Zadanie 4

lokalizacja: ./src/main/talend/

W folderze znajduję się wyeksportowany "Job Design".
