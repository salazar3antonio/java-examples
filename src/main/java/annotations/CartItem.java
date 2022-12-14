package annotations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@JsonDeserialize // Used to specify a custom deserializer to unmarshall a JSON object.
@CustomAnnotation(targetClass = CartItem.class)
public class CartItem {
    private final int id;
    private final String name;
    private final double cost;

    CartItem(int id, @NotNull String name, double cost) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem cartItem)) return false;

        if (id != cartItem.id) return false;
        if (Double.compare(cartItem.cost, cost) != 0) return false;
        return name.equals(cartItem.name);
    }

    @Override // Method declaration is intended to override a method declaration in a supertype
    public int hashCode() {
        return Objects.hash(id, name, cost);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }



    public static void main(String[] args) {
        CartItem book1 = new CartItem(17, "Hitchhiker's Guide to the Galaxy", 7.14);
        CartItem book2 = new CartItem(17, "Hitchhiker's Guide to the Galaxy", 7.14);

        Set<CartItem> items = new HashSet<>();
        items.add(book1);
        items.add(book2);

        System.out.println(items.size());

    }
}
