# Problem czytelników i pisarzy
## Implementacja:
W problemie pisarzy i czytelników mamy do czynienia z dwoma procesami- czytelnikami i pisarzami. Korzystają one ze wspólnej
czytelni, jednak na odpowiednich warunkach:
- w czytelni w tym samym czasie może znajdować się maksymalnie 1 pisarz lub 5 czytelników.
- czytelnik wejdzie do czytelni tylko jeśli będzie miał czytać,
- w przypadku gdy czytelnik nie ma co czytać, czeka do momentu gdy jakiś pisarz napiszę książkę.
### Sposób działania wątku pisarza:
- chce wejść do czytelni,
- czeka do momentu, gdy zostanie wpuszczony,
- pisze przez około 2 sekundy,
- wychodzi,
- czeka 2 sekundy, zanim proces zostanie powtórzony.

### Sposób działania wątku czytelnika:
- chce wejść do czytelni,
- czeka do momentu, gdy zostanie wpuszczony,
- czyta przez około 1 sekundę,
- wychodzi,
- czeka 1 sekundę, zanim proces zostanie powtórzony.

Do rozwiązania problemu zostały wykorzystane metody synchroniczne w klasie ReadingRoom:
- startWriting:
    + Informacja o sytuacji w czytelni, a także o oczekujących,
    + Jeśli ktoś jest w czytelni, to pisarz czeka (wait()),
    + Gdy miejsce się zwalnia, to pisarz wchodzi.
    + Zmniejsza się liczba oczekujących pisarzy, a wzrasta liczba pisarzy w czytelni.
- startReading:
  + Informacja o sytuacji w czytelni, a także o oczekujących,
  + Jeśli w czytelni jest pisarz lub więcej niż 5 czytelników, to czytelnik czeka (wait()),
  + Gdy miejsce się zwalnia, to czytelnik wchodzi.
  + Zmniejsza się liczba oczekujących czytelników, a wzrasta liczba czytelników w czytelni.
-endWriting:
  + Zostaje zwiększona liczba książek o jedną,
  + Maleje liczba pisarzy,
  + Powiadomione są inne wątki o tym, że pisarz skończył pisać.
-endReading:
  + Maleje liczba czytelników,
  + Powiadomione są inne wątki, że czytelnik zaczął czytać.

A także wątki:
- pisarz
- czytelnik

SPOSÓB URUCHOMIENIA PROGRAMU:
    Aby uruchomić program:
        1) Należy wykonać komendę:
             'mvn install'
        2) Należy uruchomić plik 'main-1.0-jar-with-dependencies.jar' poprzez komendę:
             'java -jar main-1.0-jar-with-dependencies.jar'
           W ten sposób uruchomimy program i na standardowe wyjście będą wypisywane informacje.
