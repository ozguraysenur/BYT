public class RealEstateAgent {
    public static void main(String[] args) {

        House house1 =new HouseBuilder("Istanbul","Bahcelievler","adres1",2010)
                .setNumberOfBathrooms(2)
                .setNumberOfRooms(3)
                .setHasGarden(true)
                .build();
        House house2 =new HouseBuilder("Ankara","Beypazari","adres2",2015)
                .setNumberOfBathrooms(1)
                .setNumberOfRooms(2)
                .setHasCarPark(true)
                .build();
        House house3 =new HouseBuilder("Mugla","Bodrum","adres3",2018)
                .setNumberOfBathrooms(3)
                .setNumberOfRooms(5)
                .setHasCarPark(true)
                .setDuplex(true)
                .setHasPool(true)
                .setHasGarden(true)
                .build();


        printHouse(house1);
        printHouse(house2);
        printHouse(house3);

    }
    private static void printHouse(House house){

        System.out.println("house has been added to the list " + house+"\n");
    }
}


//prints:
//   house has been added to the list House{city='Istanbul', district='Bahcelievler', address='adres1', buildingYear=2010, numberOfRooms=3, numberOfBathrooms=2, isDuplex=false, hasCarPark=false, hasPool=false, hasGarden=true}
//
//   house has been added to the list House{city='Ankara', district='Beypazari', address='adres2', buildingYear=2015, numberOfRooms=2, numberOfBathrooms=1, isDuplex=false, hasCarPark=true, hasPool=false, hasGarden=false}
//
//   house has been added to the list House{city='Mugla', district='Bodrum', address='adres3', buildingYear=2018, numberOfRooms=5, numberOfBathrooms=3, isDuplex=true, hasCarPark=true, hasPool=true, hasGarden=true}
