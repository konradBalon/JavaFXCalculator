package sample;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Operation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;


public class Controller {

    double currentNumber = 0.0;
    double wynik = 0;
    boolean isFirstNumber = true;


    @FXML
    void initialize() {
        // ta metoda wywola sie po stworzeniu widokow
        // taki troche konstrukotr
    }

    @FXML
    Label poleHistorii;

    @FXML
    Label poleTekstowe;

//    @FXML
//    Button *nazwa*;
// NIE TRZEBA TEGO PISAC, BO NIE ZMIENIAMY NAZWY PRZYCISKOW,

    @FXML
    public void wpiszJeden() {
        dodajCyfre("1");
    }

    @FXML
    public void wpiszDwa() {
        dodajCyfre("2");
    }

    @FXML
    public void wpiszTrzy() {
        dodajCyfre("3");
    }

    @FXML
    public void wpiszCztery() {
        dodajCyfre("4");
    }

    @FXML
    public void wpiszPiec() {
        dodajCyfre("5");
    }

    @FXML
    public void wpiszSzesc() {
        dodajCyfre("6");
    }

    @FXML
    public void wpiszSiedem() {
        dodajCyfre("7");
    }

    @FXML
    public void wpiszOsiem() {
        dodajCyfre("8");
    }

    @FXML
    public void wpiszDziewiec() {
        dodajCyfre("9");
    }

    @FXML
    public void wpiszZero() {
        dodajCyfre("0");
    }

    @FXML
    public void add00() {
        dodajCyfre("00");
    }

    @FXML
    public void addDot() {
        dodajCyfre(".");
    }

    @FXML
    public void czyscEkran() {
        poleTekstowe.setText("");
    }

    @FXML
    public void czyscWszystko() {
        poleTekstowe.setText("");
        poleHistorii.setText("");
        currentNumber = 0;
        wynik = 0;
        isFirstNumber = true;
        operation = Operations.EMPTY;
    }

    Operations operation = Operations.EMPTY;


    public void dodajCyfre(String cyfra) {
        poleTekstowe.setText(poleTekstowe.getText() + cyfra);
    }

    public void cofnijCyfre() {
        int i = poleTekstowe.getText().length();
        String liczba = poleTekstowe.getText().substring(0, i - 1);
        poleTekstowe.setText(liczba);



        }

    public void changeChar() {
        wynik=-wynik;
          poleTekstowe.setText(""+wynik);
       }


       // int dlugosc = poleTekstowe.getText().length();
    // poleTekstowe.setText(poleTekstowe.getText().substring(1,dlugosc));



        private double getCurrentNumber() {
        String numberAsString = poleTekstowe.getText();
        currentNumber = Double.parseDouble(numberAsString);
        return currentNumber;
    }

    @FXML
    public void Odejm() {
        currentNumber = getCurrentNumber();
        addToHistory('-');
        if (!isFirstNumber) {
            doTheMath();
        } else {
            wynik = currentNumber;
            isFirstNumber = false;
        }
        poleTekstowe.setText("");
        operation = Operations.ODEJMOWANIE;
    }

    @FXML
    public void Dodaj() {
        //pobierz numer
        //przypisz zmienne
        //oblicz wynik
        currentNumber = getCurrentNumber();
        addToHistory('+');
        if (!isFirstNumber) {
            doTheMath();
        } else {
            wynik = currentNumber;
            isFirstNumber = false;
        }
        poleTekstowe.setText("");
        operation = Operations.DODAWANIE;

    }

    @FXML
    public void divide() {
        currentNumber = getCurrentNumber();
        addToHistory('/');
        if (!isFirstNumber) {
            doTheMath();
        } else {
            wynik = currentNumber;
            isFirstNumber = false;

        }
        poleTekstowe.setText("");
        operation = Operations.DZIELENIE;


    }

    @FXML
    public void multiply() {
        currentNumber = getCurrentNumber();
        addToHistory('*');
        if (!isFirstNumber) {
            doTheMath();
        } else {
            wynik = currentNumber;
            isFirstNumber = false;

        }
        poleTekstowe.setText("");
        operation = Operations.MNOZENIE;
    }


    private void doTheMath() {

        switch (operation) {
            case DODAWANIE: {
                wynik += currentNumber;

                break;
            }
            case ODEJMOWANIE: {
                wynik -= currentNumber;
                break;
            }
            case MNOZENIE: {
                wynik *= currentNumber;
                break;
            }
            case DZIELENIE: {
                wynik /= currentNumber;
                break;
            }
            default:
                break;
        }
        currentNumber = 0;// zerujemy zmienne po wykonanej operacji
        operation = Operations.EMPTY;

    }


    @FXML
    public void equals() {
        currentNumber = getCurrentNumber();
        addToHistory('=');
        doTheMath();
        operation = Operations.EMPTY;
        poleTekstowe.setText("" + wynik);


}
    public void addToHistory(char znak){

        poleHistorii.setText(poleHistorii.getText()+ " " +currentNumber+" "+znak);

}

}




