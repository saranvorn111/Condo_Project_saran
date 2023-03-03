import java.util.Scanner;
public class Main {
    //function
    public static void pressAnyKey(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to continue..!");
        input.nextLine();
    }
    public static void main(String[] args) {
        //About condo
        Scanner input = new Scanner(System.in);

        int floor, room = 0;
        String[][] condo = new String[0][];
        int option=0;
        boolean isFloorvalid= false , isRoomvalid= false;
        //set up
        do {
            System.out.println("===============|Set up Condo|===============");
            System.out.print("input number of floor: ");
            floor = input.nextInt();
            if (floor > 0) {
                isFloorvalid = true;
                System.out.print("input number of room: ");
                room = input.nextInt();
                if (room > 0) {
                    //condo allocated
                    isRoomvalid = true;
                    condo = new String[floor][room];
                    System.out.println("-------------------------------------");
                    System.out.println("your are already SetUp your Condo... ");
                    System.out.println("-------------------------------------");
                    System.out.println("Floor " + floor + " floors");
                    System.out.println("Room " + room + " rooms");
                    System.out.println("Total room = " + (floor * room) + " rooms");

                }
            }
            pressAnyKey();
        }while(!isFloorvalid || !isRoomvalid);
        do {
            System.out.println("=================|Welcome to my Condo|==============");

            System.out.println("1. Buy Condo");
            System.out.println("2. Sell Condo");
            System.out.println("3. Search Condo");
            System.out.println("4. Show Condo");
            System.out.println("5. Exit");
            System.out.println("Choose option form 1 - > 5: ");
            System.out.println("---------------------------");
            option = input.nextInt();
            switch(option){
                case 1:
                    int desiredRoom;
                    int desiredFloor;
                    String ownerName;
                    int buyOption;
                    //reSetvalue
                    isFloorvalid = false;
                    isRoomvalid=false;
                    boolean isConValid = false;
                    do {
                        System.out.println("-----------------<< Buy condo >>-----------------");
                        System.out.print("Input the DesiredFloor: ");
                        desiredFloor = input.nextInt();
                        if (desiredFloor > 0 && desiredFloor <= floor) {
                            isFloorvalid=true;
                            System.out.print("Input the DesiredRoom: ");
                            desiredRoom = input.nextInt();
                            if (desiredRoom > 0 && desiredRoom <= room) {
                                isRoomvalid=true;
                                if (condo[desiredFloor - 1][desiredRoom - 1] == null) {
                                    isConValid = true;
                                    System.out.print("Input OwnerName: ");
                                    input.nextLine();
                                    ownerName = input.nextLine();
                                    //add owner in to condo
                                    condo[desiredFloor - 1][desiredRoom - 1] = ownerName;
                                    System.out.println("You have got you room... ");
                                } else {
                                    System.out.println(" The room is have owner ");

                                }
                            }else{
                                System.out.println("Error: Room number is invalid");
                            }
                        }else{
                            System.out.println("Error: Floor number is invalid");
                            isFloorvalid=false;
                        }
                        if(!isRoomvalid || !isFloorvalid){
                            System.out.println("----------------------------------------");
                            System.out.println("press 1 to exit and press 2 to continue!");
                            System.out.println("Choose your Option");
                            buyOption = input.nextInt();
                            if(buyOption==1){
                                isConValid=true;
                            }
                        }
                    }while(!isConValid);
                    break;
                case 2:
                    isFloorvalid = false;
                    isRoomvalid=false;
                    boolean isCondoValid = false;
                    System.out.println("------------------<< Sell Condo >>------------------");
                    System.out.print("Input desired Floor: ");
                    desiredFloor = input.nextInt();
                    if (desiredFloor > 0 && desiredFloor <= floor) {
                        isFloorvalid = true;
                        System.out.print("Input desired Room: ");
                        desiredRoom = input.nextInt();
                        if (desiredRoom > 0 && desiredRoom <= room) {
                            isRoomvalid = true;
                            if (condo[desiredFloor - 1][desiredRoom - 1] != null) {
                                isCondoValid = true;
                                System.out.println("Input Owner name of Condo:");
                                //cler
                                input.nextLine();
                                ownerName = input.nextLine();
                                if (ownerName.equalsIgnoreCase(condo[desiredFloor - 1][desiredRoom - 1])) {
                                    condo[desiredFloor - 1][desiredRoom - 1] = ownerName;
                                    System.out.println("Floor : "+ desiredFloor +" Room : "+desiredRoom+" Belong to: "+ ownerName);
                                    System.out.println("----------------------------------------");
                                    System.out.println("press 1 to confrim and press 0 to concel!");
                                    System.out.println("Choose your Option");
                                    buyOption = input.nextInt();
                                    if(buyOption==1){
                                        System.out.println("You Can sell your condo..!");
                                        condo[desiredFloor - 1][desiredRoom - 1] = null;
                                        System.out.println("You are success to sold your condo!.. ");
                                    }else{
                                        System.out.println("You do not want to sell it....!  ");
                                        isCondoValid=false;
                                    }

                                } else {
                                    System.out.println(" Can't sell it ...!");
                                }
                            }else{
                                System.out.println("You are not owner this condo..!  ");
                            }
                        } else {
                            System.out.println("Error !!  Room is invalid..! ");
                        }
                    } else {
                        System.out.println("Error !! Floor is invalid..!");
                    }
                    break;
                case 3:
                    int searchOp;
                    do {
                        System.out.println("------------------<< Search Condo >>------------------");
                        System.out.println("1. Search by Owner's Name ");
                        System.out.println("2. Search by Floor");
                        System.out.println("3.Exit.! ");
                        System.out.println("Choose your search Option by 1 - 3: ");
                        searchOp=input.nextInt();
                        switch(searchOp){
                            case 1:
                                String owerNameSearch;
                                System.out.println("--------------<<Search by Owner's name >>--------------");
                                System.out.println("Input the Owner's name for Search : ");
                                input.nextLine();
                                boolean b =false;
                                owerNameSearch = input.nextLine();
                                for(int i=0;i<condo.length;i++){
//                                    System.out.print("Floor "+(i+1)+" : ");
                                    for(int j=0;j<condo[i].length;j++){
//                                        System.out.print("\t"+condo[i][j]);
                                        if(owerNameSearch.equalsIgnoreCase(condo[i][j])){
                                            System.out.println("Owner name: "+ owerNameSearch +"Floor : "+ (i+1) +"Room :"+ (j+1));
                                            b=true;
                                        }
                                    }
                                    System.out.println();
                                }
                                if (!b){
                                    System.out.println("Search not found ...!");
                                }
                                break;
                            case 2:
                                int searchFloor;
                                System.out.println("---------------<< Search by Floor >>---------------");
                                System.out.println("Input the Floor to search: ");
                                searchFloor = input.nextInt();
                                if(searchFloor>0 && searchFloor<=floor){
                                    //print colum based on inputed Row (floor)
                                    System.out.println("Floor "+searchFloor+" : ");
                                    for(int i=0;i<condo[searchFloor-1].length;i++){
                                        System.out.println("\t"+condo[searchFloor-1][i]);
                                    }
                                    System.out.println();
                                }
                                else{
                                    System.out.println("Error: Search with floor (you need to choose form (1 to "+floor+") : ");
                                }
                                break;
                        }
                    }while(searchOp!=3);
                    break;
                case 4:
                    System.out.println("----------------<< Show Condo >>----------------");
                    for(int i=condo.length-1;i>=0;i--){
                        System.out.print("Floor "+(i+1)+" : ");
                        for(int j=0;j<condo[i].length;j++){
                            System.out.print("\t"+condo[i][j]);
                        }
                        System.out.println();
                    }
                    break;
            }
            pressAnyKey();
        }while(option!=5);
    }
}
