import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberCastletter {
    public static void main(String[] args) {
        try{
            List<Integer> arr = new ArrayList<Integer>() ;
            if( arr.size() < 1 ){
                System.out.println("---Please enter a number from 0 to 99---");
                Scanner sn = new Scanner(System.in);
                int x = sn.nextInt();
                System.out.println("---Convert to letter (Y / N)---");
                String next = sn.next();
                if( "Y".equals(next.toUpperCase()) ){
                    arr.add(x);
                    count(arr);
                }else if( "N".equals(next.toUpperCase()) ){
                    System.out.println("---Please continue to enter numbers from 0 to 99---");
                    int y = sn.nextInt();
					arr.add(x);
                    arr.add(y);
                    count(arr);
                }else{
                    System.out.println("---Please enter Y or N---");
                    main(args);
                }
            }
        }catch (Exception e){
            System.out.println("---Input error, please restart---");
            main(args);
        
        }
    }

    private static void count(List<Integer> arr){
		System.out.println(arr);
        if( arr.size() < 1 ){
            System.err.println("");
            return;

        }

        if( arr.size() > 2 ){
            System.err.println("");
            return;
        }

        List<String> result = new ArrayList<String>();
        List<List<String>> list = new ArrayList<List<String>>();

        for (int i = 0; i < arr.size(); i++) {
            int number = arr.get(i);
            List<String> numberCastResult = castLetter(number);

            if( numberCastResult.size() < 1 ){
                continue;
            }

            list.add(numberCastResult);
        }
        result = cast(list);
        System.err.println(result);
    }

    private static List<String> castLetter(int number){
        if( number == 10 || number < 2 ){
            return new ArrayList<String>();
        }

        if( number < 10 ){
            return getLetter(number);
        }

        String numberStr = number + "";
        int index1 = Integer.parseInt(numberStr.substring(0,1));
        int index2 = Integer.parseInt(numberStr.substring(1));
        List<List<String>> list = new ArrayList<List<String>>();

        List<String> indexList1 = getLetter(index1);
        if( indexList1.size() > 0 ){
            list.add(indexList1);
        }

        List<String> indexList2 = getLetter(index2);
        if( indexList2.size() > 0 ){
            list.add(indexList2);
        }

        return cast(list);
    }

    private static List<String> cast(List<List<String>> list){
        if( list.size() < 1 ){
            return new ArrayList<String>();
        }

        if( list.size() < 2 ){
            return list.get(0);
        }

        List<String> result = new ArrayList<String>();

        List<String> list1 = list.get(0);
        List<String> list2 = list.get(1);

        for (int i = 0; i <list1.size(); i++) {
            String numberStr1 = list1.get(i);
            for (int j = 0; j < list2.size(); j++) {
                String numberStr2 = list2.get(j);
                result.add(numberStr1+numberStr2);
            }
        }

        return result;
    }

    private static List<String> getLetter(int number){
        List<String> list = new ArrayList<String>();

        switch (number){
            case 2:
                list.add("a");
                list.add("b");
                list.add("c");
                return list;

            case 3:
                list.add("d");
                list.add("e");
                list.add("f");
                return list;

            case 4:
                list.add("g");
                list.add("h");
                list.add("i");
                return list;

            case 5:
                list.add("j");
                list.add("k");
                list.add("l");
                return list;

            case 6:
                list.add("m");
                list.add("n");
                list.add("o");
                return list;

            case 7:
                list.add("p");
                list.add("q");
                list.add("r");
                list.add("s");
                return list;

            case 8:
                list.add("t");
                list.add("u");
                list.add("v");
                return list;

            case 9:
                list.add("w");
                list.add("s");
                list.add("y");
                list.add("z");
                return list;
        }

        return list;
    }
}