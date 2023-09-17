import  java.util.List;
public class Notebook {
    private  String brand;

    private  Integer memory;

    private Integer harddisk;

    private String osystem;

    private String color;
    private  Integer id;

    private  Integer price;

    public Notebook(String brand, Integer memory, Integer harddisk, String osystem, String color, Integer id, Integer price){
        this.brand = brand;

        this.memory = memory;
        this.harddisk = harddisk;
        this.osystem = osystem;
        this.color = color;
        this.id = id;
        this.price = price;
    }


    @Override
    public String toString() {
        return "\n brand : " + brand + "\n memory : " + memory + "\n harddisk : " + harddisk + "\n osystem : " + osystem + "\n color : " + color + "\n id : " + id + "\n price : " + price + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Notebook)){
            return false;
        }
        Notebook notebook = (Notebook) obj;
        return brand.equals(notebook.brand)&& memory == notebook.memory && harddisk == notebook.harddisk &&  osystem.equals(notebook.osystem) &&  color.equals(notebook.color) && id == notebook.id && price == notebook.price;
    }

    @Override
    public int hashCode() {
        return 18 * id + 8 * brand.hashCode() + 9 * harddisk.hashCode() + 21 * memory.hashCode();
    }

    public int getByMemory(){
        return  memory;
    }
    public int getByHarddisk(){
        return harddisk;
    }

    public String getByOS(){
        return  osystem;
    }

    public String getByColor(){
        return  color;
    }
}

