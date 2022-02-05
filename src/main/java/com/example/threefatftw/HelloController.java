package com.example.threefatftw;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloController  implements Initializable {


    Logger log = LoggerFactory.getLogger(this.getClass());

    @FXML
    private Button weight,game,generatexD;
    @FXML
    private Button length;
    @FXML
    private Button currency;
    @FXML
    private Button updateButton;

    @FXML
    private TextField toconvert;
    @FXML
    private TextField finalresult;

    @FXML
    private ComboBox<String>lbox =  new  ComboBox<>();
    @FXML
    private ComboBox<String> lbox1 =  new  ComboBox<>();
    @FXML
    private ComboBox<String> wbox =  new  ComboBox<>();
    @FXML
    private ComboBox<String> wbox1 =  new  ComboBox<>();
    @FXML
    private ComboBox<String> cbox =  new  ComboBox<>();
    @FXML
    private ComboBox<String> cbox1 =  new  ComboBox<>();

    Alert errorAlert = new Alert(Alert.AlertType.WARNING);
    @FXML
    private Parent root ;
    @FXML
    private  TextField input;
    @FXML
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,restart,delete;

    @FXML
    private  Label text,x;

    int y=0;
    public static String selectedMode;
    private String[] lengths = {
            "millimeter (mm)", "centimeter (cm)", "meter (m)", "kilometer (km)", "inch (in)", "foot / feet (ft)", "yard (yd)", "mile (mi)", "nautical mile (nmi)"
    };
    private String[] weights = {
            "gram (g, gm)", "kilogram (kg)", "pound (lb)", "ounce (oz)", "carat", "short ton (US)", "long ton (UK)", "tonne (metric ton)", "grain (gr)"
    };
    private String[] currencies = {
            "BIF", "MWK", "BYR", "BYN", "HUF", "AOA", "JPY", "MNT", "PLN", "GBP", "SBD", "AWG", "KRW", "NPR", "INR", "YER", "AFN", "MVR", "KZT", "SRD", "SZL", "LTL", "SAR", "TTD", "BHD", "HTG", "ANG", "PKR", "XCD", "LKR", "NGN", "CRC", "CZK", "ZWL", "GIP", "RON", "MMK", "MUR", "NOK", "SYP", "IMP", "CAD", "BGN", "RSD", "DOP", "KMF", "CUP", "GMD", "TWD", "IQD", "SDG", "BSD", "SLL", "CUC", "ZAR", "TND", "CLP", "HNL", "UGX", "MXN", "STD", "LVL", "SCR", "CDF", "BBD", "GTQ", "FJD", "TMT", "CLF", "BRL", "PEN", "NZD", "WST", "NIO", "BAM", "EGP", "MOP", "NAD", "BZD", "MGA", "XDR", "COP", "RUB", "PYG", "ISK", "JMD", "LYD", "BMD", "KWD", "PHP", "BDT", "CNY", "THB", "UZS", "XPF", "MRO", "IRR", "ARS", "QAR", "GNF", "ERN", "MZN", "SVC", "BTN", "UAH", "KES", "SEK", "CVE", "AZN", "TOP", "OMR", "PGK", "XOF", "GEL", "BTC", "UYU", "MAD", "FKP", "MYR", "EUR", "LSL", "DKK", "JOD", "HKD", "RWF", "AED", "BWP", "SHP", "TRY", "LBP", "TJS", "IDR", "KYD", "AMD", "GHS", "GYD", "KPW", "BOB", "KHR", "MDL", "AUD", "ILS", "TZS", "VND", "XAU", "ZMW", "LRD", "XAG", "ALL", "CHF", "HRK", "DJF", "XAF", "KGS", "SOS", "VEF", "VUV", "LAK", "BND", "ZMK", "ETB", "JEP", "DZD", "PAB", "GGP", "SGD", "MKD", "USD"
    };

    //double [][] matrice = new double[5][5];
    private Stage stage;
    private Scene scene;
    double l;
    int m = 0;
    private String s;

            /*                  ███████╗██╗   ██╗███╗   ██╗ ██████╗████████╗██╗ ██████╗ ███╗   ██╗███████╗
                                ██╔════╝██║   ██║████╗  ██║██╔════╝╚══██╔══╝██║██╔═══██╗████╗  ██║██╔════╝
                                █████╗  ██║   ██║██╔██╗ ██║██║        ██║   ██║██║   ██║██╔██╗ ██║███████╗
                                ██╔══╝  ██║   ██║██║╚██╗██║██║        ██║   ██║██║   ██║██║╚██╗██║╚════██║
                                ██║     ╚██████╔╝██║ ╚████║╚██████╗   ██║   ██║╚██████╔╝██║ ╚████║███████║
                                ╚═╝      ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbox.getItems().addAll(lengths);
        lbox1.getItems().addAll(lengths);
        wbox.getItems().addAll(weights);
        wbox1.getItems().addAll(weights);
        cbox.getItems().addAll(currencies);
        cbox1.getItems().addAll(currencies);


    }

    @FXML
    void requestUpdate(ActionEvent event) throws IOException {
        //Test.main();
//        LiveResponse.main();
        FatJarLauncher.globalValues = LiveResponse.storeLiveRequest();
    }

/*                  ███████ ██     ██ ██ ████████  ██████ ██   ██     ███████ ██████   █████  ███    ███ ███████
                    ██      ██     ██ ██    ██    ██      ██   ██     ██      ██   ██ ██   ██ ████  ████ ██
                    ███████ ██  █  ██ ██    ██    ██      ███████     █████   ██████  ███████ ██ ████ ██ █████
                         ██ ██ ███ ██ ██    ██    ██      ██   ██     ██      ██   ██ ██   ██ ██  ██  ██ ██
                    ███████  ███ ███  ██    ██     ██████ ██   ██     ██      ██   ██ ██   ██ ██      ██ ███████*/

    public void switchtoweight(ActionEvent e) throws IOException{



        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Weight.fxml"));

        selectedMode = "weight";
        root = loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);

        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add("switchtoweight.css");
        stage.setScene(scene);


        stage.show();

    }
    public void switchtolength(ActionEvent e) throws IOException{

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Length.fxml"));

        selectedMode= "length";
        Parent root = loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add("switchtolength.css");

        stage.setScene(scene);
        stage.show();

    }
    public void switchtocurrency(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Currency.fxml"));

        selectedMode="currency";
        Parent root = loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add("switchtocurrency.css");
        stage.setScene(scene);
        stage.show();

    }

/*                   ██████  ██████  ███    ██ ██    ██ ███████ ██████  ████████     ██    ██  █████  ██      ██    ██ ███████ ███████
                    ██      ██    ██ ████   ██ ██    ██ ██      ██   ██    ██        ██    ██ ██   ██ ██      ██    ██ ██      ██
                    ██      ██    ██ ██ ██  ██ ██    ██ █████   ██████     ██        ██    ██ ███████ ██      ██    ██ █████   ███████
                    ██      ██    ██ ██  ██ ██  ██  ██  ██      ██   ██    ██         ██  ██  ██   ██ ██      ██    ██ ██           ██
                     ██████  ██████  ██   ████   ████   ███████ ██   ██    ██          ████   ██   ██ ███████  ██████  ███████ ███████*/

    public void convertlength(ActionEvent e) {
        double[][]  matrice = {
                {1,0.1,0.001,0.000001,0.039370078740157,0.0032808398950131,0.0010936132983377,6.2137119223733e-7,5.3995680345572e-7},
                {10,1,0.01,0.00001,0.39370078740157,0.032808398950131,0.010936132983377,0.0000062137119223733,0.0000053995680345572},
                {1000,100,1,0.001,39.370078740157,3.2808398950131,1.0936132983377,0.00062137119223733,0.00053995680345572},
                {1000000,100000,1000,1,39370.078740157,3280.8398950131,1093.6132983377,0.62137119223733,0.53995680345572},
                {25.4,2.54,0.0254,0.0000254,1,0.083333333333333,0.027777777777778,0.000015782828282828,0.000013714902807775},
                {304.8,30.48,0.3048,0.0003048,12,1,0.33333333333333,0.00018939393939394,0.0001645788336933},
                {914.4,91.44,0.9144,0.0009144,36,3,1,0.00056818181818182,0.00049373650107991},
                {1609344,160934.4,1609.344,1.609344,63360,5280,1760,1,0.86897624190065},
                {1852000,185200,1852,1.852,72913.385826772,6076.1154855643,2025.3718285214,1.1507794480235,1}
        };
        if (toconvert.getText().trim().isEmpty()){
            errorAlert.setTitle("Input not valid");
            errorAlert.setHeaderText("An error has been encountered");
            errorAlert.setContentText("Please input a valid number");
            errorAlert.showAndWait();

        } else {
            l = Double.parseDouble(toconvert.getText());

            String len = lbox.getValue();
            int index;
            if (len.equalsIgnoreCase("meter (m)")){
                index=2;
            }else{
                index = lbox.getSelectionModel().getSelectedIndex();
            }

            String len1 = lbox1.getValue();
            int index1;
            if (len1.equalsIgnoreCase("mile (mi)")){
                index1=7;
            }else{
                index1 = lbox1.getSelectionModel().getSelectedIndex();
            }

            double conversion = l * matrice[index][index1];
            finalresult.setText(Double.toString(conversion));}
    }
    public void convertweight(ActionEvent e) {
        double[][]  matrice = {
                {1,0.001,0.0022046226218488,0.03527396194958,5,0.0000011023113109244,9.8420652761106e-7,0.000001,15.432358352941},
                {1000,1,2.2046226218488,35.27396194958,5000,0.0011023113109244,0.00098420652761106,0.001,15432.358352941},
                {453.59237,0.45359237,1,16,2267.96185,0.0005,0.00044642857142857,0.00045359237,7000},
                {28.349523125,0.028349523125,0.0625,1,141.747615625,0.00003125,0.000027901785714286,0.000028349523125,437.5},
                {0.2,0.0002,0.00044092452436976,0.0070547923899161,1,2.2046226218488e-7,1.9684130552221e-7,2e-7,3.0864716705883},
                {907184.74,907.18474,2000,32000,4535923.7,1,0.89285714285714,0.90718474,14000000},
                {1016046.9088,1016.0469088,2240,35840,5080234.544,1.12,1,1.0160469088,15680000},
                {1000000,1000,2204.6226218488,35273.96194958,5000000,1.1023113109244,0.9842065276110611,1,15432358.352941},
                {0.06479891,0.00006479891,0.00014285714285714,0.0022857142857143,0.32399455,7.1428571428571e-8,6.3775510204082e-8,6.479891e-8,1}
        };

        if (toconvert.getText().trim().isEmpty()){
            errorAlert.setTitle("Input not valid");
            errorAlert.setHeaderText("An error has been encountered");
            errorAlert.setContentText("Please input a valid number");
            errorAlert.showAndWait();

        } else {
            l = Double.parseDouble(toconvert.getText());

            String len = wbox.getValue();
            int index;
            if (len.equalsIgnoreCase("kilogram (kg)")){
                index=1;
            }else{
                index = wbox.getSelectionModel().getSelectedIndex();
            }

            String len1 = wbox1.getValue();
            int index1;
            if (len1.equalsIgnoreCase("pound (lb)")){
                index1=2;
            }else{
                index1 = wbox1.getSelectionModel().getSelectedIndex();
            }

//            log.info("{}:{}///{}:{}", len, index, len1, index1);

            double conversion = l * matrice[index][index1];

            finalresult.setText(Double.toString(conversion));}
    }
    public void convertcurrency(ActionEvent e) {
        int index;
        int index1;
        if (toconvert.getText().trim().isEmpty()){
            errorAlert.setTitle("Input not valid");
            errorAlert.setHeaderText("An error has been encountered");
            errorAlert.setContentText("Please input a valid number");
            errorAlert.showAndWait();

        } else {
            l = Double.parseDouble(toconvert.getText());

            String len = cbox.getValue();
            if (len.equalsIgnoreCase("TND")){
                index = 55;
            }else{
                index = cbox.getSelectionModel().getSelectedIndex();
            }
            String len1 = cbox1.getValue();
            if (len1.equalsIgnoreCase("USD")){
                index1 = 167;
            }else{
                index1 = cbox1.getSelectionModel().getSelectedIndex();
            }

//            log.info("\u001B[36m", index, index1);
            double[] rates = Currency.convert(index1,index);

            double conversion = l * rates[0]/rates[1];

            finalresult.setText(Double.toString(conversion));}
    }
    public void konvertlength(KeyEvent e) {
        double[][]  matrice = {
                {1,0.1,0.001,0.000001,0.039370078740157,0.0032808398950131,0.0010936132983377,6.2137119223733e-7,5.3995680345572e-7},
                {10,1,0.01,0.00001,0.39370078740157,0.032808398950131,0.010936132983377,0.0000062137119223733,0.0000053995680345572},
                {1000,100,1,0.001,39.370078740157,3.2808398950131,1.0936132983377,0.00062137119223733,0.00053995680345572},
                {1000000,100000,1000,1,39370.078740157,3280.8398950131,1093.6132983377,0.62137119223733,0.53995680345572},
                {25.4,2.54,0.0254,0.0000254,1,0.083333333333333,0.027777777777778,0.000015782828282828,0.000013714902807775},
                {304.8,30.48,0.3048,0.0003048,12,1,0.33333333333333,0.00018939393939394,0.0001645788336933},
                {914.4,91.44,0.9144,0.0009144,36,3,1,0.00056818181818182,0.00049373650107991},
                {1609344,160934.4,1609.344,1.609344,63360,5280,1760,1,0.86897624190065},
                {1852000,185200,1852,1.852,72913.385826772,6076.1154855643,2025.3718285214,1.1507794480235,1}
        };
        if (toconvert.getText().trim().isEmpty()){
            errorAlert.setTitle("Input not valid");
            errorAlert.setHeaderText("An error has been encountered");
            errorAlert.setContentText("Please input a valid number");
            errorAlert.showAndWait();

        } else {
            l = Double.parseDouble(toconvert.getText());

            String len = lbox.getValue();
            int index;
            if (len.equalsIgnoreCase("meter (m)")){
                index=2;
            }else{
                index = lbox.getSelectionModel().getSelectedIndex();
            }

            String len1 = lbox1.getValue();
            int index1;
            if (len1.equalsIgnoreCase("mile (mi)")){
                index1=7;
            }else{
                index1 = lbox1.getSelectionModel().getSelectedIndex();
            }

            double conversion = l * matrice[index][index1];
            finalresult.setText(Double.toString(conversion));}
    }
    public void konvertweight(KeyEvent e) {
        double[][]  matrice = {
                {1,0.001,0.0022046226218488,0.03527396194958,5,0.0000011023113109244,9.8420652761106e-7,0.000001,15.432358352941},
                {1000,1,2.2046226218488,35.27396194958,5000,0.0011023113109244,0.00098420652761106,0.001,15432.358352941},
                {453.59237,0.45359237,1,16,2267.96185,0.0005,0.00044642857142857,0.00045359237,7000},
                {28.349523125,0.028349523125,0.0625,1,141.747615625,0.00003125,0.000027901785714286,0.000028349523125,437.5},
                {0.2,0.0002,0.00044092452436976,0.0070547923899161,1,2.2046226218488e-7,1.9684130552221e-7,2e-7,3.0864716705883},
                {907184.74,907.18474,2000,32000,4535923.7,1,0.89285714285714,0.90718474,14000000},
                {1016046.9088,1016.0469088,2240,35840,5080234.544,1.12,1,1.0160469088,15680000},
                {1000000,1000,2204.6226218488,35273.96194958,5000000,1.1023113109244,0.9842065276110611,1,15432358.352941},
                {0.06479891,0.00006479891,0.00014285714285714,0.0022857142857143,0.32399455,7.1428571428571e-8,6.3775510204082e-8,6.479891e-8,1}
        };

        if (toconvert.getText().trim().isEmpty()){
            errorAlert.setTitle("Input not valid");
            errorAlert.setHeaderText("An error has been encountered");
            errorAlert.setContentText("Please input a valid number");
            errorAlert.showAndWait();

        } else {
            l = Double.parseDouble(toconvert.getText());

            String len = wbox.getValue();
            int index;
            if (len.equalsIgnoreCase("kilogram (kg)")){
                index=1;
            }else{
                index = wbox.getSelectionModel().getSelectedIndex();
            }

            String len1 = wbox1.getValue();
            int index1;
            if (len1.equalsIgnoreCase("pound (lb)")){
                index1=2;
            }else{
                index1 = wbox1.getSelectionModel().getSelectedIndex();
            }

//            log.info("{}:{}///{}:{}", len, index, len1, index1);

            double conversion = l * matrice[index][index1];

            finalresult.setText(Double.toString(conversion));}
    }
    public void konvertcurrency(KeyEvent e) {
        int index;
        int index1;
        if (toconvert.getText().trim().isEmpty()){
            errorAlert.setTitle("Input not valid");
            errorAlert.setHeaderText("An error has been encountered");
            errorAlert.setContentText("Please input a valid number");
            errorAlert.showAndWait();

        } else {
            l = Double.parseDouble(toconvert.getText());

            String len = cbox.getValue();
            if (len.equalsIgnoreCase("TND")){
                index = 55;
            }else{
                index = cbox.getSelectionModel().getSelectedIndex();
            }
            String len1 = cbox1.getValue();
            if (len1.equalsIgnoreCase("USD")){
                index1 = 167;
            }else{
                index1 = cbox1.getSelectionModel().getSelectedIndex();
            }

//            log.info("\u001B[32m", index, index1);
            double[] rates = Currency.convert(index1,index);

            double conversion = l * rates[0]/rates[1];

            finalresult.setText(Double.toString(conversion));}
    }

/*                  ███████ ██     ██ ██ ████████  ██████ ██   ██     ██    ██  █████  ██      ██    ██ ███████ ███████
                    ██      ██     ██ ██    ██    ██      ██   ██     ██    ██ ██   ██ ██      ██    ██ ██      ██
                    ███████ ██  █  ██ ██    ██    ██      ███████     ██    ██ ███████ ██      ██    ██ █████   ███████
                         ██ ██ ███ ██ ██    ██    ██      ██   ██      ██  ██  ██   ██ ██      ██    ██ ██           ██
                    ███████  ███ ███  ██    ██     ██████ ██   ██       ████   ██   ██ ███████  ██████  ███████ ███████ */

    public void wswitch(ActionEvent e){
        double[][]  matrice = {
                {1,0.001,0.0022046226218488,0.03527396194958,5,0.0000011023113109244,9.8420652761106e-7,0.000001,15.432358352941},
                {1000,1,2.2046226218488,35.27396194958,5000,0.0011023113109244,0.00098420652761106,0.001,15432.358352941},
                {453.59237,0.45359237,1,16,2267.96185,0.0005,0.00044642857142857,0.00045359237,7000},
                {28.349523125,0.028349523125,0.0625,1,141.747615625,0.00003125,0.000027901785714286,0.000028349523125,437.5},
                {0.2,0.0002,0.00044092452436976,0.0070547923899161,1,2.2046226218488e-7,1.9684130552221e-7,2e-7,3.0864716705883},
                {907184.74,907.18474,2000,32000,4535923.7,1,0.89285714285714,0.90718474,14000000},
                {1016046.9088,1016.0469088,2240,35840,5080234.544,1.12,1,1.0160469088,15680000},
                {1000000,1000,2204.6226218488,35273.96194958,5000000,1.1023113109244,0.9842065276110611,1,15432358.352941},
                {0.06479891,0.00006479891,0.00014285714285714,0.0022857142857143,0.32399455,7.1428571428571e-8,6.3775510204082e-8,6.479891e-8,1}
        };
        SingleSelectionModel<String>  index = wbox.getSelectionModel();
        String sindex = wbox.getSelectionModel().getSelectedItem();
        SingleSelectionModel<String> index1 = wbox1.getSelectionModel();
        String sindex1 = wbox1.getSelectionModel().getSelectedItem();

        wbox1.setSelectionModel(index);
        wbox1.setValue(sindex);
        wbox.setSelectionModel(index1);
        wbox.setValue(sindex1);

        int i = wbox.getSelectionModel().getSelectedIndex();
        int i1 = wbox1.getSelectionModel().getSelectedIndex();

        double conversion = l * matrice[i][i1];

        finalresult.setText(Double.toString(conversion));
    }
    public void lswitch(ActionEvent e){
        double[][]  matrice = {
                {1,0.1,0.001,0.000001,0.039370078740157,0.0032808398950131,0.0010936132983377,6.2137119223733e-7,5.3995680345572e-7},
                {10,1,0.01,0.00001,0.39370078740157,0.032808398950131,0.010936132983377,0.0000062137119223733,0.0000053995680345572},
                {1000,100,1,0.001,39.370078740157,3.2808398950131,1.0936132983377,0.00062137119223733,0.00053995680345572},
                {1000000,100000,1000,1,39370.078740157,3280.8398950131,1093.6132983377,0.62137119223733,0.53995680345572},
                {25.4,2.54,0.0254,0.0000254,1,0.083333333333333,0.027777777777778,0.000015782828282828,0.000013714902807775},
                {304.8,30.48,0.3048,0.0003048,12,1,0.33333333333333,0.00018939393939394,0.0001645788336933},
                {914.4,91.44,0.9144,0.0009144,36,3,1,0.00056818181818182,0.00049373650107991},
                {1609344,160934.4,1609.344,1.609344,63360,5280,1760,1,0.86897624190065},
                {1852000,185200,1852,1.852,72913.385826772,6076.1154855643,2025.3718285214,1.1507794480235,1}
        };

        SingleSelectionModel<String>  index = lbox.getSelectionModel();
        String sindex = lbox.getSelectionModel().getSelectedItem();
        String sindex1 = lbox1.getSelectionModel().getSelectedItem();
        SingleSelectionModel<String> index1 = lbox1.getSelectionModel();
        lbox1.setSelectionModel(index);
        lbox1.setValue(sindex);
        lbox.setSelectionModel(index1);
        lbox.setValue(sindex1);

        int i = lbox.getSelectionModel().getSelectedIndex();
        int i1 = lbox1.getSelectionModel().getSelectedIndex();

        double conversion = l * matrice[i][i1];

        finalresult.setText(Double.toString(conversion));
    }
    public void cswitch(ActionEvent e){

        SingleSelectionModel<String>  index = cbox.getSelectionModel();
        String sindex = cbox.getSelectionModel().getSelectedItem();
        String sindex1 = cbox1.getSelectionModel().getSelectedItem();
        SingleSelectionModel<String> index1 = cbox1.getSelectionModel();
        cbox1.setSelectionModel(index);
        cbox1.setValue(sindex);
        cbox.setSelectionModel(index1);
        cbox.setValue(sindex1);
        convertcurrency(e);
    }

/*                  ██   ██ ███████ ██    ██ ██████   ██████   █████  ██████  ██████      ███████ ██    ██ ███████ ███    ██ ████████
                    ██  ██  ██       ██  ██  ██   ██ ██    ██ ██   ██ ██   ██ ██   ██     ██      ██    ██ ██      ████   ██    ██
                    █████   █████     ████   ██████  ██    ██ ███████ ██████  ██   ██     █████   ██    ██ █████   ██ ██  ██    ██
                    ██  ██  ██         ██    ██   ██ ██    ██ ██   ██ ██   ██ ██   ██     ██       ██  ██  ██      ██  ██ ██    ██
                    ██   ██ ███████    ██    ██████   ██████  ██   ██ ██   ██ ██████      ███████   ████   ███████ ██   ████    ██ */

    public void keyPressed(KeyEvent k){
        System.out.println(k.getText() +"/////"+k.getSource() +"/////"+k.getCode()+"///"+HelloController.selectedMode);
        String window = HelloController.selectedMode;
        switch (window){
            case "length":
                lengthKey(k);
                break;
            case "game":
                gameKey(k);
                break;
            case "currency":
                currencyKey(k);
                break;
            case "weight":
                weightKey(k);
                break;

        }


    }

    private void lengthKey(KeyEvent k) {
        System.out.println("lengthKey: "+k.getText());
        if (k.getCode().equals(KeyCode.ENTER)){
            konvertlength(k);
        }
    }
    private void currencyKey(KeyEvent k) {
        System.out.println("currencyKey: "+k.getText());
        if (k.getCode().equals(KeyCode.ENTER)){
            konvertcurrency(k);
        }
    }
    private void weightKey(KeyEvent k) {
        System.out.println("weightKey: "+k.getText());
        if (k.getCode().equals(KeyCode.ENTER)){
            konvertweight(k);

        }}
    private void gameKey(KeyEvent k) {
        System.out.println("gameKey: "+k.getText());
        switch (k.getCode()){
            case ENTER:
                System.out.println("aazazaazaazaaazaaaazaz");
                int G=Integer.parseInt(input.getText());
                y=y+1;
                x.setText(String.valueOf(y));
                if (y==5) {
                    text.setText("Sorry but you lost !");
                    generatexD.setDisable(true);
                    restart.setDisable(false);
                    restart.setDefaultButton(true);

                }
                else if (G==R){
                    text.setText("You have guessed correctly !");
                    generatexD.setDisable(true);
                    restart.setDisable(false);
                    restart.setDefaultButton(true);

                }
                else if (G>R) {
                    text.setText ("Too high");
                    input.setText("");
                }
                else if (R>G) {
                    text.setText ("Too Low");
                    input.setText("");
                }
                break;
            case BACK_SPACE:
                input.setText(input.getText().substring(0,input.getText().length()-1));
                break;
            case NUMPAD0,NUMPAD1,NUMPAD2,NUMPAD3,NUMPAD4,NUMPAD5,NUMPAD6,NUMPAD7,NUMPAD8,NUMPAD9,DIGIT0,DIGIT1,DIGIT2,DIGIT3,DIGIT4,DIGIT5,DIGIT6,DIGIT7,DIGIT8,DIGIT9 :
                if (Integer.parseInt(input.getText()+k.getText())<=100){
                    input.setText(input.getText()+k.getText());
                }
                break;
            default:
                System.out.println("aaa///"+k.getSource());
                if (k.getSource().equals("AnchorPane@5f767890[styleClass=root]")) {
                    System.out.println("aaaaaaaaa");
                }
                break;
        }
    }

    /*               ██████  ██    ██ ███████ ███████ ███████ ██ ███    ██  ██████       ██████   █████  ███    ███ ███████
                    ██       ██    ██ ██      ██      ██      ██ ████   ██ ██           ██       ██   ██ ████  ████ ██
                    ██   ███ ██    ██ █████   ███████ ███████ ██ ██ ██  ██ ██   ███     ██   ███ ███████ ██ ████ ██ █████
                    ██    ██ ██    ██ ██           ██      ██ ██ ██  ██ ██ ██    ██     ██    ██ ██   ██ ██  ██  ██ ██
                     ██████   ██████  ███████ ███████ ███████ ██ ██   ████  ██████       ██████  ██   ██ ██      ██ ███████ */

    public void game(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Game.fxml"));

        selectedMode="game";
        root = loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);

        scene.getStylesheets().add("style.css");

        stage.setScene(scene);


        stage.show();
    }

    Random random = new Random();
    int up = 100 ;
    int R = random.nextInt(up);
    public void buttons(ActionEvent e) {
        Button[] numberButton = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9};
        for (int a = 0; a < 10; a++) {
            if (e.getSource() == numberButton[a] && Integer.parseInt(input.getText() + numberButton[a].getText()) <= 100) {
                input.setText(input.getText() + numberButton[a].getText());
            }
        }

        restart.setOnAction(actionEvent -> {
            input.setText("");
            x.setText("0");
            generatexD.setDisable(false);
            input.setDisable(false);
            y = 0;
            restart.setDisable(true);
            generatexD.setDefaultButton(true);

        });
        delete.setOnAction(actionEvent -> input.setText(input.getText().substring(0, input.getText().length() - 1)));


        // Todo: fix 'For input string: ""' error
        // Todo: add keyboard input
        if (e.getSource() == generatexD) {
            text.setAlignment(Pos.CENTER);
            int G = Integer.parseInt(input.getText());
            y = y + 1;
            x.setText(String.valueOf(y));
            if (y == 5) {
                text.setText("Sorry but you lost !");
                generatexD.setDisable(true);
                restart.setDisable(false);
                restart.setDefaultButton(true);

            } else if (G == R) {
                text.setText("You have guessed correctly !");
                generatexD.setDisable(true);
                restart.setDisable(false);
                restart.setDefaultButton(true);

            } else if (G > R) {
                text.setText("Too high");
                input.setText("");
            } else if (R > G) {
                text.setText("Too Low");
                input.setText("");
            }

        }
    }}
