package edu.ouc.contest78;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _811_Subdomain_Visit_Count {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains){
            int curCount = Integer.parseInt(cpdomain.split(" ")[0]);
            String domain = cpdomain.split(" ")[1];

            int index = 0;
            do{
                String s = domain.substring(index, domain.length());
                int cur = map.getOrDefault(s, 0);
                map.put(s, cur + curCount);
                index = domain.indexOf(".", index);
            }while (index++ != -1);
        }
        List<String> list = new LinkedList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int count = entry.getValue();
            String domain = entry.getKey();
            list.add(count + " " + domain);
        }
        return list;
    }

    public static void main(String args[]) {
        //test case1
        _811_Subdomain_Visit_Count
                tester = new _811_Subdomain_Visit_Count();
        String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(Arrays.toString(tester.subdomainVisits(input).toArray()));

    }
}
