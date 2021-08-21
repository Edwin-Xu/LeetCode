package basic_algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author taoxu.xu
 * @date 8/20/2021 6:21 PM
 */

public class LruLinkedHashMap<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public LruLinkedHashMap(int initialCapacity, float loadFactor) {
        // 采用插入顺序
        super(initialCapacity, loadFactor, false);
        this.capacity = initialCapacity;
    }

    public LruLinkedHashMap(int initialCapacity) {
        super(initialCapacity);
        this.capacity = initialCapacity;
    }

    public V getValue(K key){
        final V v = super.get(key);
        if (v == null){
            return null;
        }
        // 这里accessOrder采用false，即按插入排序，访问后顺序不影响
        // 如果采用true则是按访问排序，不公再手动移动到最后
        super.remove(key);
        super.put(key, v);
        return v;
    }

    @Override
    public V put(K key, V value) {
        // get一次，如果不存在后面会插入不影响，如果存在的的话会移动到尾部
        getValue(key);
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }


    public int getSize() {
        return super.size();
    }

    public void cat(){
        forEach((k, v) -> System.out.println(k+ " = "+v));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input capacity:");
        int cap = Integer.parseInt(sc.nextLine());

        final LruLinkedHashMap<Integer, Integer> lru=
                new LruLinkedHashMap<Integer, Integer>(cap, 1.0f);

        String inp;
        while (!(inp = sc.nextLine().trim()).equals("q")){
            if (inp.startsWith("get")){
                try {
                    System.out.println(lru.getValue(Integer.parseInt(inp.substring(3).trim())));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }else if (inp.startsWith("put")){
                final String[] split = inp.split(" +");
                for (int i = 1; i < split.length; i+=2) {
                    try {
                        lru.put(Integer.parseInt(split[i]), Integer.parseInt(split[i+1]));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }else if (inp.equals("size")){
                System.out.println(lru.getSize());
            }else if (inp.equals("cat")){
                lru.cat();
            }
        }
    }
}
