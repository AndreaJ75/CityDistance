package JAVAProj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class City {
    private String name;
    private double latitude;
    private double longitude;


    public City(String cityName, double cityLatitude, double cityLongitude) {
        this.name = cityName;
        this.latitude = cityLatitude;
        this.longitude = cityLongitude;
    }

    public String getCityName() {
        return name;
    }

    public void setCityName(String cityName) {
        this.name = cityName;
    }

    public double getCityLatitude() {
        return latitude;
    }

    public void setCityLatitude(double cityLatitude) {
        this.latitude = cityLatitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return name + " " + longitude + " " + latitude ;
    }

    @Override
    public boolean equals(Object c) {
        if (c == null || !(c instanceof City)) {
            return false;
        }
        City c1 = (City) c;
        return (name.equals(c1.name) &&
                longitude == c1.longitude &&
                latitude == c1.latitude);
    }
// Distance en Km _ Latitude et longitude en radian
    public double getDistanceFrom(double lat1, double lon1){

        //City c1 = new City(name, latitude, longitude);
        int R = 6371 ; // Radius of the earth in km
        double dLat = deg2rad(latitude-lat1);
        double dLong = deg2rad(longitude -lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(latitude)) *
                        Math.sin(dLong/2) * Math.sin(dLong/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c; // distance in km
        return d;
    }

    public double deg2rad(double deg){

        return deg*(Math.PI/180);
    }

    public double getDistanceFrom(City ci) {
        return getDistanceFrom(ci.latitude, ci.longitude);
    }

    // JAVADOC Optional (type paramétré : Méthode qui va s'appliquer sur City pour s'assurer
    // qu'on obtient un objet en retour (si objet contient ou non 1 city => on retournerait
    // Optional<City> (et non City) => voir si on veut ou non retourner 1 exception aux users

        public City getNearestCity(Collection<City> cityColl) {
            City res = null;
            double distMin = Double.POSITIVE_INFINITY;
            for (City c : cityColl) {
                double d = this.getDistanceFrom(c);
                if ((d < distMin) && !this.equals(c)) {
                    res = c;
                    distMin = d;
                }
            }
            return res;
//
//        if (cityColl.isEmpty()){
//            return null;
//        }
//
//        double distMin = cityColl.get(0).getDistanceFrom(this);
//            City nearestCity = cityColl.get(0);
//
//            int i=1;
//            do {
//                double dist = cityColl.get(i).getDistanceFrom(c1);
//                if (dist < distMin) {
//                    distMin = dist;
//                    nearestCity = cityColl.get(i);
//                    //System.out.println("Nearest city : " + nearestCity);
//                    //System.out.println("Distance nearest : " + distMin);
//                }
//                    i = i+1;
//            } while(i< cityColl.size());
//
//            return nearestCity;
//        }
        }

        public static List<City> inRadius(double radius, double latitude, double longitude
        , Collection<City> cities){
            List<City> res = new ArrayList<>();
            for(City c : cities) {
                if (c.getDistanceFrom(latitude, longitude) <= radius) {
                    res.add(c);
                }
            }
            return res;
        }

    public boolean isIncludedInArea(double lati, double longi, double radius) {


        double dist = this.getDistanceFrom(lati, longi);
        boolean res;
        if (dist < radius) {
            res = true ;
        } else {
            res = false;
        } return res;
    }

//    public static List<City> inRadius(double radius, double [] points,
//                                      Collection<City> cities) {
//
//    }
//    public City getNearestCity(ArrayList<City> cityColl) {
//
//        City c1 = new City(cityName, cityLatitude, cityLongitude);
//        Double dist = new Double(0);
//        HashMap<Double, City> cityDistCol = new HashMap<Double, City>();
//
//        try {
//            int i=0 ;
//            do {
//                dist = cityColl.get(i).getDistanceFrom(c1);
//                cityDistCol.put(dist,cityColl.get(i));
//                System.out.println("coll = " + "  " +
//                        cityDistCol.get(dist) + " distance : " +
//                        dist);
//                i = i + 1;
//            }
//            while (i < cityColl.size());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // A partir du hasMap => Trier celle-ci pour fournir
//        // la ville la plus proche
//        return cityDistCol.sortNearest();
//    }
//
//    public City sortNearest(HashMap<Double, City>) {
//
//        City c1 = new City(cityName, cityLatitude, cityLongitude);
//
//        //HashMap<Double, City> cityDistCol = new HashMap<Double, City>();
//
//
//        }
}
