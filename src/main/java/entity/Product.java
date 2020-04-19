package entity;

public class Product {

    private int id;
    private String category;
    private String label;
    private int size;
    private int price;
    private String photo;
    private String description;

    public Product() {

    }

    public Product (int id) {
        this.id = id;
    }

    public Product (int id, String category, String label, int size, int price, String photo, String description) {
        this.id = id;
        this.category = category;
        this.label = label;
        this.size = size;
        this.price = price;
        this.photo = photo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
