package info.apatrix.foodapp.model;

public class History {
    private String date;
    private String order_id;
    private String price;

    public History(String date, String order_id, String price) {
        this.date = date;
        this.order_id = order_id;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
