

public class Main {

    public static void main(String[] args) {
        LinkListNode linkListNode[] = new LinkListNode[100], ll;
        linkListNode[0] = new LinkListNode(0);

        for (int i = 1; i < 100; i++){
            linkListNode[i] = new LinkListNode(i);
            linkListNode[i-1].nextLL = linkListNode[i];
        }

        ll = linkListNode[0];

        do{
            System.out.print(ll.BackInt() + " ");
            ll = ll.nextLL;
        }while (ll != null);
        System.out.println();

        LinkListNode.Reverse(linkListNode[0]);

        ll = linkListNode[99];
        do{
            System.out.print(ll.BackInt() + " ");
            ll = ll.nextLL;
        }while (ll != null);
        linkListNode[0].test(linkListNode);
    }
}
