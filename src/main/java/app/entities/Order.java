package app.entities;

public record Order(int number, int quanity, double price, double delivery, double total) {
    @Override
    public String toString() {
        return "Order -> number=%d, quantity=%d, price=%.2f, delivery=%.2f, total=%.2f".formatted(number, quanity, price, delivery, total);
    }
}
