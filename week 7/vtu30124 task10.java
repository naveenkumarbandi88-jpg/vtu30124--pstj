import java.util.*;

class ThroneInheritance {
    private String king;
    private Map<String, List<String>> family;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.family = new HashMap<>();
        this.dead = new HashSet<>();
    }
    
    public void birth(String parentName, String childName) {
        family.putIfAbsent(parentName, new ArrayList<>());
        family.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        if (!dead.contains(current)) {
            order.add(current);
        }
        
        List<String> children = family.getOrDefault(current, Collections.emptyList());
        for (String child : children) {
            dfs(child, order);
        }
    }
}

Input
["ThroneInheritance","birth","birth","birth","birth","birth","birth","getInheritanceOrder","death","getInheritanceOrder"]
[["king"],["king","andy"],["king","bob"],["king","catherine"],["andy","matthew"],["bob","alex"],["bob","asha"],[null],["bob"],[null]]
Output
[null,null,null,null,null,null,null,["king","andy","matthew","bob","alex","asha","catherine"],null,["king","andy","matthew","alex","asha","catherine"]]
Expected
[null,null,null,null,null,null,null,["king","andy","matthew","bob","alex","asha","catherine"],null,["king","andy","matthew","alex","asha","catherine"]]
