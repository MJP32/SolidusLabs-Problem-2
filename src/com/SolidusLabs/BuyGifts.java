package com.SolidusLabs;

import java.util.*;

public class BuyGifts {

    public final static int NUMBER_ITEMS_TO_BUY = 2;
//    public final static int NUMBER_ITEMS_TO_BUY = 3;

    public static void main(String[] args) {

        if(args.length < 2){
            System.out.println("Incorrect arguments: Please provide filename and Enter gift card amount");
            System.exit(0);
        }

        List<GiftItem> menu = FileIO.readFile(args[0]);
        List<GiftItem> result;

        result = selectGifts(menu, Integer.valueOf(args[1]));
        printResults(result);
    }

    private static List<GiftItem> selectGifts(List<GiftItem> menu, int amtToSpend) {
        menu.sort((Comparator.comparing(GiftItem::getValue)).reversed());
        List<GiftItem> result = new ArrayList<>();
        selectGifts(result, menu, amtToSpend);
        return result;
    }

    private static boolean selectGifts(List<GiftItem> result, List<GiftItem> menu, int amtToSpend) {
        if(amtToSpend == 0){
            return true;
        }
        if(amtToSpend < 0){
            return false;
        }
        else{
              if(result.size() == NUMBER_ITEMS_TO_BUY)
                return true;
        }
        for (GiftItem giftItem : menu){
            if(!result.contains(giftItem)) {
                result.add(giftItem);
                if (selectGifts(result, menu, amtToSpend - giftItem.getValue())) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    private static void printResults(List<GiftItem> result) {
        if(result.size() == NUMBER_ITEMS_TO_BUY){
            System.out.println(result.toString());
        }
        else{
            System.out.println("[Not Possible]");
        }
    }
}
