package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.ErrorListener;

import java.util.Arrays;

public class AddressList {
    private final Address[] addresses;

    public AddressList(Address... addresses) {
        this.addresses = addresses;
    }

    public void validate(ErrorListener listener) {
        for (Address address : addresses) {
            address.validate(listener);
        }
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        addToHeaders(result);
        return result.toString();
    }

    private void addToHeaders(StringBuilder result) {
        for (Address address : addresses) {
            result.append("To: ").append(address).append("\n");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressList that = (AddressList) o;
        return Arrays.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(addresses);
    }
}
