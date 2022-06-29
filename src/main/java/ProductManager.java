public class ProductManager {
    // добавьте необходимые поля, конструкторы и методы
    private Repository repo;


    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.add(product);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
       /* if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }*/
        // или в одну строку:
        return product.getName().contains(search);
    }

}