import java.util.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {

        Notebook[] myNotebook = new Notebook[100];
        ArrayList<Object> arr = CreateList();

        Set<Notebook> set = new HashSet<>();
        Set<String> s = new HashSet<String>();
        Set<Notebook> filteredSet = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            arr = CreateList();
            myNotebook[i] = new Notebook(arr.get(0).toString(), (int) arr.get(1), (int) arr.get(2), arr.get(3).toString(), arr.get(4).toString(), i, (int) arr.get(6));
            set.add(myNotebook[i]);
        }

        int intArray[] = new int[myNotebook.length];

        Scanner scanner = new Scanner(System.in);
        Map<String, String> mapfilter = new HashMap<>();
        mapfilter = DefaultMap ();
        boolean work = true;
        System.out.println("\n UnfFiltered set: \n");
        System.out.println(set);

        while (work) {

            System.out.println("Enter command to filter Set of Notebooks: \n 1 - Change Filter by memory \n 2 - Change Filter by hard drive \n 3 - Change Filter by OS \n 4 - Change Filter by color \n 5 - Show Filtered Set of Notebooks \n 6 - Filters to Default \n 7 - Show Entire Set without filters \n 8 - exit");
            System.out.println("Filters: " + mapfilter);
            String line = scanner.nextLine();

            String text = line;

            switch (text) {

                case "1":

                    for (int i = 0; i < myNotebook.length; i++) {
                        intArray[i] = myNotebook[i].getByMemory();
                    }
                    Arrays.sort(intArray);
                    System.out.println("Enter value for memory " + "From " + intArray[0] + "GB" + " to " + intArray[intArray.length - 1] + "GB");
                    mapfilter.put("memory", scanner.nextLine());
                    break;
                case "2":
                    for (int i = 0; i < myNotebook.length; i++) {
                        intArray[i] = myNotebook[i].getByHarddisk();
                    }
                    Arrays.sort(intArray);
                    System.out.println("Enter value for hard disk space " + "From " + intArray[0] + "GB" + " to " + intArray[intArray.length - 1] + "GB");
                    mapfilter.put("harddisk", scanner.nextLine());
                    break;
                case "3":
                    System.out.println("Choose OS:");
                    for (int i = 0; i < myNotebook.length; i++) {
                        s.add(myNotebook[i].getByOS());
                    }
                    System.out.println(s);
                    mapfilter.put("OS", scanner.nextLine());
                    s.clear();
                    break;
                case "4":
                    System.out.println("Choose color:");
                    for (int i = 0; i < myNotebook.length; i++) {
                        s.add(myNotebook[i].getByColor());
                    }
                    System.out.println(s);
                    mapfilter.put("color", scanner.nextLine());
                    s.clear();
                    break;
                case "5":
                    for (int i = 0; i < myNotebook.length; i++) {

                        if (myNotebook[i].getByMemory() >= Integer.valueOf(mapfilter.get("memory")) && myNotebook[i].getByHarddisk() >= Integer.valueOf(mapfilter.get("harddisk")) && myNotebook[i].getByOS().equals(mapfilter.get("OS")) && mapfilter.get("color") != null && myNotebook[i].getByColor().equals(mapfilter.get("color"))) {
                            filteredSet.add(myNotebook[i]);
                        }
                    }
                    System.out.println("\n Filtered set: \n");
                    System.out.println(filteredSet);
                    filteredSet.clear();
                    break;
                case "6":
                    filteredSet.clear();
                    mapfilter = DefaultMap ();
                    break;
                case "7":
                    System.out.println("\n UnfFiltered set: \n");
                    System.out.println(set);
                    break;
                case "8":
                    System.out.println("Exit");
                    work = false;
                    break;
            }

        }
    }

    static ArrayList<Object> CreateList() {
        ArrayList<Object> arr = new ArrayList<Object>();

        String[] strAr1 = new String[]{"Intel", "Asus", "Pentium", "MacBook", "iBook", "Irbis"};
        int[] intArray1 = new int[]{2, 4, 6, 8, 12, 16};
        int[] intArray2 = new int[]{128, 256, 512};
        String[] strAr2 = new String[]{"Windows 7", "Windows 8", "Windows 10", "MacOS"};
        String[] strAr3 = new String[]{"grey", "white", "black"};
        int price = 20000;
        int id = 200000078;
        int temp = 0;
        Random random = new Random();
        temp = random.nextInt(strAr1.length);
        arr.add(strAr1[temp]);

        temp = random.nextInt(intArray1.length);
        price = price + temp * 10000;
        arr.add(intArray1[temp]);

        temp = random.nextInt(intArray2.length);
        price = price + temp * 1000;
        arr.add(intArray2[temp]);

        temp = random.nextInt(strAr2.length);
        arr.add(strAr2[temp]);

        temp = random.nextInt(strAr3.length);
        arr.add(strAr3[temp]);
        arr.add(++id);
        arr.add(price);

        return arr;
    }

    public static HashMap<String, String> DefaultMap (){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("memory", "2");
        hashMap.put("harddisk", "128");
        hashMap.put("OS","MacOS");
        hashMap.put("color", "grey");
        return hashMap;
    }





}