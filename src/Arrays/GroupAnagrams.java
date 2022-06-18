package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>(strs.length);
        for (int i=0; i< strs.length; i++){
            char[] arr = new char[26];
            for (int j = 0; j<strs[i].length(); j++){
                arr[strs[i].charAt(j) - 'a'] ++;
            }
            String res = new String(arr);
            if (!resMap.containsKey(res)){
                resMap.put(res, new ArrayList<>());
            }
            resMap.get(res).add(strs[i]);
        }
        List<List<String>> resList = new ArrayList<>(strs.length);
        for (Map.Entry<String, List<String>> res: resMap.entrySet()){
            resList.add(res.getValue());
        }
        return resList;
    }

    public static void main(String[] args) {
        String[] strs = {"chi","nip","lab","mud","fan","yak","kid","lox","joy","rob","cad","hug","ken","oaf","pus","hos","ton","any","sac","mid","nip","ron","tux","set","jug","axe","ago","sob","ode","dot","nit","pug","sue","new","rub","sup","ohs","ski","oaf","don","cob","kin","ark","gay","jay","bur","dot","eat","rca","wad","maj","luz","gad","dam","eon","ark","del","sin","tat"};
        System.out.println(groupAnagrams(strs));
        //[[cad], [ton], [luz], [ron], [ago], [maj], [mid], [set], [hug], [nip, nip], [dam], [bur], [nit], [tat], [ken], [tux], [new], [axe], [gad], [fan], [sob], [don], [eon], [ski], [sac], [pus, sup], [del], [eat], [jug], [kid], [sue], [gay], [oaf, oaf], [pug], [cob], [sin], [yak], [rob], [ode], [wad], [rub], [kin], [any], [mud], [ark, ark], [dot, dot], [jay], [lox], [chi], [joy], [rca], [lab], [hos, ohs]]
        //[["del"],["eon"],["dam"],["tat"],["gad"],["luz"],["wad"],["kin"],["eat"],["cob"],["ski"],["bur","rub"],["new"],["sue"],["pug"],["ark","ark"],["dot","dot"],["maj"],["ken"],["sob"],["ton"],["sin"],["gay"],["nit"],["ode"],["joy"],["rob"],["ron"],["lox"],["kid"],["mid"],["nip","nip"],["mud"],["lab"],["ago"],["oaf","oaf"],["don"],["chi"],["rca"],["fan"],["pus","sup"],["jay"],["hos","ohs"],["cad"],["yak"],["any"],["sac"],["jug"],["tux"],["hug"],["axe"],["set"]]
    }

}
