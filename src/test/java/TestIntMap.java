import net.zffu.intmap.IntMap;

public class TestIntMap {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        IntMap<String> myIntMap = new IntMap<>(3000);
        System.out.println("Map Creation -> " + (System.currentTimeMillis() - start) + "ms");
        myIntMap.put(1, "myTestString");
        myIntMap.put(3, "shello");


        start = System.currentTimeMillis();
        System.out.println("Getting Value...");
        System.out.println(myIntMap.get(3));
        System.out.println("End Time -> " + (System.currentTimeMillis() - start) + "ms");
    }

}
