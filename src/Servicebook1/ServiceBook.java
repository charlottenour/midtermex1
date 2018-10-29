package Servicebook1;

import java.util.ArrayList;

public class ServiceBook {
    private int AllServiceMileage;
    private boolean ServiceOnDate;
    private Date DateOfLastService;

    public ArrayList<Service> services=new ArrayList<>();


    public void addService(Service service){
        services.add(service);
    }
    public int getNumberOfService(){
        return services.size();
    }
    public Service getService(int index){
        return(services.get(index));
    }
    public ArrayList getAllService(){
        return services;
    }

    public int[] getAllServiceMileage() {

        int[] mileage = new int[services.size()];
        int i = 0;
        for (Service service : services) {
            mileage[i] = service.getMileage ();
            i++;
        }
        return mileage;
    }


    public boolean hasServiceOnDate(Date date){

        //for loop for at sammenligne to datoer for at tjekke om der//
        //er service på en given dato.//
        for (Service service:services){
            Date serviceDate = service.getDate();
            if (date.equals(serviceDate)){
                return true;
            }
        }
        return false;
    }



    public Date getDateOfLastService() {
        Service lastService = services.get(0);
        for (Service service : services) {
            if (lastService.isOlder(service)) {
                lastService = service;

            }
        }
        return lastService.getDate();

    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "ServiceBook{" +
                "AllServiceMileage=" + AllServiceMileage +
                ", ServiceOnDate=" + ServiceOnDate +
                ", DateOfLastService=" + DateOfLastService +
                '}';
    }
}
