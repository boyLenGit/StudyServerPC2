public static int PaiLieZuHe(int m, int n){
    // 生成阶乘的数组，并化简数组内容
    ArrayList<Integer> list_fenzi = new ArrayList<>();
    for (int i1=m+1; i1<=n; i1++){
        list_fenzi.add(i1);
    }
    ArrayList<Integer> list_fenmu = new ArrayList<>();
    for (int i3=2; i3<=n-m; i3++){
        list_fenmu.add(i3);
    }
    //      删除分子与分母的重复项
    for (int i4=0; i4<list_fenzi.size(); i4++){
        if (list_fenmu.contains(list_fenzi.get(i4))){
            list_fenmu.remove(list_fenmu.indexOf(list_fenzi.get(i4)));
            list_fenzi.remove(i4);
            i4--;
        }
    }
    //      单个数组化简，如'[42]与[2]'化简为'[24]与[null]'
    for (int i4=0; i4<list_fenmu.size(); i4++){
        for (int i5=0; i5<list_fenzi.size(); i5++){
            if (list_fenzi.get(i5)%list_fenmu.get(i4)==0){
                list_fenzi.set(i5, list_fenzi.get(i5)/list_fenmu.get(i4));
                list_fenmu.remove(i4);
                i4--;
                break;
            }
        }
    }
    // 开始计算阶乘
    long result = 1;
    for (Integer value : list_fenzi) {
        result = result * value;
    }
    for (Integer integer : list_fenmu) {
        result = result / integer;
    }
    return (int) result;
}