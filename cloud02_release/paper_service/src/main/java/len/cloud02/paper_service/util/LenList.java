package len.cloud02.paper_service.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LenList {

    public static List<Long> string2list(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] array_by_split = ids.split(",");
            for (int i=0; i < array_by_split.length;i++) {
                list.add(new Long(array_by_split[i]));
            }
        }
        return list;
    }

    public static List<Long> string2list(String ids, String split) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] array_by_split = ids.split(split);
            for (int i=0; i < array_by_split.length;i++) {
                list.add(new Long(array_by_split[i]));
            }
        }
        return list;
    }

    public static List<String> shellToList1V(String shell){
        List<String> ilist0 = new ArrayList<String>(Arrays.asList(shell.split("\r\n")));
        List<String> ilist = new ArrayList<String>();
        for(String item1:ilist0){
            ilist.addAll(new ArrayList<String>(Arrays.asList(item1.split(" "))));
        }
        List<String> result = new ArrayList<String>();
        for(String s:ilist){
            if(s.equals("")){
                continue;
            }
            result.add(s.replace("\r\n", "").replace("\n", ""));
        }
        return result;
    }

    public static List<List<String>> shellToList2V(String shell){
        //List<String> ilist0 = new ArrayList<String>(Arrays.asList(shell.split("\n")));
        List<String> ilist0 = new ArrayList<String>(Arrays.asList(shell.split("\r\n")));
        List<List<String>> ilist1 = new ArrayList<>();
        for(int cnt=0; cnt<ilist0.size();cnt++){
            ilist1.add(cnt, new ArrayList<String>(Arrays.asList(ilist0.get(cnt).split(" "))));
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> list1 :ilist1){
            List<String> result_temp = new ArrayList<>();
            for(String s:list1){
                if(s.equals("")){
                    continue;
                }
                result_temp.add(s.replace("\n", ""));
            }
            result.add(result_temp);
        }
        return result;
    }

    public static List<String> stringList2vTo1v(List<List<String>> ilist){
        List<String> result = new ArrayList<String>();
        for(List<String> item1: ilist){
            result.addAll(item1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(string2list("11,33,44"));
    }
}
