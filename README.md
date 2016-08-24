Open a Terminal in the project folder and execute the command line below:

./gradlew bootRun

You can access at localhost:8080. Remember to pass JSESSIONID when adding, removing product or even checking the shopping cart.

***Tests

Simple tests to validate the getProducts, getShoppingCart, shoppingCartAdd and shoppingCartRemove methods.

* getProducts should return 3 products.
* getShoppingCart should return an empty but not null cart.
* shoppingCartAdd should add a quantity of 5 units of product 0001 and return an amount of 2500.
* shoppingCartRemove should add 1 product 0002 and remove it, returning an amount of 0.

Just run RunTests as JUnit Test or execute the following command line:

./gradlew test
