/**
 * Created by НР on 17-Nov-14.
 */
public class LinkListNode {
    int num;
    public LinkListNode nextLL;



    LinkListNode(int x){
        num = x;
        nextLL = null;
    }



    public int BackInt() {
        return num;
    }

    public static LinkListNode[] Test() {
        LinkListNode linkListNode[] = new LinkListNode[100];
        linkListNode[0] = new LinkListNode(0);
        for (int i = 1; i < 100; i++) {
            linkListNode[i] = new LinkListNode(i);
            linkListNode[i - 1].nextLL = linkListNode[i];
        }
        return linkListNode;
    }

    public static LinkListNode[] Ring(){
        LinkListNode linkListNode[] = new LinkListNode[100];
        linkListNode[0] = new LinkListNode(0);
        for (int i = 1; i < 100; i++) {
            linkListNode[i] = new LinkListNode(i);
            linkListNode[i - 1].nextLL = linkListNode[i];
        }
        linkListNode[76]. nextLL = linkListNode[25];
        return linkListNode;
    }


}
