/**
 * Created by НР on 08-Nov-14.
 */
public class LinkListNode {

    public LinkListNode nextLL = null;

    public int num;

    public LinkListNode(int x) {
        num = x;
    }

    public int BackInt() {
        return num;
    }

    public void test(LinkListNode arr[]) {
        LinkListNode linkListNode[] = new LinkListNode[100];
        linkListNode[0] = new LinkListNode(99);
        for (int i = 1; i < 100; i++) {
            linkListNode[i] = new LinkListNode(99 - i);
            linkListNode[i - 1].nextLL = linkListNode[i];
        }
        LinkListNode ll = arr[99], all = linkListNode[0];
        boolean ok = true;
        do {
            if (ll.BackInt() != all.BackInt()) {
                ok = false;
            }
            ll = ll.nextLL;
            all = all.nextLL;
        } while (ll != null);

        if (ok) {
            System.out.println("\nOkey");
        }
    }

    public static void Reverse(LinkListNode linkListNode) {
        LinkListNode previousLL = null;
        LinkListNode nextll = linkListNode;
        while (nextll != null) {
            linkListNode = nextll;
            nextll = linkListNode.nextLL;
            linkListNode.nextLL = previousLL;
            previousLL = linkListNode;
        }
    }
}
