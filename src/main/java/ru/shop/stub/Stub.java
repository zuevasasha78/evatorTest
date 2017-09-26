package ru.shop.stub;

import org.mockito.ArgumentMatcher;
import ru.shop.Shop;
import ru.shop.jsonScheme.Error;
import ru.shop.jsonScheme.GetProduct;
import ru.shop.jsonScheme.Product;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class Stub {

    public <T> T stubShop(Product product) throws Exception {
        Shop mockShop = mock(Shop.class);
        T result;

        when(mockShop.getProduct(argThat(matcher(product, 1)))).thenReturn(new GetProduct().setId(1).setName("apple").setPrice(1));
        when(mockShop.getProduct(argThat(matcher(product, 7)))).thenReturn(new Error().setDescription("Not Found").setCode(404));
        when(mockShop.getProduct(argThat(matcher(product, 2)))).thenReturn(new Error().setDescription("Bad Request").setCode(400));
        when(mockShop.getProduct(argThat(matcher(product, 4)))).thenReturn(new Error().setDescription("Incorrect Price").setCode(400));

        result = mockShop.getProduct(product);

        return result;
    }

    private ArgumentMatcher<Product> matcher(Product product, int id) {
        return prod -> product.getId().equals(id);
    }


/*    InterfaceForTest mockedObject = mock(InterfaceForTest.class);

    // create custom matcher for method argument
    Matcher<string> matcher = new ArgumentMatcher<string>() {
        @Override
        public boolean matches(Object argument) {
            return argument.equals("expectedValue") || argument.equals("EXPECTED_VALUE") ;
        }
    };

    // assign matcher to the method call
    when(mockedObject.processMethod(argThat(matcher))).thenReturn("returnedValue");

    // assert expected values
    assertEquals("returnedValue", mockedObject.processMethod("expectedValue"));
    assertEquals("returnedValue", mockedObject.processMethod("EXPECTED_VALUE"));
    assertNull(mockedObject.processMethod("not mocked value"));*/

}

