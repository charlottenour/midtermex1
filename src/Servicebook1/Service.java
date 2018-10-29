package Servicebook1;

import java.time.Year;
import java.util.Objects;

public class Service {
    private int mileage;
    private Date date;

    public Service(int mileage, Date date) {
        this.mileage = mileage;
        this.date = date;
    }


    public int getMileage() {
        return mileage;
    }

    public Date getDate() {
        return date;
    }

    public boolean isOlder(Service service) {
        if (date.getYear() > service.getDate().getYear()) {
            return false;
        }
        if (date.getMonth() > service.getDate().getMonth()) {
            return false;
        }
        if (date.getDay() > service.getDate().getDay()) {
            return false;
        }
        else
                    return true;
    }




        @Override
        public String toString () {
            return "Service{" +
                    "mileage=" + mileage +
                    ", date=" + date +
                    '}';
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return mileage == service.mileage &&
                Objects.equals(date, service.date);
    }


}
