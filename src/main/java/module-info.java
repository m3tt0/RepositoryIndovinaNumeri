module it.edu.isspitagora.indovinanumero {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.edu.isspitagora.indovinanumero to javafx.fxml;
    exports it.edu.isspitagora.indovinanumero;
}
