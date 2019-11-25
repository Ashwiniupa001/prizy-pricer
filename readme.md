Clone Project
-------------
git clone https://github.com/Ashwiniupa001/prizy-pricer.git


App Usage
---------
cd prizy-pricer <br>
mvn clean install <br>
java -jar target/prizy-pricer-0.0.1.jar <br> 


Skip Tests
----------
mvn clean install -DskipTests <br>


Debug Mode
----------------
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar target/prizy-pricer-0.0.1.jar


Save Product
-------------
http://localhost:8080/pricer-service/product/

{
  "barcode": "B2",
  "description": "D2",
  "name": "P2",
  "productId": 2
}

Get all Product
-------------
http://localhost:8080/pricer-service/product/all


Save Survey Data
------------
http://localhost:8080/pricer-service/product-servey/

{
  "productId": 2,
  "price": 33.34,
  "storeName": "S5",
  "description": "D2"
}


Get Price Details
-----------------
http://localhost:8080/pricer-service/getIdealPrice/B2
 


Rule File
-----------------
Location of rule file is defined in application.properties file (rule.dir)




