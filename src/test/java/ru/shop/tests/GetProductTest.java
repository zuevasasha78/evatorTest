package ru.shop.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ru.shop.jsonScheme.Error;
import ru.shop.jsonScheme.GetProduct;
import ru.shop.jsonScheme.Product;
import ru.shop.stub.Stub;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Получение товара по id")
public class GetProductTest {
    private Stub stub = new Stub();

    @Description("Запрос получение товара по идентификатору. Проверка ответа. Успешное получение товара.")
    @Test()
    public void getProductSuccess() throws Exception {
        Integer id = 1;
        GetProduct result = stub.stubShop(new Product().setId(1));

        assertThat(result).isEqualToComparingFieldByField
                (new GetProduct().setId(1).setName("apple").setPrice(1));
    }

   @Description("Запрос получение товара по идентификатору. Проверка ответа. Товар не найден.")
    @Test()
    public void getProductNotFound() throws Exception {
        Error result = stub.stubShop(new Product().setId(7));

        assertThat(result).isEqualToComparingFieldByField
                (new Error().setDescription("Not Found").setCode(404));
    }

    @Description("Запрос получение товара по идентификатору. Отсутствие обязательных параметров.")
    @Test()
    public void getProductBadRequest() throws Exception {
        Error result = stub.stubShop(new Product().setId(2));

        assertThat(result).isEqualToComparingFieldByField
                (new Error().setDescription("Bad Request").setCode(400));
    }

    @Description("Запрос получение товара по идентификатору. У товара некорректная цена.")
    @Test()
    public void getProductIncorrectPrice() throws Exception {
        Error result = stub.stubShop(new Product().setId(4));

        assertThat(result).isEqualToComparingFieldByField
                (new Error().setDescription("Incorrect Price").setCode(400));
    }
}
