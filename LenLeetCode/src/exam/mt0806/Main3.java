package exam.mt0806;

import java.util.*;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/6 11:11
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arrayUp = new int[length];
        int[] arrayDown = new int[length];
        for (int i=0; i<length; i++){
            arrayUp[i] = scanner.nextInt();
        }
        for (int i=0; i<length; i++){
            arrayDown[i] = scanner.nextInt();
        }
        System.out.println(func(arrayUp, arrayDown));
    }

    public static int func(int[] arrayUp, int[] arrayDown){
        int compare = (arrayUp.length + 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item: arrayUp){
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> sortMapList = new ArrayList<>();
        Map.Entry<Integer, Integer> maxMapItem = null;
        while (!map.isEmpty()){
            for (Map.Entry<Integer, Integer> item: map.entrySet()){
                if (maxMapItem == null){
                    maxMapItem = item;
                }else {
                    if (item.getValue()> maxMapItem.getValue()){
                        maxMapItem = item;
                    }
                }
            }
            sortMapList.add(maxMapItem);
            map.remove(maxMapItem.getKey());
            maxMapItem = null;
        }
        for (int i=0; i<arrayUp.length; i++){
            if (arrayUp[i] != arrayDown[i]){
                map.put(arrayDown[i], map.getOrDefault(arrayDown[i], 0)+1);
            }
        }
        Integer res = null;
        Integer resTemp;
        for (int i=0; i<sortMapList.size(); i++){
            int itemNum = sortMapList.get(i).getValue();
            int itemNumDown = map.get(sortMapList.get(i).getKey()) != null ? map.get(sortMapList.get(i).getKey()) : 0;
            if (itemNum>=compare){
                return 0;
            }
            if (itemNum + itemNumDown >= compare){
                resTemp = compare - itemNum;
                if (res == null){
                    res = resTemp;
                }else {
                    res = Math.min(resTemp, res);
                }
            }
        }
        return res;
    }
}
