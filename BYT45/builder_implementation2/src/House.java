public class House {

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

    public House() {
    }

    public House(String city, String district, String address, int buildingYear, int numberOfRooms, int numberOfBathrooms, boolean isDuplex, boolean hasCarPark, boolean hasPool, boolean hasGarden) {
        this.city = city;
        this.district = district;
        this.address = address;
        this.buildingYear = buildingYear;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.isDuplex = isDuplex;
        this.hasCarPark = hasCarPark;
        this.hasPool = hasPool;
        this.hasGarden = hasGarden;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(int buildingYear) {
        this.buildingYear = buildingYear;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public boolean isDuplex() {
        return isDuplex;
    }

    public void setDuplex(boolean duplex) {
        isDuplex = duplex;
    }

    public boolean isHasCarPark() {
        return hasCarPark;
    }

    public void setHasCarPark(boolean hasCarPark) {
        this.hasCarPark = hasCarPark;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    @Override
    public String toString() {
        return "House{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", buildingYear=" + buildingYear +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", isDuplex=" + isDuplex +
                ", hasCarPark=" + hasCarPark +
                ", hasPool=" + hasPool +
                ", hasGarden=" + hasGarden +
                '}';
    }
}
