package Lab2;

public class Main {

    public static void main(String[] args) {
        Item[] itemArray = {
                new Item(ItemType.VALUE, 2),  //2
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.STRANGE, 0),

                new Item(ItemType.VALUE, 0), //0
                new Item(ItemType.VALUE, 1),
                new Item(ItemType.MUL, 0),

                new Item(ItemType.ADD, 0),

                new Item(ItemType.VALUE, 0), //0
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.STRANGE, 0),  //001

                new Item(ItemType.ADD, 0),

                new Item(ItemType.VALUE, 1),
                new Item(ItemType.VALUE, 1),
                new Item(ItemType.MUL, 0),  // 1

                new Item(ItemType.ADD, 0),

                new Item(ItemType.VALUE, 2),
                new Item(ItemType.VALUE, 2),//1
                new Item(ItemType.STRANGE, 0),

                new Item(ItemType.ADD, 0),

                new Item(ItemType.VALUE, 1),
                new Item(ItemType.VALUE, 1),//2
                new Item(ItemType.MUL, 0),

                new Item(ItemType.ADD, 0),

                new Item(ItemType.VALUE, 2),
                new Item(ItemType.VALUE, 2), //2
                new Item(ItemType.STRANGE, 0),

                new Item(ItemType.ADD, 0),

                new Item(ItemType.VALUE, 1),
                new Item(ItemType.VALUE, 1),  //6
                new Item(ItemType.MUL, 0),

                new Item(ItemType.ADD, 0),

                new Item(ItemType.MOD, 0),
        };




        Calculator HP35 = new Calculator(itemArray);

        System.out.println(HP35.run());

    }
}




