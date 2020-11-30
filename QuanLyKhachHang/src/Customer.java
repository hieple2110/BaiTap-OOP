public class Customer {
    private String name;
    private String address;
    private String numberPhone;
    private String email;
    private String gender;
    private int purchasedOrder = 0;


    public Customer() {
    }

    public Customer(String name, String address, String numberPhone, String email, String gender) {
        this.name = name;
        this.address = address;
        this.numberPhone = numberPhone;
        this.email = email;
        this.gender = gender;
    }

    public Customer(String name, String address, String numberPhone, String email, String gender, int purchasedOrder) {
        this.name = name;
        this.address = address;
        this.numberPhone = numberPhone;
        this.email = email;
        this.gender = gender;
        this.purchasedOrder = purchasedOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPurchasedOrder() {
        return purchasedOrder;
    }

    public void setPurchasedOrder(int purchasedOrder) {
        this.purchasedOrder = purchasedOrder;
    }



    @Override
    public String toString() {
        return "Customer name: " + name + " address: " + address + " numberPhone: " + numberPhone + " email: " + email +
                " gender: " + gender + " purchasedOrder: " + purchasedOrder;
    }
}
