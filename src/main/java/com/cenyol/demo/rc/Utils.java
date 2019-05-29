package com.cenyol.demo.rc;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Chenhanqun mail: chenhanqun1@corp.netease.com
 * @date 2019-05-27 17:30
 */
public class Utils {

    /**
     * Question1, sort by firstName + lastName + ext,
     * if firstName is the same then sort by lastName and
     * ext, please note lastName and ext can be empty
     * string or null.
     *
     **/
    public static List<Extension> sortByName(List<Extension> extensions) {
        return extensions.stream()
                .sorted(
                    Comparator.comparing(Extension::getFirstName)
                        .thenComparing(Extension::comparatorForLastName)
                        .thenComparing(Extension::comparatorForExt)
                )
                .collect(Collectors.toList());
    }

    /**
     * Question2, sort extType, extType is a string and can
     * be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     *
     **/
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        return extensions.stream()
                .sorted(
                    Comparator.comparing(Extension::comparatorForExtType)
                ).collect(Collectors.toList());
    }

    /**
     * Question3, sum all sales items by quarter
     *
     **/
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
        List<QuarterSalesItem> quarterSalesItemList = new ArrayList<>();

        saleItems.stream()
                .collect(
                    Collectors.groupingBy(
                        SaleItem::getQuarter,
                        Collectors.summarizingDouble(SaleItem::getSaleNumbers)
                    )
                ).forEach( (quarter, total) ->
                    quarterSalesItemList.add(new QuarterSalesItem(quarter, total.getSum()))
                );
        return quarterSalesItemList;
    }

    /**
     * Question4, max all sales items by quarter
     *
     **/
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        List<QuarterSalesItem> quarterSalesItemList = sumByQuarter(saleItems);
        quarterSalesItemList.sort(Comparator.comparing(QuarterSalesItem::getTotal).reversed());
        return quarterSalesItemList;
    }

    /**
     * We have all Keys: 0-9;
     * usedKeys is an array to store all used keys like :
     * [2,3,4];
     * We want to get all unused keys, in this example it
     * would be: [0,1,5,6,7,8,9,]
     */
    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        if (usedKeys.length == 0) {
            return allKeys;
        }

        Map<Integer, Integer> usedKeysMap = new HashMap<>();
        for (int i: usedKeys) {                                     // O(n)
            usedKeysMap.put(i, i);
        }

        List<Integer> unusedKeyList = new LinkedList<>();
        for (int i: allKeys) {                                      // O(n)
            if (!usedKeysMap.containsKey(i)) {                      // O(1)
                unusedKeyList.add(i);
            }
        }

        int j = 0;
        int[] a = new int[unusedKeyList.size()];
        for(int key : unusedKeyList) {
            a[j] = key;
            j++;
        }

        return a;
    }
}
