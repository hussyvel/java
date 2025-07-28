public class PhraseOMatic {
    public static void main(String[] args) {

        String[] wordListOne = {"24/7","multi-Tier","30,000 foot", "B-to-B","win-win", "front-end", "web-based" +
            "pervasive", "smart", "six- sigma","critical-path", "dynamic"};

        String[] wordListTwo = {"empowered", "sticky","value-added", "oriented", "centric", "distributed","clustered", "branded","outside-the-box", "positioned",
"networked", "focused", "leveraged", "aligned", "targeted", "shared", "cooperative", "accelerated"};

        String[] wordListThree = {"process", "tipping-point", "solution", "architecture", "core competency",
"strategy", "mindshare", "portal", "space", "vision","paradigm", "mission"};

    int oneLength = wordListOne.length;
    int twoLength = wordListTwo.length;
    int treeLength = wordListThree.length;

    int rand1 = (int) (Math.random() * oneLength);

        String phrase = wordListThree[rand1];

        System.out.println(phrase);

    }
}
