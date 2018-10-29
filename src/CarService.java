import Servicebook1.Date;
import Servicebook1.Service;
import Servicebook1.ServiceBook;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class CarService extends Application {

    static ServiceBook serviceBook1;

    public static void main(String[]args){

        Date date1=new Date(10,10,2010);
        Date date2=new Date(11,11,2011);
        Date date3=new Date(10,10,2010);
        Date date4=new Date(02,02,2011);
        Date date5=new Date(19,03,2006);
        Date date6=new Date(28,10,2018);

        Service service1=new Service(105222,date1);
        Service service2=new Service(15236,date2);
        Service service3=new Service(87562,date3);
        Service service4=new Service(450000,date4);
        Service service5=new Service(203412,date5);
        Service service6=new Service(155250,date6);



        serviceBook1 = new ServiceBook();
        serviceBook1.addService(service1);
        serviceBook1.addService(service2);
        serviceBook1.addService(service3);
        serviceBook1.addService(service4);
        serviceBook1.addService(service5);
        serviceBook1.addService(service6);

        System.out.println(serviceBook1.getService(0));
        System.out.println("Show all services in servicebook"+serviceBook1.getAllService());

        System.out.println("The number of services in servicebook is: " +serviceBook1.getNumberOfService());

        //husk at for at få listen af mileage frem, er man nødt til at lave et array//
        //først kaldes getAllServiceMileage til et array//
        int[]array=serviceBook1.getAllServiceMileage();
        //så laves en for loop med en definition af indexet//
        for(int i = 0; i < array.length; i++){
            //så printes array listen
            System.out.println("Mileage for index "+i+" is "+array[i]);
        }

        if (date3.equals(date1)){
            System.out.println("The dates are equal");
        }
        else{
            System.out.println("The dates are not equal");
        }

        System.out.println("Last service vas on "+serviceBook1.getDateOfLastService());

        //sammenligner new date, med service
        // datoerne i serviceBook//
        System.out.println("Are the dates matching? "+serviceBook1.hasServiceOnDate( new Date(19,03,2006)));


launch(args);


    }

    public CarService() {
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("ServiceBook");

        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        Text scenetitle=new Text("SERVICEBOOK");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle,0,0,2,1);

        Label addService=new Label("Add Service by choosing date and type mileage:  ");
        grid.add(addService,0,1);


        final DatePicker datePicker=new DatePicker();

        datePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate datePickerValue=datePicker.getValue();
            }

        });
        grid.add(datePicker,0,2);

        Button datePickerButton = new Button("Add service");
        HBox hDatePickerButton = new HBox(20);
        grid.add(datePickerButton,0,3);
        final Text datePickerText=new Text();

        datePickerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate value = datePicker.getValue();
                datePickerText.setText("Service added on date: "+value);

            }
        });
        grid.add(datePickerText,0,4);

        TextField addMileageField=new TextField("Add mileage: ");
        grid.add(addMileageField,1,2);

        final Text addMileageFieldText=new Text();

        addMileageField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addMileageFieldText.setText("Mileage added! ");
            }
        });
        grid.add(addMileageFieldText,3,5);




        Button getNumberOfServices=new Button("Show number of services");
        HBox hgetNumberOfServices=new HBox(20);
        hgetNumberOfServices.getChildren().add(getNumberOfServices);
        grid.add(getNumberOfServices,0,5);

        final Text actiontarget=new Text();


        getNumberOfServices.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actiontarget.setText("Number of services in Servicebook is: "+serviceBook1.getNumberOfService());

            }

        });
        grid.add(actiontarget,0,6);

        Button getAllServices=new Button("Show all Services");
        HBox hgetAllServices=new HBox(20);
        hgetAllServices.getChildren().add(getAllServices);
        grid.add(getAllServices,0,7);

        final Text actiontarget2=new Text();


        getAllServices.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actiontarget2.setText("Showing all services: "+serviceBook1.getAllService());
                actiontarget2.setWrappingWidth(500);
            }
        });
        grid.add(actiontarget2,0,8);

        Button getAllServiceMileages=new Button("Show all service mileages");
        HBox hgetAllServiceMileages=new HBox(20);
        hgetAllServiceMileages.getChildren().add(getAllServiceMileages);
        grid.add(getAllServiceMileages,0,9);

        final Text actiontarget3=new Text();



        getAllServiceMileages.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actiontarget3.setText("All Services: "+serviceBook1.getAllServiceMileage());


            }
        });
        grid.add(actiontarget3,0,10);


        Button getDateOfLastService=new Button("Show date of last service");
        HBox hgetDateOfLastService=new HBox(20);
        hgetAllServiceMileages.getChildren().add(getDateOfLastService);
        grid.add(getDateOfLastService,0,11);

        final Text actiontarget4=new Text();


        getDateOfLastService.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actiontarget4.setText("The date of last service was: "+serviceBook1.getDateOfLastService());
            }
        });
        grid.add(actiontarget4,0,12);

        Label serviceOnDate=new Label("Check if service is on date");
        grid.add(serviceOnDate,0,13);

        final DatePicker datePicker1=new DatePicker();

        datePicker1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate localDate=datePicker1.getValue();
            }
        });
        grid.add(datePicker1, 0,14);

        Button isServiceOnDateButton =new Button("Check dates");
        grid.add(isServiceOnDateButton,0,15);

        final Text actiontarget5=new Text();
        isServiceOnDateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actiontarget5.setText("True/false? ");
            }
        });
        grid.add(actiontarget5,0,16);





        Scene scene=new Scene (grid);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(750);
        primaryStage.setMinHeight(800);
        primaryStage.setResizable(true);





        primaryStage.show();










    }
}
