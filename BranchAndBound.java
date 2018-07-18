import java.util.*;
public class BranchAndBound {

    static int bestSoFar=100;
    static int count=0;
    public static void main(String args[]){
//create the universe
        int numU = 10;
        MySets universe = new MySets();
        for(int i=1;i<=numU;i++){
            universe.add(i);
        }
//create each set
        MySets s1 = new MySets();
        MySets s2 = new MySets();
        MySets s3 = new MySets();
        MySets s4 = new MySets();
        MySets s5 = new MySets();
        ArrayList<MySets> s=new ArrayList<MySets>();
//elements
        s1.add(1);s1.add(2);s1.add(3);s1.add(8);s1.add(9);s1.add(10);
        s2.add(1);s2.add(2);s2.add(3);s2.add(4);s2.add(5);
        s3.add(4);s3.add(5);s3.add(7);
        s4.add(5);s4.add(6);s4.add(7);
        s5.add(6);s5.add(7);s5.add(8);s5.add(9);s5.add(10);
        s.add(s1);s.add(s2);s.add(s3);s.add(s4);s.add(s5);
        branchAndBound(universe,s,0);
    }
    public static void branchAndBound(MySets U,ArrayList<MySets> listSets,int countSelected){
        MySets universe = new MySets();
        universe.addAll(U);
        ArrayList<MySets> s=new ArrayList<MySets>();
        s.addAll(listSets);
        MySets selectedSet= new MySets();
        selectedSet.addAll(listSets.get(0));
        count++;
        universe.removeAll(selectedSet);//the universe now contains the elements still need to be covered
        listSets.remove(0);//remove the first elemeent from the list
        displaySet(selectedSet,"selected set");
        displaySet(universe,"universe");
        while(!universe.isEmpty() &&!listSets.isEmpty()){
            branchAndBound(universe,listSets,count);
        }
    }
    public static void displaySet(MySets s, String name){
        System.out.print(name+"==>");
        Iterator it=s.iterator();
        while(it.hasNext()){
            Integer value=(Integer)it.next();
            System.out.print(+value+"");
        }//while
        System.out.println();
    }//displaySet
}