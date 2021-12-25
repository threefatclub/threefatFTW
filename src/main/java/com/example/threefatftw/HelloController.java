package com.example.threefatftw;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController  implements Initializable {

    @FXML
    private Button weight;
    @FXML
    private Button length;
    @FXML
    private Button currency;
    @FXML
    private TextField toconvert;
    @FXML
    private TextField finalresult;
    @FXML
    private ChoiceBox<String>lbox =  new  ChoiceBox();
    @FXML
    private ChoiceBox<String> lbox1 =  new  ChoiceBox();
    @FXML
    private ChoiceBox<String> wbox =  new  ChoiceBox();
    @FXML
    private ChoiceBox<String> wbox1 =  new  ChoiceBox();
    @FXML
    private ChoiceBox<String> cbox =  new  ChoiceBox();
    @FXML
    private ChoiceBox<String> cbox1 =  new  ChoiceBox();
    @FXML
    private Button changemode;


    private String[] lengths = {
            "millimeter (mm)", "centimeter (cm)", "meter (m)", "kilometer (km)", "inch (in)", "foot / feet (ft)", "yard (yd)", "mile (mi)", "nautical mile (nmi)"
    };
    private String[] weights = {
            "gram (g, gm)", "kilogram (kg)", "pound (lb)", "ounce (oz)", "carat", "short ton (US)", "long ton (UK)", "tonne (metric ton)", "grain (gr)"
    };
    private String[] currencies = {"America | USD","Tunisia | TND","Euro | EUR"};
    //double [][] matrice = new double[5][5];
    public  Parent root;
    private Stage stage;
    private Scene scene;
    double l;
    int m = 0;
    private String s;
    public void switchtoweight(ActionEvent e) throws IOException{



        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("weight.fxml"));


         root = (Parent) loader. load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);

        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add("switchtoweight.css");
        stage.setScene(scene);


        stage.show();

    }

    public void switchtolength(ActionEvent e) throws IOException{

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("length.fxml"));

        Parent root = (Parent) loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add("switchtolength.css");

        stage.setScene(scene);
        stage.show();

    }
    public void switchtocurrency(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("currency.fxml"));
        Parent root = (Parent)loader.load();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add("switchtocurrency.css");
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbox.getItems().addAll(lengths);
        lbox1.getItems().addAll(lengths);
        wbox.getItems().addAll(weights);
        wbox1.getItems().addAll(weights);
        cbox.getItems().addAll(currencies);
        cbox1.getItems().addAll(currencies);
    }

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

        l = Double.valueOf(toconvert.getText());

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

        //System.out.println(len+":"+index+"///"+len1+":"+index1);



        double conversion = l * matrice[index][index1];
        finalresult.setText(Double.toString(conversion));
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


        l = Double.valueOf(toconvert.getText());

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

        //System.out.println(len+":"+index+"///"+len1+":"+index1);

        double conversion = l * matrice[index][index1];

        finalresult.setText(Double.toString(conversion));
    }

    public void convertcurrency(ActionEvent e) {
        double [][] matrice = new double[5][5];
        matrice[0][0] = 1;
        matrice[0][1] = 2.86;
        matrice[0][2] = 0.89;
        matrice[1][0] = 0.35;
        matrice[1][1] = 1;
        matrice[1][2] =0.31;
        matrice[2][0] = 1.13;
        matrice[2][1] = 3.22;
        matrice[2][2] = 1;

        l = Double.valueOf(toconvert.getText());

        String len = cbox.getValue();
        int index;
        if (len.equalsIgnoreCase("Tunisia | TND")){
            index = 1;
        }else{
            index = cbox.getSelectionModel().getSelectedIndex();
        }

        String len1 = cbox1.getValue();
        int index1;
        if (len1.equalsIgnoreCase("America | USD")){
            index1 = 0;
        }else{
            index1 = cbox1.getSelectionModel().getSelectedIndex();
        }

        //System.out.println(len+"///"+len1);


        double conversion = l * matrice[index][index1];

        finalresult.setText(Double.toString(conversion));
    }

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
        SingleSelectionModel<String> index = wbox.getSelectionModel();
        SingleSelectionModel<String> index1 = wbox1.getSelectionModel();

        wbox1.setSelectionModel(index);
        wbox.setSelectionModel(index1);

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

        SingleSelectionModel<String> index = lbox.getSelectionModel();
        SingleSelectionModel<String> index1 = lbox1.getSelectionModel();

        lbox1.setSelectionModel(index);
        lbox.setSelectionModel(index1);

        int i = lbox.getSelectionModel().getSelectedIndex();
        int i1 = lbox1.getSelectionModel().getSelectedIndex();

        double conversion = l * matrice[i][i1];

        finalresult.setText(Double.toString(conversion));
    }
    public void cswitch(ActionEvent e){
        double [][] matrice = new double[5][5];
        matrice[0][0] = 1;
        matrice[0][1] = 2.86;
        matrice[0][2] = 0.89;
        matrice[1][0] = 0.35;
        matrice[1][1] = 1;
        matrice[1][2] =0.31;
        matrice[2][0] = 1.13;
        matrice[2][1] = 3.22;
        matrice[2][2] = 1;

        SingleSelectionModel<String> index = cbox.getSelectionModel();
        SingleSelectionModel<String> index1 = cbox1.getSelectionModel();

        cbox1.setSelectionModel(index);
        cbox.setSelectionModel(index1);

        int i = cbox.getSelectionModel().getSelectedIndex();
        int i1 = cbox1.getSelectionModel().getSelectedIndex();

        double conversion = l * matrice[i][i1];

        finalresult.setText(Double.toString(conversion));
    }

    @FXML
    void requestUpdate(ActionEvent event) throws IOException {
       LiveResponse.main();
    }

}