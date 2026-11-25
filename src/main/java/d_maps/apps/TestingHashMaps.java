package d_maps.apps;

import c_generics.utils.GenericDynamicArray;
import c_generics.utils.GenericLinkedList;
import d_maps.utils.HashMap;

public class TestingHashMaps {
    static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            map.put(i, "String " + i);
        }

        System.out.println("Display map contents:");
        GenericDynamicArray<Integer> keys = map.getKeys();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println("Key: " + i + ", Value = " + map.get(keys.get(i)));
        }
    }
}
