public class SmallBusiness {
    private String type; // Тип предприятия ("Магазин" или "Парикмахерская")
    private String name; // Название предприятия
    private String owner; // Имя владельца

    public SmallBusiness(String type, String name, String owner) {
        this.type = type;
        this.name = name;
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Тип: " + type + ", Название: " + name + ", Владелец: " + owner;
    }
}
