import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //统计每个单词出现次数，map
        HashMap<String,Integer>hash=new HashMap<>();
        for(String str:words){
            if(!hash.containsKey(str)){
                hash.put(str,1);
            }
            else{
                int val=hash.get(str);
                hash.put(str,val+1);
            }
        }
        //建立小根堆
        PriorityQueue<Map.Entry<String,Integer>>queue=new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue())==0){
                    //值相同时以大堆排列
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue()-o2.getValue();
            }
        });
        //根据map进小根堆
        for(Map.Entry<String,Integer> pos:hash.entrySet()){
            if(queue.size()<k){
                queue.offer(pos);
            }
            else {
                Map.Entry<String, Integer> top = queue.peek();
                if (top.getValue().equals(pos.getValue())) {
                    //按照字典序排列
                    if (top.getKey().compareTo(pos.getKey())>0){
                        queue.poll();
                        queue.offer(pos);
                    }
                }
                else{
                    if(top.getValue()<pos.getValue()){
                        queue.poll();
                        queue.offer(pos);
                    }
                }
            }
        }
        List<String>ret=new ArrayList<>();
        while(!queue.isEmpty()){
            Map.Entry<String,Integer>top=queue.poll();
            ret.add(top.getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
}

public class Practice {
    //练习map set的使用
    public static Map<String,Integer> CoutNum(int[]array){
        Map<String,Integer>map=new HashMap<>();
        for (int j : array) {
            if (map.containsKey(Integer.toString(j))) {
                int val = map.get(Integer.toString(j));
                map.put(Integer.toString(j), val + 1);
            } else {
                map.put(Integer.toString(j), 1);
            }
        }
        return map;
    }
    public static Set<Integer> filter(int[]array){
        Set<Integer>ret=new HashSet<>();
        for (int j : array) {
            ret.add(j);
        }
        return ret;
    }

    public static void main(String[] args) {
        String[]array=new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(new Solution().topKFrequent(array, 4));
    }

    public static void main2(String[] args) {
        //统计数字出现的次数
        int[]array=new int[10000];
        Random random=new Random();
        for(int i=0;i<array.length;i++){
            array[i]=random.nextInt(1000);
        }
        Map<String,Integer>map=CoutNum(array);
        System.out.println(map);
        //数据去重
        System.out.println(filter(array));
    }
    public static void main1(String[] args) {
        Map<String,Integer>map=new HashMap<>();
        map.put("app",3);//哈希表
        System.out.println(map);
        System.out.println(map.get("app"));
        map.put("def",5);
        map.put("awa",0);
        System.out.println(map.getOrDefault("def", 56));
        Set<String> set=map.keySet();
        System.out.println(set);
        Set<Map.Entry<String,Integer>> set1=map.entrySet();
        for(Map.Entry<String,Integer> e:set1){
            System.out.print(e+" ");
        }
        System.out.println();
        //迭代器
        Iterator<Map.Entry<String,Integer>> pos=map.entrySet().iterator();
        while(pos.hasNext()){
            Map.Entry<String,Integer>keyPos=pos.next();
            System.out.println(keyPos.getKey());
            System.out.println(keyPos.getValue());
            System.out.println("============");
        }
    }
}
