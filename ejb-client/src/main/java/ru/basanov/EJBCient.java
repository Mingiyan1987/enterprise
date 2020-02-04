package ru.basanov;

import ru.basanov.dao.ProductService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

public class EJBCient {

    public static void main(String[] args) throws IOException, NamingException {
        Context context = createInitialContext();
        ProductService productService = (ProductService) context.lookup("ejb:/base-jsf-app/ProductDAO!ru.basanov.dao.ProductService");
        productService.findAll().forEach(prod -> System.out.println(prod.getName()));
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EJBCient.class
                .getClassLoader()
                .getResourceAsStream("wildfly-jndi.properties"));
        return new InitialContext(env);
    }

}
