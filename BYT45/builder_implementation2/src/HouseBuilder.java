public class HouseBuilder {

    private String city;
    private String district;
    private String address;

    private int buildingYear;
    private int numberOfRooms;
    private int numberOfBathrooms;

    private boolean isDuplex;
    private boolean hasCarPark;
    private boolean hasPool;
    private boolean hasGarden;

    public HouseBuilder(String city ,String district,String address,int buildingYear){ //obligatory fields
        this.city=city;
        this.district=district;
        this.address=address;
        this.buildingYear=buildingYear;
    }


    public House build(){
        House house = new House();
        house.setCity(city);
        house.setDistrict(district);
        house.setAddress(address);
        house.setBuildingYear(buildingYear);
        house.setNumberOfRooms(numberOfRooms);
        house.setNumberOfBathrooms(numberOfBathrooms);

        house.setDuplex(isDuplex);
        house.setHasCarPark(hasCarPark);
        house.setHasPool(hasPool);
        house.setHasGarden(hasGarden);
        return house;

    }


    public HouseBuilder setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        return this;
    }

    public HouseBuilder setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
        return this;
    }

    public HouseBuilder setDuplex(boolean duplex) {
        isDuplex = duplex;
        return this;
    }

    public HouseBuilder setHasCarPark(boolean hasCarPark) {
        this.hasCarPark = hasCarPark;
        return this;
    }

    public HouseBuilder setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
        return this;
    }

    public HouseBuilder setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
        return this;
    }



}
