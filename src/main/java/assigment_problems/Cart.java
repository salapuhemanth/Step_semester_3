/**
 * Problem 5: The Shopping Cart
 * Category C - Assignment Problem 5
 *
 * Encapsulates shopping cart prices, computing total on request while shielding raw price records.
 */
public class Cart {
    private final String cartId;
    private final int[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.itemPrices = new int[maxItems];
        this.itemCount = 0;
    }

    public String getCartId() {
        return cartId;
    }

    public void addItem(int price) {
        if (itemCount < itemPrices.length) {
            itemPrices[itemCount++] = price;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + cart.getTotal());         // Expected: 500
        System.out.println("cart.getItemCount() -> " + cart.getItemCount()); // Expected: 3
    }
}