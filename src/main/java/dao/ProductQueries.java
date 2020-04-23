package dao;

public class ProductQueries {

    /**
     * SQL-запрос на получение товаров по категории. Используется в getAllProductsByCategory.
     * */
    protected static final String SELECT_GOODS_BY_CATEGORY = "SELECT * FROM goods WHERE category = ?";

    /**
     * SQL-запрос на получение товара по id. Используется в getProductById.
     * */
    protected static final String SELECT_GOODS_BY_ID = "SELECT * FROM goods WHERE id = ?";

    protected void queries (){
        /*Create cause SonarLint*/
    }
}
