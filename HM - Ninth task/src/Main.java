/**
 * Created by НР on 17-Nov-14.
 */
public class Main {

    static boolean Search(LinkListNode linkListNode, LinkListNode farLinkListNode){
        LinkListNode runner, fastRunner;
        runner = linkListNode;
        while(runner != farLinkListNode) {
            if (linkListNode != null & linkListNode.nextLL != null & farLinkListNode != null & farLinkListNode.nextLL != null) {
                fastRunner = farLinkListNode.nextLL;
            } else {
                return false;
            }
            runner = runner.nextLL;
            farLinkListNode = fastRunner.nextLL;

        }
        return true;
    }

    static boolean Trying(LinkListNode[] linkList){
        boolean ans;
        if(linkList[0] == null){
            System.out.println("It's empty\n");
            return false;
        }
        ans = Search(linkList[0], linkList[0].nextLL);
        if(ans){
            System.out.println("Ring");
        }
        else{
            System.out.println("Range");
        }
        return ans;
    }



    public static void main(String args[]){
        LinkListNode[] line = LinkListNode.Test();
        LinkListNode[] ring = LinkListNode.Ring();
        LinkListNode[] ll = new LinkListNode[10];

        Trying(ll);
        if(!Trying(line)){
            System.out.println("Okey\n");
        }
        else {
            System.out.println("Error\n");
        }
        if(Trying(ring)){
            System.out.println("Okey");
        }
        else {
            System.out.println("Error");
        }


    }

}
