package com.cenyol.demo.rc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Chenhanqun mail: chenhanqun1@corp.netease.com
 * @date 2019-05-27 17:34
 */
public class UtilsTest {

    private List<Extension> extensions;

    private List<SaleItem> saleItems;

    @Before
    public void before() {
        extensions = Arrays.asList(
                Extension.getInstanceWithExt("Kobe", "Braynt", "jpg", ExtTypeEnum.User.string()),
                Extension.getInstanceWithExt("Taylor", "Swift", "mp4", ExtTypeEnum.TMO.string()),
                Extension.getInstanceWithExt("Will", "Smith", "flv", ExtTypeEnum.Other.string()),
                Extension.getInstanceWithExt("Taylor", "Braynt", "react", ExtTypeEnum.Dept.string()),
                Extension.getInstanceWithExt("Taylor", "Braynt", "java", ExtTypeEnum.AO.string()),
                Extension.getInstance("Kobe", "Braynt"),
                Extension.getInstance("Taylor", "Swift"),
                Extension.getInstance("Will", "Smith"),
                Extension.getInstanceWithExt("Taylor", "Braynt", "react", ExtTypeEnum.User.string()),
                Extension.getInstance("Taylor", "Braynt")
        );


        saleItems = Arrays.asList(
                new SaleItem(1, new Date(), "", 25.67),
                new SaleItem(3, new Date(), "", 25.67),
                new SaleItem(11, new Date(), "", 25.67),
                new SaleItem(5, new Date(), "", 25.67),
                new SaleItem(6, new Date(), "", 25.67),
                new SaleItem(7, new Date(), "", 25.67),
                new SaleItem(8, new Date(), "", 25.67),
                new SaleItem(9, new Date(), "", 25.67),
                new SaleItem(12, new Date(), "", 25.67)
        );
    }

    @Test
    public void testSortByName() {
        List<Extension> newExtensions = Utils.sortByName(extensions);

        Assert.assertNotNull(newExtensions);
        Assert.assertEquals(extensions.size(), newExtensions.size());
        Assert.assertEquals("Kobe", newExtensions.get(0).getFirstName());
        Assert.assertEquals("Will", newExtensions.get(8).getFirstName());
        Assert.assertEquals("Braynt", newExtensions.get(1).getLastName());
        Assert.assertEquals("java", newExtensions.get(2).getExt());
    }

    @Test
    public void testSortByExtType() {
        List<Extension> newExtensions = Utils.sortByExtType(extensions);

        Assert.assertNotNull(newExtensions);
        Assert.assertEquals(extensions.size(), newExtensions.size());
        Assert.assertEquals(ExtTypeEnum.Dept.string(), newExtensions.get(2).getExtType());
    }


    @Test
    public void testSumByQuarter() {
        List<QuarterSalesItem> quarterSalesItemList = Utils.sumByQuarter(saleItems);

        Assert.assertNotNull(quarterSalesItemList);
        Assert.assertEquals(4, quarterSalesItemList.size());
        Assert.assertEquals(77.01, quarterSalesItemList.get(2).getTotal(), 0);
        Assert.assertEquals(3, quarterSalesItemList.get(2).getQuarter());
    }

    @Test
    public void testMaxByQuarter() {
        List<QuarterSalesItem> quarterSalesItemList = Utils.maxByQuarter(saleItems);

        Assert.assertNotNull(quarterSalesItemList);
        Assert.assertEquals(4, quarterSalesItemList.size());
        Assert.assertEquals(77.01, quarterSalesItemList.get(2).getTotal(), 0);
        Assert.assertEquals(3, quarterSalesItemList.get(2).getQuarter());
    }

    @Test
    public void testGetUnUsedKeys() {
        int count = 100000000;
        int[] allKeys = new int[count];
        for (int i = 0; i < count; i++) {
            allKeys[i] = i;
        }
        int[] usedKeys = {2,4};
        int[] a = Utils.getUnUsedKeys(allKeys, usedKeys);
        Assert.assertNotNull(a);
        Assert.assertEquals(count-2, a.length);
    }
}
