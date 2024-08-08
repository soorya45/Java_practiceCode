import java.util.concurrent.Semaphore;

class Airport {
    private Semaphore runwaySemaphore;

    public Airport(int runwayCount) {
        runwaySemaphore = new Semaphore(runwayCount, true);
    }

    public void requestTakeoff(String airplaneName) {
        try {
            System.out.println(airplaneName + " is requesting permission to take off.");
            runwaySemaphore.acquire();
            System.out.println(airplaneName + " has been granted permission to take off and is using the runway.");
            Thread.sleep(2000);
            System.out.println(airplaneName + " has successfully taken off.");
            runwaySemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void requestLanding(String airplaneName) {
        try {
            System.out.println(airplaneName + " is requesting permission to land.");
            runwaySemaphore.acquire();
            System.out.println(airplaneName + " has been granted permission to land and is using the runway.");
            Thread.sleep(2000); 
            System.out.println(airplaneName + " has successfully landed.");
            runwaySemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Airplane extends Thread {
    private String name;
    private Airport airport;

    public Airplane(String name, Airport airport) {
        this.name = name;
        this.airport = airport;
    }

    @Override
    public void run() {
        
        airport.requestTakeoff(name);

        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        airport.requestLanding(name);
    }
}

public class Test8_2 {
    public static void main(String[] args) {
        Airport airport = new Airport(2); // 2 runways available

        Airplane airplane1 = new Airplane("Flight 1", airport);
        Airplane airplane2 = new Airplane("Flight 2", airport);

        airplane1.start();
        airplane2.start();
    }
}
