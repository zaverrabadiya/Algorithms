package com.zavrab.adhoc;

import javax.swing.text.html.MinimalHTMLWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Main m = new Main();
        int total = m.getTotal();
        System.out.print(total);
    }

    private int getTotal() {
        IAccount account = new Account();

        return account.getTotalI("MSFT");
    }

    
    interface IAccount {
        int getTotalI(String type);
    }

    class Account implements IAccount {

        HashMap<String, Category> list;

        public Account() {
            list = new HashMap<String, Category>();
            //list.put("Bank", new Stocks());
            list.put("Retirement", new Retirement());
        }

        @Override
        public int getTotalI(String type) {
            if (list.containsKey(type)) {
                return list.get(type).getTotalOfAll(list.get(type)).total;
            }

            for (Map.Entry<String, Category> key : list.entrySet()) {
                Result result = key.getValue().getTotal(type);

                if (result != null) {
                    return result.total;
                }
            }

            return 0;
        }
    }

    abstract class Category implements IAccount {
        protected abstract HashMap<String, Category> getYourList();

        public int getTotalI(String type) {
            getTotal(type);
        }

        protected Result getTotal(String type) {
            HashMap<String, Category> categoryHashMap = getYourList();

            if (categoryHashMap.containsKey(type)) {
                return getTotalOfAll(categoryHashMap.get(type));
            }

            for (Map.Entry<String, Category> key : categoryHashMap.entrySet()) {
                Result result = key.getValue().getTotal(type);

                if (result != null) {
                    return result;
                }
            }

            return null;
        }

        protected Result getTotalOfAll(Category category) {
            Result result = new Result(0);

            for (Map.Entry<String, Category> key : category.getYourList().entrySet()) {
                result.total += key.getValue().getTotalOfAll(key.getValue()).total;
            }

            return result;
        }
    }

    class Retirement extends Category {
        HashMap<String, Category> list;

        public Retirement() {
            list = new HashMap<String, Category>();
            list.put("Stocks", new Stocks());
            //list.put("Bonds", new Bonds());
        }

        @Override
        protected HashMap<String, Category> getYourList() {
            return list;
        }
    }

    class Stocks extends Category {

        HashMap<String, Category> list;

        public Stocks() {
            list = new HashMap<String, Category>();
            list.put("Tech", new Tech());
            //list.put("Retailer", new Retailer());
        }

        @Override
        protected HashMap<String, Category> getYourList() {
            return list;
        }
    }

    class Tech extends Category {
        HashMap<String, Integer> list;

        public Tech() {
            list = new HashMap<String, Integer>();
            list.put("AAPL", 10);
            list.put("MSFT", 20);
        }

        @Override
        public Result getTotal(String type) {
            if (list.containsKey(type)) {
                return new Result(list.get(type));
            }

            return null;
        }

        @Override
        public Result getTotalOfAll(Category category) {
            Result result = new Result(0);

            for (Integer price : list.values()) {
                result.total += price;
            }

            return result;
        }

        @Override
        protected HashMap<String, Category> getYourList() {
            return null;
        }
    }

    class Retailer extends Category {

        @Override
        protected HashMap<String, Category> getYourList() {
            return null;
        }


    }

    class Bonds extends Category {

        @Override
        protected HashMap<String, Category> getYourList() {
            return null;
        }
    }


    class Result {
        public int total;
        public boolean found;

        public Result(int total) {
            this.total = total;
            found = true;
        }
    }
}


